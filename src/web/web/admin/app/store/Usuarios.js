Ext.define('ecci.store.Usuarios', {
    extend: 'Ext.data.Store',
    alias: 'store.usuarios',
    storeId: 'usuarios',
    model: 'ecci.model.Usuario',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '../usuarios/lista',
        reader: {
            type: 'json',
            rootProperty: 'usuarios'
        }
    }
});
