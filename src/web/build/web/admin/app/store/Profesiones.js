Ext.define('ecci.store.Profesiones', {
    extend: 'Ext.data.Store',
    alias: 'store.profesiones',
    storeId: 'profesiones',
    model: 'ecci.model.Profesion',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '../profesiones/lista',
        reader: {
            type: 'json',
            rootProperty: 'profesiones'
        }
    }
});
