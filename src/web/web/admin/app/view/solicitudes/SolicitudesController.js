Ext.define('ecci.view.solicitudes.SolicitudesController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.solicitudes',
    requires: [
        'ecci.view.solicitudes.SolicitudDetalles',
        'ecci.view.solicitudes.Metrica'
    ],
    detalles: function (v, rn, c, i, e, rec, row) {
        Ext.create('solicitudDetalles').show();
        Ext.getStore('solicitudDetalles').getProxy().setExtraParam('idsolicitud', rec.get('id'));
        Ext.getStore('solicitudDetalles').load();
    },
    metrica: function (v, rn, c, i, e, rec, row) {
        Ext.create('metrica').show();
        Ext.getStore('metrica').getProxy().setExtraParam('idsolicitud', rec.get('id'));
        Ext.getStore('metrica').load();
    }
});