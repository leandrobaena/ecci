Ext.define('ecci.view.etiquetas.EditarEtiqueta', {
    extend: 'Ext.window.Window',
    title: 'Editar etiqueta',
    alias: 'editarEtiqueta',
    controller: 'etiquetas',
    modal: true,
    items: [{
            xtype: 'form',
            bodyPadding: 10,
            url: '../etiquetas/guardar',
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