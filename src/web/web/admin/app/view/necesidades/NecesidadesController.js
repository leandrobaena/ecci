Ext.define('ecci.view.necesidades.NecesidadesController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.necesidades',
    requires: [
        'ecci.view.necesidades.EditarNecesidad',
        'ecci.view.necesidades.EtiquetasNecesidad'
    ],
    insertar: function () {
        var w = Ext.create('editarNecesidad');
        w.show();
    },
    editar: function (v, rn, c, i, e, rec, row) {
        var w = Ext.create('editarNecesidad');
        w.down('form').loadRecord(rec);
        if (rec.get('parentId') != "root") {
            w.down('form').getForm().findField('idnecesidadpadre').setValue(rec.get('parentId'));
        }
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
    },
    etiquetas: function (v, rn, c, i, e, rec, row) {
        Ext.create('etiquetasNecesidad').show();
        Ext.getStore('etiquetasNecesidad').getProxy().setExtraParam('idnecesidad', rec.get('id'));
        Ext.getStore('etiquetasNecesidad').load();
        Ext.getStore('etiquetasNoNecesidad').getProxy().setExtraParam('idnecesidad', rec.get('id'));
        Ext.getStore('etiquetasNoNecesidad').load();
    },
    insertarEtiqueta: function (n, d, dr, dp) {
        Ext.each(d.records, function (n, i, s) {
            Ext.Ajax.request({
                url: '../necesidades/asociarEtiqueta',
                params: {
                    tipo: 'in',
                    idnecesidad: Ext.getStore('etiquetasNecesidad').getProxy().extraParams.idnecesidad,
                    idetiqueta: n.get('id')
                },
                success: function (r, o) {
                    Ext.MessageBox.alert('Etiqueta asignada', 'Etiqueta asignada con \xe9xito');
                },
                failure: function () {
                    Ext.MessageBox.alert('Error', 'Error al asignar la etiqueta');
                }
            });
        });
    },
    removerEtiqueta: function (no, d, dr, dp) {
        Ext.each(d.records, function (n, i, s) {
            Ext.Ajax.request({
                url: '../necesidades/asociarEtiqueta',
                params: {
                    tipo: 'out',
                    idnecesidad: Ext.getStore('etiquetasNecesidad').getProxy().extraParams.idnecesidad,
                    idetiqueta: n.get('id')
                },
                success: function (r, o) {
                    Ext.MessageBox.alert('Etiqeuta eliminada', 'Etiqueta eliminada con \xe9xito');
                },
                failure: function () {
                    Ext.MessageBox.alert('Error', 'Error al eliminar la etiqueta');
                }
            });
        });
    }
});