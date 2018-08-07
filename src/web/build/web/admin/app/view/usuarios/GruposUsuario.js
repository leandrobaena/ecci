Ext.define('ecci.view.usuarios.GruposUsuario', {
    extend: 'Ext.window.Window',
    title: 'Grupos del usuario',
    alias: 'gruposUsuario',
    requires: [
        'ecci.store.GruposUsuario',
        'ecci.store.GruposNoUsuario'
    ],
    width: 800,
    modal: true,
    controller: 'usuarios',
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
                    title: 'Grupos no asociados',
                    multiSelect: true,
                    id: 'gridSource',
                    store: {
                        type: 'gruposNoUsuario'
                    },
                    columns: [
                        {text: 'Id', dataIndex: 'id'},
                        {text: 'Nombre', dataIndex: 'nombre', flex: 1}
                    ],
                    viewConfig: {
                        plugins: {
                            ptype: 'gridviewdragdrop',
                            dragText: 'Arrastre hasta la tabla de grupo asociados para asociar al usuario',
                            dragGroup: 'source',
                            dropGroup: 'destination'
                        },
                        listeners: {
                            drop: 'removerGrupo'
                        }
                    }
                }, {
                    xtype: 'grid',
                    title: 'Grupos asociados',
                    multiSelect: true,
                    id: 'gridDestination',
                    store: {
                        type: 'gruposUsuario'
                    },
                    columns: [
                        {text: 'Id', dataIndex: 'id'},
                        {text: 'Nombre', dataIndex: 'nombre', flex: 1}
                    ],
                    viewConfig: {
                        plugins: {
                            ptype: 'gridviewdragdrop',
                            dragText: 'Arrastre hasta la tabla de grupo no asociados para quitar la asociación al usuario',
                            dragGroup: 'destination',
                            dropGroup: 'source'
                        },
                        listeners: {
                            drop: 'insertarGrupo'
                        }
                    }
                }]
        }]
});