Ext.define('ecci.store.Usuarios', {
    extend: 'Ext.data.Store',
    alias: 'store.usuarios',
    model: 'ecci.model.Usuario',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: './servlets/usuarios/lista',
        reader: {
            type: 'json',
            rootProperty: 'usuarios'
        }
    }
});
