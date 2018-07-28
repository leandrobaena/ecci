Ext.define('ecci.view.usuarios.EditarUsuario', {
    extend: 'Ext.window.Window',
    title: 'Editar usuario',
    alias: 'editarUsuario',
    controller: 'usuarios',
    items: [{
            xtype: 'form',
            bodyPadding: 10,
            url: '../usuarios/guardar',
            defaultType: 'textfield',
            items: [{
                    name: 'id',
                    xtype: 'hiddenfield',
                    value: 0
                },{
                    fieldLabel: 'Login',
                    name: 'login',
                    allowBlank: false
                }, {
                    fieldLabel: 'Nombres',
                    name: 'nombres',
                    allowBlank: false
                }, {
                    fieldLabel: 'Apellidos',
                    name: 'apellidos',
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