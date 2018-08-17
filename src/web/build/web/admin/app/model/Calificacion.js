Ext.define('ecci.model.Calificacion', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'software', reference: 'Software'},
        {name: 'etiqueta', reference: 'Etiqueta'},
        {name: 'porcentaje', type: 'int'}
    ]
});