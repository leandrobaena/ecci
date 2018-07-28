Ext.define('ecci.view.grupos.GruposController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.grupos',
    requires: [
        'ecci.view.grupos.EditarGrupo'
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
    }
});