Ext.define('ecci.store.EtiquetasNoNecesidad', {
    extend: 'Ext.data.Store',
    alias: 'store.etiquetasNoNecesidad',
    storeId: 'etiquetasNoNecesidad',
    model: 'ecci.model.Etiqueta',
    proxy: {
        type: 'ajax',
        url: '../necesidades/etiquetasNecesidad',
        extraParams: {
            idnecesidad: 0,
            tipo: 'out'
        },
        reader: {
            type: 'json',
            rootProperty: 'etiquetas'
        }
    }
});
