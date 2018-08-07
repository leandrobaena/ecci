Ext.define('ecci.view.escolaridades.EditarEscolaridad', {
    extend: 'Ext.window.Window',
    title: 'Editar escolaridad',
    alias: 'editarEscolaridad',
    controller: 'escolaridades',
    modal: true,
    items: [{
            xtype: 'form',
            bodyPadding: 10,
            url: '../escolaridades/guardar',
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