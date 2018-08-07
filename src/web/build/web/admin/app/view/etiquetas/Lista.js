Ext.define('ecci.view.etiquetas.Lista', {
    extend: 'Ext.grid.Panel',
    xtype: 'listaEtiquetas',
    requires: [
        'ecci.store.Etiquetas',
        'ecci.view.etiquetas.EtiquetasController'
    ],
    controller: 'etiquetas',
    title: 'Etiquetas',
    store: {
        type: 'etiquetas'
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
