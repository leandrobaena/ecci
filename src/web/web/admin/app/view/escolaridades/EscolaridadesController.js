Ext.define('ecci.view.escolaridades.EscolaridadesController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.escolaridades',
    requires: [
        'ecci.view.escolaridades.EditarEscolaridad'
    ],
    insertar: function () {
        var w = Ext.create('editarEscolaridad');
        w.show();
    },
    editar: function (v, rn, c, i, e, rec, row) {
        var w = Ext.create('editarEscolaridad');
        w.down('form').loadRecord(rec);
        w.show();
    },
    guardar: function (b) {
        b.up('form').submit({
            method: 'post',
            success: function (f, a) {
                Ext.MessageBox.show({
                    title: 'Escolaridad guardada',
                    msg: a.result.msg,
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.INFO,
                    fn: function () {
                        b.up('window').close();
                        Ext.getStore('escolaridades').load();
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
        Ext.Msg.confirm('Confirmación', 'Desea eliminar la escolaridad?', function (b) {
            if (b === 'yes') {
                Ext.Ajax.request({
                    url: '../escolaridades/eliminar',
                    method: 'post',
                    params: {
                        id: rec.get('id')
                    },
                    success: function (r) {
                        Ext.MessageBox.show({
                            title: 'Escolaridad eliminada',
                            msg: Ext.JSON.decode(r.responseText).msg,
                            buttons: Ext.Msg.OK,
                            icon: Ext.Msg.INFO,
                            fn: function () {
                                Ext.getStore('escolaridades').load();
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