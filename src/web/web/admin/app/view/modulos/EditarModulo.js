Ext.define('ecci.view.modulos.EditarModulo', {
    extend: 'Ext.window.Window',
    title: 'Editar módulo',
    alias: 'editarModulo',
    controller: 'modulos',
    modal: true,
    items: [{
            xtype: 'form',
            bodyPadding: 10,
            url: '../modulos/guardar',
            defaultType: 'textfield',
            items: [{
                    name: 'id',
                    xtype: 'hiddenfield',
                    value: 0
                }, {
                    fieldLabel: 'Nombre',
                    name: 'nombre',
                    allowBlank: false
                }, {
                    fieldLabel: 'Activo',
                    xtype: 'combobox',
                    name: 'activo',
                    store: [[false, "No"], [true, "Si"]],
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