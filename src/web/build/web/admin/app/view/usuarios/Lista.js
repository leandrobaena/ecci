/**
 * This view is an example list of people.
 */
Ext.define('ecci.view.usuarios.Lista', {
    extend: 'Ext.grid.Panel',
    xtype: 'listaUsuarios',
    requires: [
        'ecci.store.Usuarios'
    ],
    title: 'Usuarios',
    store: {
        type: 'usuarios'
    },
    columns: [
        { text: 'Id',  dataIndex: 'id' },
        { text: 'Login', dataIndex: 'login', flex: 1 },
        { text: 'Nombres', dataIndex: 'nombres', flex: 1 },
        { text: 'Apellidos', dataIndex: 'apellidos', flex: 1 },
        { text: 'Activo', dataIndex: 'activo', flex: 1 }
    ],
    listeners: {
        select: 'onItemSelected'
    }
});
