Ext.define('ecci.store.GruposNoUsuario', {
    extend: 'Ext.data.Store',
    alias: 'store.gruposNoUsuario',
    storeId: 'gruposNoUsuario',
    model: 'ecci.model.Grupo',
    proxy: {
        type: 'ajax',
        url: '../usuarios/gruposUsuario',
        extraParams: {
            idusuario: 0,
            tipo: 'out'
        },
        reader: {
            type: 'json',
            rootProperty: 'grupos'
        }
    }
});
