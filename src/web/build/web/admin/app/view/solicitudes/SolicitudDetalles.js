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
                    store: {
                        type: 'solicitudDetalles'
                    },
                    columns: [
                        {text: 'Id', dataIndex: 'id'},
                        {text: 'Necesidad', dataIndex: 'necesidad', flex: 1},
                        {text: 'Justificacion', dataIndex: 'justificacion', flex: 1},
                        {text: 'Herramienta Actual', dataIndex: 'herramientaActual', flex: 1}
                    ]
                }]
        }]
});