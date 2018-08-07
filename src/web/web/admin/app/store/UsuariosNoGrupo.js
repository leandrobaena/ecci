Ext.define('ecci.store.UsuariosNoGrupo', {
    extend: 'Ext.data.Store',
    alias: 'store.usuariosNoGrupo',
    storeId: 'usuariosNoGrupo',
    model: 'ecci.model.Usuario',
    proxy: {
        type: 'ajax',
        url: '../grupos/usuariosGrupo',
        extraParams: {
            idgrupo: 0,
            tipo: 'out'
        },
        reader: {
            type: 'json',
            rootProperty: 'usuarios'
        }
    }
});
