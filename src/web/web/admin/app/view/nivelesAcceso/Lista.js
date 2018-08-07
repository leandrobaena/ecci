Ext.define('ecci.view.nivelesAcceso.Lista', {
    extend: 'Ext.grid.Panel',
    xtype: 'listaNivelesAcceso',
    requires: [
        'ecci.store.NivelesAcceso',
        'ecci.view.nivelesAcceso.NivelesAccesoController'
    ],
    controller: 'nivelesAcceso',
    title: 'Niveles de acceso',
    store: {
        type: 'nivelesAcceso'
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
                    iconCls: 'x-fa fa-plus',
                    style: {
                        border: '1px #404040 solid'
                    },
                    handler: 'insertar'
                }]
        }]
});
