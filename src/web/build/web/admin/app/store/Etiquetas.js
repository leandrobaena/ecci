Ext.define('ecci.store.Etiquetas', {
    extend: 'Ext.data.Store',
    alias: 'store.etiquetas',
    storeId: 'etiquetas',
    model: 'ecci.model.Etiqueta',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '../etiquetas/lista',
        reader: {
            type: 'json',
            rootProperty: 'etiquetas'
        }
    }
});
