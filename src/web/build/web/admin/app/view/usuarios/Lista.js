Ext.define('ecci.view.usuarios.Lista', {
    extend: 'Ext.grid.Panel',
    xtype: 'listaUsuarios',
    requires: [
        'ecci.store.Usuarios',
        'ecci.view.usuarios.UsuariosController'
    ],
    controller: 'usuarios',
    title: 'Usuarios',
    store: {
        type: 'usuarios'
    },
    columns: [
        {text: 'Id', dataIndex: 'id'},
        {text: 'Login', dataIndex: 'login', flex: 1},
        {text: 'Nombres', dataIndex: 'nombres', flex: 1},
        {text: 'Apellidos', dataIndex: 'apellidos', flex: 1},
        {text: 'Activo', dataIndex: 'activo', flex: 1, renderer: function (value) {
                return value ? "Si" : "No"
            }
        }, {
            xtype: 'actioncolumn',
            width: 75,
            items: [{
                    iconCls: 'x-fa fa-users',
                    tooltip: 'Grupos',
                    handler: 'grupos'
                }, {
                    iconCls: 'x-fa fa-edit',
                    tooltip: 'Editar',
                    handler: 'editar'
                }, {
                    iconCls: 'x-fa fa-trash',
                    tooltip: 'Eliminar',
                    handler: 'eliminar'
                }]}
    ],
    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            displayInfo: true,
            items: [{
                    xtype: 'button',
                    text: 'Insertar',
                    iconCls: 'x-fa fa-plus',
                    style: {
                        border: '1px #404040 solid'
                    },
                    handler: 'insertar'
                }]
        }]
});

