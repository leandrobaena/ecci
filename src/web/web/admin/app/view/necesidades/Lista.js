Ext.define('ecci.view.necesidades.Lista', {
    extend: 'Ext.tree.Panel',
    xtype: 'listaNecesidades',
    useArrows: true,
    rootVisible: false,
    requires: [
        'ecci.store.Necesidades',
        'ecci.view.necesidades.NecesidadesController'
    ],
    controller: 'necesidades',
    title: 'Necesidades',
    store: {
        model: 'ecci.model.Necesidad',
        storeId: 'necesidades',
        rootProperty: 'necesidades',
        proxy: {
            type: 'ajax',
            url: '../necesidades/lista',
            reader: {
                type: 'json',
                rootProperty: 'necesidades'
            }
        }
    },
    columns: [
        {xtype: 'treecolumn', text: 'Id', dataIndex: 'idnecesidad'},
        {text: 'Código', dataIndex: 'codigo', flex: 1},
        {text: 'Descripción', dataIndex: 'descripcion', flex: 9},
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
