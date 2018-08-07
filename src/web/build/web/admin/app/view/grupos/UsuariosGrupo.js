Ext.define('ecci.view.grupos.UsuariosGrupo', {
    extend: 'Ext.window.Window',
    title: 'Usuarios del grupo',
    alias: 'usuariosGrupo',
    requires: [
        'ecci.store.UsuariosGrupo',
        'ecci.store.UsuariosNoGrupo'
    ],
    width: 800,
    modal: true,
    controller: 'grupos',
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
                    title: 'Usuarios no asociados',
                    multiSelect: true,
                    id: 'gridSource',
                    store: {
                        type: 'usuariosNoGrupo'
                    },
                    columns: [
                        {text: 'Id', dataIndex: 'id'},
                        {text: 'Login', dataIndex: 'login', flex: 1}
                    ],
                    viewConfig: {
                        plugins: {
                            ptype: 'gridviewdragdrop',
                            dragText: 'Arrastre hasta la tabla de usuarios asociados para asociar al grupo',
                            dragGroup: 'source',
                            dropGroup: 'destination'
                        },
                        listeners: {
                            drop: 'removerUsuario'
                        }
                    }
                }, {
                    xtype: 'grid',
                    title: 'Usuarios asociados',
                    multiSelect: true,
                    id: 'gridDestination',
                    store: {
                        type: 'usuariosGrupo'
                    },
                    columns: [
                        {text: 'Id', dataIndex: 'id'},
                        {text: 'Login', dataIndex: 'login', flex: 1}
                    ],
                    viewConfig: {
                        plugins: {
                            ptype: 'gridviewdragdrop',
                            dragText: 'Arrastre hasta la tabla de usuarios no asociados para quitar la asociación al grupo',
                            dragGroup: 'destination',
                            dropGroup: 'source'
                        },
                        listeners: {
                            drop: 'insertarUsuario'
                        }
                    }
                }]
        }]
});