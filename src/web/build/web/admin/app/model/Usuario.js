Ext.define('ecci.model.Usuario', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'login', type: 'string'},
        {name: 'nombres', type: 'string'},
        {name: 'apellidos', type: 'string'},
        {name: 'activo', type: 'boolean'}
    ]
});