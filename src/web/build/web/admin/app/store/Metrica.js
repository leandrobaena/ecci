Ext.define('ecci.store.Metrica', {
    extend: 'Ext.data.Store',
    alias: 'store.metrica',
    storeId: 'metrica',
    model: 'ecci.model.Metrica',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '../solicitudes/metrica',
        extraParams: {
            idsolicitud: 0
        },
        reader: {
            type: 'json',
            rootProperty: 'metricas'
        }
    }
});
