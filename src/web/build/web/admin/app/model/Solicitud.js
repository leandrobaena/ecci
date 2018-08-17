Ext.define('ecci.model.Solicitud', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'fecha', type: 'date', dateFormat: 'Y-m-d'},
        {name: 'nombre', type: 'string'},
        {name: 'email', type: 'string'},
        {name: 'escolaridad', reference: 'Escolaridad'},
        {name: 'profesion', reference: 'Profesion'}
    ]
});