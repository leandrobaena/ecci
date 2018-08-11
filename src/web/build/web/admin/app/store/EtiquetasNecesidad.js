Ext.define('ecci.store.EtiquetasNecesidad', {
    extend: 'Ext.data.Store',
    alias: 'store.etiquetasNecesidad',
    storeId: 'etiquetasNecesidad',
    model: 'ecci.model.Etiqueta',
    proxy: {
        type: 'ajax',
        url: '../necesidades/etiquetasNecesidad',
        extraParams: {
            idnecesidad: 0,
            tipo: 'in'
        },
        reader: {
            type: 'json',
            rootProperty: 'etiquetas'
        }
    }
});
