Ext.define('ecci.store.GruposUsuario', {
    extend: 'Ext.data.Store',
    alias: 'store.gruposUsuario',
    storeId: 'gruposUsuario',
    model: 'ecci.model.Grupo',
    proxy: {
        type: 'ajax',
        url: '../usuarios/gruposUsuario',
        extraParams: {
            idusuario: 0,
            tipo: 'in'
        },
        reader: {
            type: 'json',
            rootProperty: 'grupos'
        }
    }
});
