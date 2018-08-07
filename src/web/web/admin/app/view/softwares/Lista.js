Ext.define('ecci.view.softwares.Lista', {
    extend: 'Ext.grid.Panel',
    xtype: 'listaSoftwares',
    requires: [
        'ecci.store.Softwares',
        'ecci.view.softwares.SoftwaresController'
    ],
    controller: 'softwares',
    title: 'Softwares',
    store: {
        type: 'softwares'
    },
    columns: [
        {text: 'Id', dataIndex: 'id'},
        {text: 'Nombre', dataIndex: 'nombre', flex: 1},
        {text: 'Licencia', dataIndex: 'licencia', flex: 1},
        {text: 'Url', dataIndex: 'url', flex: 1},
        {text: 'Version', dataIndex: 'version', flex: 1},
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
