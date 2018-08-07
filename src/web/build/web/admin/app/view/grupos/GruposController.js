Ext.define('ecci.view.grupos.GruposController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.grupos',
    requires: [
        'ecci.view.grupos.EditarGrupo',
        'ecci.view.grupos.UsuariosGrupo'
    ],
    insertar: function () {
        var w = Ext.create('editarGrupo');
        w.show();
    },
    editar: function (v, rn, c, i, e, rec, row) {
        var w = Ext.create('editarGrupo');
        w.down('form').loadRecord(rec);
        w.show();
    },
    guardar: function (b) {
        b.up('form').submit({
            method: 'post',
            success: function (f, a) {
                Ext.MessageBox.show({
                    title: 'Grupo guardado',
                    msg: a.result.msg,
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.INFO,
                    fn: function () {
                        b.up('window').close();
                        Ext.getStore('grupos').load();
                    }
                });
            },
            failure: function (f, a) {
                Ext.Msg.alert('Error', a.result.msg);
            }
        });
    },
    cerrar: function (b) {
        b.up('window').close();
    },
    eliminar: function (v, rn, c, i, e, rec, row) {
        Ext.Msg.confirm('Confirmación', 'Desea eliminar el grupo?', function (b) {
            if (b === 'yes') {
                Ext.Ajax.request({
                    url: '../grupos/eliminar',
                    method: 'post',
                    params: {
                        id: rec.get('id')
                    },
                    success: function (r) {
                        Ext.MessageBox.show({
                            title: 'Grupo eliminado',
                            msg: Ext.JSON.decode(r.responseText).msg,
                            buttons: Ext.Msg.OK,
                            icon: Ext.Msg.INFO,
                            fn: function () {
                                Ext.getStore('grupos').load();
                            }
                        });
                    },
                    failure: function (f, a) {
                        Ext.Msg.alert('Error', a.result.msg);
                    }
                });
            }
        });
    },
    usuarios: function (v, rn, c, i, e, rec, row) {
        Ext.create('usuariosGrupo').show();
        Ext.getStore('usuariosGrupo').getProxy().setExtraParam('idgrupo', rec.get('id'));
        Ext.getStore('usuariosGrupo').load();
        Ext.getStore('usuariosNoGrupo').getProxy().setExtraParam('idgrupo', rec.get('id'));
        Ext.getStore('usuariosNoGrupo').load();
    },
    insertarUsuario: function (n, d, dr, dp) {
        Ext.each(d.records, function (n, i, s) {
            Ext.Ajax.request({
                url: '../grupos/asociarUsuario',
                params: {
                    tipo: 'in',
                    idgrupo: Ext.getStore('usuariosGrupo').getProxy().extraParams.idgrupo,
                    idusuario: n.get('id')
                },
                success: function (r, o) {
                    Ext.MessageBox.alert('Usuario asignado', 'Usuario asignado con \xe9xito');
                },
                failure: function () {
                    Ext.MessageBox.alert('Error', 'Error al asignar el usuario');
                }
            });
        });
    },
    removerUsuario: function (no, d, dr, dp) {
        Ext.each(d.records, function (n, i, s) {
            Ext.Ajax.request({
                url: '../grupos/asociarUsuario',
                params: {
                    tipo: 'out',
                    idgrupo: Ext.getStore('usuariosGrupo').getProxy().extraParams.idgrupo,
                    idusuario: n.get('id')
                },
                success: function (r, o) {
                    Ext.MessageBox.alert('Usuario eliminado', 'Usuario eliminado con \xe9xito');
                },
                failure: function () {
                    Ext.MessageBox.alert('Error', 'Error al eliminar el usuario');
                }
            });
        });
    }
});