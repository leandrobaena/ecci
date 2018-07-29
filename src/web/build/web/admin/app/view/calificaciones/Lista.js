Ext.define('ecci.view.calificaciones.Lista', {
    extend: 'Ext.grid.Panel',
    xtype: 'listaCalificaciones',
    requires: [
        'ecci.store.Calificaciones',
        'ecci.view.calificaciones.CalificacionesController'
    ],
    controller: 'calificaciones',
    title: 'Calificaciones',
    store: {
        type: 'calificaciones'
    },
    columns: [
        {text: 'Id', dataIndex: 'id'},
        {text: 'Software', dataIndex: 'software', flex: 1, renderer: function (value) { return value.nombre; }},
        {text: 'Etiqueta', dataIndex: 'etiqueta', flex: 1, renderer: function (value) { return value.nombre; }},
        {text: 'Porcentaje', dataIndex: 'porcentaje', flex: 1},
        {xtype: 'actioncolumn', width: 50, items: [{
                    iconCls: 'x-fa fa-edit',
                    tooltip: 'Editar',
                    handler: 'editar'
                }, {
                    iconCls: 'x-fa fa-trash',
                    tooltip: 'Eliminar',
                    handler: 'eliminar'
                }]}
    ],
    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            displayInfo: true,
            items: [{
                    xtype: 'button',
                    text: 'Insertar',
                    handler: 'insertar'
                }]
        }]
});
