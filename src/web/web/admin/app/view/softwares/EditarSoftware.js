Ext.define('ecci.view.softwares.EditarSoftware', {
    extend: 'Ext.window.Window',
    title: 'Editar software',
    alias: 'editarSoftware',
    controller: 'softwares',
    modal: true,
    items: [{
            xtype: 'form',
            bodyPadding: 10,
            url: '../softwares/guardar',
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
                    fieldLabel: 'Descripcion',
                    xtype: 'textareafield',
                    name: 'descripcion',
                    allowBlank: false
                }, {
                    fieldLabel: 'Licencia',
                    name: 'licencia',
                    allowBlank: false
                }, {
                    fieldLabel: 'Url',
                    name: 'url',
                    vtype: 'url',
                    allowBlank: false
                }, {
                    fieldLabel: 'Version',
                    name: 'version',
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