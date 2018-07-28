Ext.define('ecci.view.nivelesAcceso.NivelesAccesoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.nivelesAcceso',
    requires: [
        'ecci.view.nivelesAcceso.EditarNivelAcceso'
    ],
    insertar: function () {
        var w = Ext.create('editarNivelAcceso');
        w.show();
    },
    editar: function (v, rn, c, i, e, rec, row) {
        var w = Ext.create('editarNivelAcceso');
        w.down('form').loadRecord(rec);
        w.show();
    },
    guardar: function (b) {
        b.up('form').submit({
            method: 'post',
            success: function (f, a) {
                Ext.MessageBox.show({
                    title: 'Nivel de acceso guardado',
                    msg: a.result.msg,
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.INFO,
                    fn: function () {
                        b.up('window').close();
                        Ext.getStore('nivelesAcceso').load();
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
        Ext.Msg.confirm('Confirmación', 'Desea eliminar el nivel de acceso?', function (b) {
            if (b === 'yes') {
                Ext.Ajax.request({
                    url: '../nivelesAcceso/eliminar',
                    method: 'post',
                    params: {
                        id: rec.get('id')
                    },
                    success: function (r) {
                        Ext.MessageBox.show({
                            title: 'Nivel de acceso eliminado',
                            msg: Ext.JSON.decode(r.responseText).msg,
                            buttons: Ext.Msg.OK,
                            icon: Ext.Msg.INFO,
                            fn: function () {
                                Ext.getStore('nivelesAcceso').load();
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