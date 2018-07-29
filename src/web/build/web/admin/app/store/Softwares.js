Ext.define('ecci.store.Softwares', {
    extend: 'Ext.data.Store',
    alias: 'store.softwares',
    storeId: 'softwares',
    model: 'ecci.model.Software',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '../softwares/lista',
        reader: {
            type: 'json',
            rootProperty: 'softwares'
        }
    }
});
