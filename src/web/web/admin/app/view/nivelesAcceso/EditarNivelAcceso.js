Ext.define('ecci.view.nivelesAcceso.EditarNivelAcceso', {
    extend: 'Ext.window.Window',
    title: 'Editar nivel de acceso',
    alias: 'editarNivelAcceso',
    controller: 'nivelesAcceso',
    modal: true,
    items: [{
            xtype: 'form',
            bodyPadding: 10,
            url: '../nivelesAcceso/guardar',
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