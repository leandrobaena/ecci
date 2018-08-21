Ext.define('ecci.view.solicitudes.Lista', {
    extend: 'Ext.grid.Panel',
    xtype: 'listaSolicitudes',
    requires: [
        'ecci.store.Solicitudes',
        'ecci.store.SolicitudDetalles',
        'ecci.store.Metrica',
        'ecci.view.solicitudes.SolicitudesController'
    ],
    controller: 'solicitudes',
    title: 'Solicitudes',
    store: {
        type: 'solicitudes'
    },
    columns: [
        {text: 'Id', dataIndex: 'id'},
        {text: 'Fecha', dataIndex: 'fecha', flex: 1, format: 'Y-m-d', renderer: Ext.util.Format.dateRenderer('Y-m-d')},
        {text: 'Nombre', dataIndex: 'nombre', flex: 1},
        {text: 'Email', dataIndex: 'email', flex: 1},
        {text: 'Escolaridad', dataIndex: 'escolaridad', flex: 1, renderer: function (value) {
                return value.nombre;
            }
        },
        {text: 'Profesion', dataIndex: 'profesion', flex: 1, renderer: function (value) {
                return value.nombre;
            }
        },
        {
            xtype: 'actioncolumn',
            width: 50,
            items: [{
                    iconCls: 'x-fa fa-info-circle',
                    tooltip: 'Detalles',
                    handler: 'detalles'
                },{
                    iconCls: 'x-fa fa-list-ol',
                    tooltip: 'M&eacute;trica',
                    handler: 'metrica'
                }]
        }
    ],
    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            displayInfo: true
        }]
});
