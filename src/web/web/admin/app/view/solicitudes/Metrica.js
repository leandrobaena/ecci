Ext.define('ecci.view.solicitudes.Metrica', {
    extend: 'Ext.window.Window',
    title: 'Resultado de la métrica en la solicitud',
    alias: 'metrica',
    requires: [
        'ecci.store.Metrica'
    ],
    width: 800,
    modal: true,
    controller: 'solicitudes',
    items: [{
            xtype: 'panel',
            items: [{
                    xtype: 'grid',
                    store: {
                        type: 'metrica'
                    },
                    columns: [
                        {text: 'Software', dataIndex: 'nombre'},
                        {text: 'Descripci&oacute;n', dataIndex: 'descripcion', flex: 1},
                        {text: 'Licencia', dataIndex: 'licencia', flex: 1},
                        {text: 'Sitio descarga', dataIndex: 'url', flex: 1, renderer: function(value){ return '<a href="' + value + '" target="_blank">' + value + '</a>'; }},
                        {text: 'Versi&oacute;n', dataIndex: 'version', flex: 1},
                        {text: 'Necesidad', dataIndex: 'necesidad', flex: 1},
                        {text: 'Porcentaje', dataIndex: 'porcentaje', flex: 1}
                    ]
                }]
        }]
});