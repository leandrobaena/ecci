Ext.define('ecci.store.Calificaciones', {
    extend: 'Ext.data.Store',
    alias: 'store.calificaciones',
    storeId: 'calificaciones',
    model: 'ecci.model.Calificacion',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '../calificaciones/lista',
        reader: {
            type: 'json',
            rootProperty: 'calificaciones'
        }
    }
});
