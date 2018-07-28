Ext.define('ecci.store.Escolaridades', {
    extend: 'Ext.data.Store',
    alias: 'store.escolaridades',
    storeId: 'escolaridades',
    model: 'ecci.model.Escolaridad',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '../escolaridades/lista',
        reader: {
            type: 'json',
            rootProperty: 'escolaridades'
        }
    }
});
