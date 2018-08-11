Ext.define('ecci.store.Necesidades', {
    extend: 'Ext.data.TreeStore',
    alias: 'store.necesidades',
    storeId: 'necesidades',
    model: 'ecci.model.Necesidad',
    autoLoad: true
});
