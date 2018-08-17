Ext.define('ecci.view.solicitudes.SolicitudDetalles', {
    extend: 'Ext.window.Window',
    title: 'Detalles de la solicitud',
    alias: 'solicitudDetalles',
    requires: [
        'ecci.store.SolicitudDetalles'
    ],
    width: 800,
    modal: true,
    controller: 'solicitudes',
    items: [{
            xtype: 'panel',
            items: [{
                    xtype: 'grid',
                    title: 'Detalles',
                    store: {
                        type: 'SolicitudDetalles'
                    },
                    columns: [
                        {text: 'Id', dataIndex: 'id'},
                        {text: 'Login', dataIndex: 'login', flex: 1}
                    ]
                }]
        }]
});