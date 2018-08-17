Ext.define('ecci.store.Solicitudes', {
    extend: 'Ext.data.Store',
    alias: 'store.solicitudes',
    storeId: 'solicitudes',
    model: 'ecci.model.Solicitud',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '../solicitudes/lista',
        reader: {
            type: 'json',
            rootProperty: 'solicitudes'
        }
    }
});
