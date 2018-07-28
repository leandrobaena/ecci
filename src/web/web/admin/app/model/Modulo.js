Ext.define('ecci.model.Modulo', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'nombre', type: 'string'},
        {name: 'activo', type: 'boolean'}
    ]
});