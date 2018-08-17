Ext.define('ecci.view.solicitudes.SolicitudesController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.solicitudes',
    requires: [
        'ecci.view.solicitudes.SolicitudDetalles'
    ],
    detalles: function (v, rn, c, i, e, rec, row) {
        Ext.create('solicitudDetalles').show();
        Ext.getStore('solicitudDetalles').getProxy().setExtraParam('idsolicitud', rec.get('id'));
        Ext.getStore('solicitudDetalles').load();
    }
});