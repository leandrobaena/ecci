Ext.define('ecci.model.Software', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'nombre', type: 'string'},
        {name: 'descripcion', type: 'string'},
        {name: 'licencia', type: 'string'},
        {name: 'url', type: 'string'},
        {name: 'version', type: 'string'}
    ]
});