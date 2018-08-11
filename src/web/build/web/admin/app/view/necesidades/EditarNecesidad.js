Ext.define('ecci.view.necesidades.EditarNecesidad', {
    extend: 'Ext.window.Window',
    title: 'Editar necesidad',
    alias: 'editarNecesidad',
    controller: 'necesidades',
    modal: true,
    items: [{
            xtype: 'form',
            bodyPadding: 10,
            url: '../necesidades/guardar',
            defaultType: 'textfield',
            items: [{
                    name: 'id',
                    xtype: 'hiddenfield',
                    value: 0
                }, {
                    fieldLabel: 'Necesidad padre',
                    name: 'idnecesidadpadre',
                    xtype: 'combo',
                    store: {
                        model: 'ecci.model.Necesidad',
                        autoLoad: true,
                        rootProperty: 'necesidades',
                        proxy: {
                            type: 'ajax',
                            url: '../necesidades/lista',
                            reader: {
                                type: 'json',
                                rootProperty: 'necesidades'
                            }
                        }
                    },
                    value: '',
                    valueField: 'id',
                    displayField: 'codigo',
                    queryMode: 'local'
                }, {
                    fieldLabel: 'Código',
                    name: 'codigo',
                    allowBlank: false
                }, {
                    fieldLabel: 'Descripción',
                    name: 'descripcion',
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