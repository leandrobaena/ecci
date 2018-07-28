Ext.define('ecci.store.NivelesAcceso', {
    extend: 'Ext.data.Store',
    alias: 'store.nivelesAcceso',
    storeId: 'nivelesAcceso',
    model: 'ecci.model.NivelAcceso',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '../nivelesAcceso/lista',
        reader: {
            type: 'json',
            rootProperty: 'nivelesAcceso'
        }
    }
});
