Ext.define('ecci.view.necesidades.EtiquetasNecesidad', {
    extend: 'Ext.window.Window',
    title: 'Etiquetas de la necesidad',
    alias: 'etiquetasNecesidad',
    requires: [
        'ecci.store.EtiquetasNecesidad',
        'ecci.store.EtiquetasNoNecesidad'
    ],
    width: 800,
    modal: true,
    controller: 'necesidades',
    items: [{
            xtype: 'panel',
            bodyPadding: 10,
            layout: {
                type: 'hbox',
                align: 'stretch'
            },
            defaults: {
                flex: 1,
                padding: 5
            },
            items: [{
                    xtype: 'grid',
                    title: 'Etiquetas no asociados',
                    multiSelect: true,
                    id: 'gridSource',
                    store: {
                        type: 'etiquetasNoNecesidad'
                    },
                    columns: [
                        {text: 'Id', dataIndex: 'id'},
                        {text: 'Nombre', dataIndex: 'nombre', flex: 1}
                    ],
                    viewConfig: {
                        plugins: {
                            ptype: 'gridviewdragdrop',
                            dragText: 'Arrastre hasta la tabla de etiquetas asociadas para asociar la etiqueta',
                            dragGroup: 'source',
                            dropGroup: 'destination'
                        },
                        listeners: {
                            drop: 'removerEtiqueta'
                        }
                    }
                }, {
                    xtype: 'grid',
                    title: 'Etiquetas asociadas',
                    multiSelect: true,
                    id: 'gridDestination',
                    store: {
                        type: 'etiquetasNecesidad'
                    },
                    columns: [
                        {text: 'Id', dataIndex: 'id'},
                        {text: 'Nombre', dataIndex: 'nombre', flex: 1}
                    ],
                    viewConfig: {
                        plugins: {
                            ptype: 'gridviewdragdrop',
                            dragText: 'Arrastre hasta la tabla de etiquetas no asociadas para quitar la asociación a la necesidad',
                            dragGroup: 'destination',
                            dropGroup: 'source'
                        },
                        listeners: {
                            drop: 'insertarEtiqueta'
                        }
                    }
                }]
        }]
});