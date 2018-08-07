Ext.define('ecci.view.usuarios.UsuariosController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.usuarios',
    requires: [
        'ecci.view.usuarios.EditarUsuario',
        'ecci.view.usuarios.GruposUsuario'
    ],
    insertar: function () {
        var w = Ext.create('editarUsuario');
        w.show();
    },
    editar: function (v, rn, c, i, e, rec, row) {
        var w = Ext.create('editarUsuario');
        w.down('form').loadRecord(rec);
        w.show();
    },
    guardar: function (b) {
        b.up('form').submit({
            method: 'post',
            success: function (f, a) {
                Ext.MessageBox.show({
                    title: 'Usuario guardado',
                    msg: a.result.msg,
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.INFO,
                    fn: function () {
                        b.up('window').close();
                        Ext.getStore('usuarios').load();
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
        Ext.Msg.confirm('Confirmación', 'Desea eliminar el usuario?', function (b) {
            if (b === 'yes') {
                Ext.Ajax.request({
                    url: '../usuarios/eliminar',
                    method: 'post',
                    params: {
                        id: rec.get('id')
                    },
                    success: function (r) {
                        Ext.MessageBox.show({
                            title: 'Usuario eliminado',
                            msg: Ext.JSON.decode(r.responseText).msg,
                            buttons: Ext.Msg.OK,
                            icon: Ext.Msg.INFO,
                            fn: function () {
                                Ext.getStore('usuarios').load();
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
    grupos: function (v, rn, c, i, e, rec, row) {
        Ext.create('gruposUsuario').show();
        Ext.getStore('gruposUsuario').getProxy().setExtraParam('idusuario', rec.get('id'));
        Ext.getStore('gruposUsuario').load();
        Ext.getStore('gruposNoUsuario').getProxy().setExtraParam('idusuario', rec.get('id'));
        Ext.getStore('gruposNoUsuario').load();
    },
    insertarGrupo: function (n, d, dr, dp) {
        Ext.each(d.records, function (n, i, s) {
            Ext.Ajax.request({
                url: '../usuarios/asociarGrupo',
                params: {
                    tipo: 'in',
                    idusuario: Ext.getStore('gruposUsuario').getProxy().extraParams.idusuario,
                    idgrupo: n.get('id')
                },
                success: function (r, o) {
                    Ext.MessageBox.alert('Grupo asignado', 'Grupo asignado con \xe9xito');
                },
                failure: function () {
                    Ext.MessageBox.alert('Error', 'Error al asignar el grupo');
                }
            });
        });
    },
    removerGrupo: function (no, d, dr, dp) {
        Ext.each(d.records, function (n, i, s) {
            Ext.Ajax.request({
                url: '../usuarios/asociarGrupo',
                params: {
                    tipo: 'out',
                    idusuario: Ext.getStore('gruposUsuario').getProxy().extraParams.idusuario,
                    idgrupo: n.get('id')
                },
                success: function (r, o) {
                    Ext.MessageBox.alert('Grupo eliminado', 'Grupo eliminado con \xe9xito');
                },
                failure: function () {
                    Ext.MessageBox.alert('Error', 'Error al eliminar el grupo');
                }
            });
        });
    }
});