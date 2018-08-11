Ext.define('ecci.view.necesidades.NecesidadesController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.necesidades',
    requires: [
        'ecci.view.necesidades.EditarNecesidad'
    ],
    insertar: function () {
        var w = Ext.create('editarNecesidad');
        w.show();
    },
    editar: function (v, rn, c, i, e, rec, row) {
        var w = Ext.create('editarNecesidad');
        w.down('form').loadRecord(rec);
        w.down('form').getForm().findField('idnecesidadpadre').setValue(rec.get('parentId'));
        w.show();
    },
    guardar: function (b) {
        b.up('form').submit({
            method: 'post',
            success: function (f, a) {
                Ext.MessageBox.show({
                    title: 'Necesidad guardada',
                    msg: a.result.msg,
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.INFO,
                    fn: function () {
                        b.up('window').close();
                        Ext.getStore('necesidades').load();
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
        Ext.Msg.confirm('Confirmación', 'Desea eliminar la necesidad?', function (b) {
            if (b === 'yes') {
                Ext.Ajax.request({
                    url: '../necesidades/eliminar',
                    method: 'post',
                    params: {
                        id: rec.get('id')
                    },
                    success: function (r) {
                        Ext.MessageBox.show({
                            title: 'Necesidad eliminada',
                            msg: Ext.JSON.decode(r.responseText).msg,
                            buttons: Ext.Msg.OK,
                            icon: Ext.Msg.INFO,
                            fn: function () {
                                Ext.getStore('necesidades').load();
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