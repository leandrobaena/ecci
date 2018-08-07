Ext.define('ecci.store.UsuariosGrupo', {
    extend: 'Ext.data.Store',
    alias: 'store.usuariosGrupo',
    storeId: 'usuariosGrupo',
    model: 'ecci.model.Usuario',
    proxy: {
        type: 'ajax',
        url: '../grupos/usuariosGrupo',
        extraParams: {
            idgrupo: 0,
            tipo: 'in'
        },
        reader: {
            type: 'json',
            rootProperty: 'usuarios'
        }
    }
});
