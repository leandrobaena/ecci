Ext.define('ecci.view.profesiones.EditarProfesion', {
    extend: 'Ext.window.Window',
    title: 'Editar profesión',
    alias: 'editarProfesion',
    controller: 'profesiones',
    modal: true,
    items: [{
            xtype: 'form',
            bodyPadding: 10,
            url: '../profesiones/guardar',
            defaultType: 'textfield',
            items: [{
                    name: 'id',
                    xtype: 'hiddenfield',
                    value: 0
                }, {
                    fieldLabel: 'Nombre',
                    name: 'nombre',
                    allowBlank: false
                }],
            buttons: [{
                    text: 'Aceptar',
                    handler: 'guardar',
                    formBind: true
                }, {
                    text: 'Cancelar',
                    handler: 'cerrar'
                }]
        }]
});