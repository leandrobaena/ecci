Ext.define('ecci.view.calificaciones.EditarCalificacion', {
    extend: 'Ext.window.Window',
    title: 'Editar calificación',
    alias: 'editarCalificacion',
    controller: 'calificaciones',
    modal: true,
    items: [{
            xtype: 'form',
            bodyPadding: 10,
            url: '../calificaciones/guardar',
            defaultType: 'textfield',
            items: [{
                    name: 'id',
                    xtype: 'hiddenfield',
                    value: 0
                }, {
                    xtype: 'combo',
                    name: 'idsoftware',
                    value: '',
                    store: 'softwares',
                    valueField: 'id',
                    displayField: 'nombre',
                    allowBlank: false,
                    fieldLabel: 'Software',
                    queryMode: 'local'
                }, {
                    xtype: 'combo',
                    name: 'idetiqueta',
                    value: '',
                    store: 'etiquetas',
                    valueField: 'id',
                    displayField: 'nombre',
                    allowBlank: false,
                    fieldLabel: 'Etiqueta',
                    queryMode: 'local'
                }, {
                    name: 'porcentaje',
                    fieldLabel: 'Porcentaje',
                    xtype: 'numberfield',
                    value: 0,
                    hideTrigger: true,
                    minValue: 1,
                    maxValue: 100
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