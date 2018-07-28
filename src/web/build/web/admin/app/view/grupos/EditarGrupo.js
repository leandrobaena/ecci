Ext.define('ecci.view.grupos.EditarGrupo', {
    extend: 'Ext.window.Window',
    title: 'Editar grupo',
    alias: 'editarGrupo',
    controller: 'grupos',
    items: [{
            xtype: 'form',
            bodyPadding: 10,
            url: '../grupos/guardar',
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