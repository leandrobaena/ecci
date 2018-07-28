Ext.define('ecci.view.escolaridades.Lista', {
    extend: 'Ext.grid.Panel',
    xtype: 'listaEscolaridades',
    requires: [
        'ecci.store.Escolaridades',
        'ecci.view.escolaridades.EscolaridadesController'
    ],
    controller: 'escolaridades',
    title: 'Escolaridades',
    store: {
        type: 'escolaridades'
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
