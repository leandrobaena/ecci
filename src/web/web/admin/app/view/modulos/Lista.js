Ext.define('ecci.view.modulos.Lista', {
    extend: 'Ext.grid.Panel',
    xtype: 'listaModulos',
    requires: [
        'ecci.store.Modulos',
        'ecci.view.modulos.ModulosController'
    ],
    controller: 'modulos',
    title: 'Módulos',
    store: {
        type: 'modulos'
    },
    columns: [
        {text: 'Id', dataIndex: 'id'},
        {text: 'Nombre', dataIndex: 'nombre', flex: 1},
        {text: 'Activo', dataIndex: 'activo', flex: 1, renderer: function (value) {
                return value ? "Si" : "No"
            }},
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
