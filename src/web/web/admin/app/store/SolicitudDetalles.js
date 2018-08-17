Ext.define('ecci.store.SolicitudDetalles', {
    extend: 'Ext.data.Store',
    alias: 'store.solicitudDetalles',
    storeId: 'solicitudDetalles',
    model: 'ecci.model.SolicitudDetalle',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '../solicitudes/listaDetalle',
        extraParams: {
            idsolicitud: 0
        },
        reader: {
            type: 'json',
            rootProperty: 'solicitudDetalles'
        }
    }
});
