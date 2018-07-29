Ext.define('ecci.model.Calificacion', {
    extend: 'Ext.data.Model',
    require: ['ecci.model.Software'],
    fields: [
        {name: 'id', type: 'int'},
        {name: 'software', reference: 'Software'},
        {name: 'etiqueta', reference: 'Etiqueta'},
        {name: 'porcentaje', type: 'int'}
    ]
});