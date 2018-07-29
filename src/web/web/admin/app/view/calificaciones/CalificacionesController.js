Ext.define('ecci.view.calificaciones.CalificacionesController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.calificaciones',
    requires: [
        'ecci.view.calificaciones.EditarCalificacion'
    ],
    insertar: function () {
        var w = Ext.create('editarCalificacion');
        w.show();
    },
    editar: function (v, rn, c, i, e, rec, row) {
        var w = Ext.create('editarCalificacion');
        w.down('form').loadRecord(rec);
        w.down('form').getForm().findField('idsoftware').setValue(rec.get('software').id);
        w.down('form').getForm().findField('idetiqueta').setValue(rec.get('etiqueta').id);
        w.show();
    },
    guardar: function (b) {
        b.up('form').submit({
            method: 'post',
            success: function (f, a) {
                Ext.MessageBox.show({
                    title: 'Calificación guardada',
                    msg: a.result.msg,
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.INFO,
                    fn: function () {
                        b.up('window').close();
                        Ext.getStore('calificaciones').load();
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
        Ext.Msg.confirm('Confirmación', 'Desea eliminar la calificación?', function (b) {
            if (b === 'yes') {
                Ext.Ajax.request({
                    url: '../calificaciones/eliminar',
                    method: 'post',
                    params: {
                        id: rec.get('id')
                    },
                    success: function (r) {
                        Ext.MessageBox.show({
                            title: 'Calificación eliminada',
                            msg: Ext.JSON.decode(r.responseText).msg,
                            buttons: Ext.Msg.OK,
                            icon: Ext.Msg.INFO,
                            fn: function () {
                                Ext.getStore('calificaciones').load();
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