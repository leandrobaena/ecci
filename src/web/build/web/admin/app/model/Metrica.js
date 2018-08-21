Ext.define('ecci.model.Metrica', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'nombre', type: 'string'},
        {name: 'descripcion', type: 'string'},
        {name: 'licencia', type: 'string'},
        {name: 'url', type: 'string'},
        {name: 'version', type: 'string'},
        {name: 'necesidad', type: 'string'},
        {name: 'porcentaje', type: 'int'}
    ]
});