Ext.define('ecci.model.SolicitudDetalle', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'solicitud', reference: 'Solicitud'},
        {name: 'necesidad', type: 'string'},
        {name: 'justificacion', type: 'string'},
        {name: 'herramientaActual', type: 'string'}
    ]
});