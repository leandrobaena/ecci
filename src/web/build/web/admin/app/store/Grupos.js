Ext.define('ecci.store.Grupos', {
    extend: 'Ext.data.Store',
    alias: 'store.grupos',
    storeId: 'grupos',
    model: 'ecci.model.Grupo',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '../grupos/lista',
        reader: {
            type: 'json',
            rootProperty: 'grupos'
        }
    }
});
