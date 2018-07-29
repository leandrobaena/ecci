Ext.define('ecci.view.profesiones.Lista', {
    extend: 'Ext.grid.Panel',
    xtype: 'listaProfesiones',
    requires: [
        'ecci.store.Profesiones',
        'ecci.view.profesiones.ProfesionesController'
    ],
    controller: 'profesiones',
    title: 'Profesiones',
    store: {
        type: 'profesiones'
    },
    columns: [
        {text: 'Id', dataIndex: 'id'},
        {text: 'Nombre', dataIndex: 'nombre', flex: 1},
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
