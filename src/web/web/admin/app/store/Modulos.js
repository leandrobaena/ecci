Ext.define('ecci.store.Modulos', {
    extend: 'Ext.data.Store',
    alias: 'store.modulos',
    storeId: 'modulos',
    model: 'ecci.model.Modulo',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '../modulos/lista',
        reader: {
            type: 'json',
            rootProperty: 'modulos'
        }
    }
});
