Ext.define('ecci.view.main.Main', {
    extend: 'Ext.tab.Panel',
    xtype: 'app-main',
    requires: [
        'Ext.plugin.Viewport',
        'Ext.window.MessageBox',
        'ecci.view.main.MainController',
        'ecci.view.usuarios.Lista',
        'ecci.view.grupos.Lista',
        'ecci.view.nivelesAcceso.Lista',
        'ecci.view.modulos.Lista'
    ],
    controller: 'main',
    ui: 'navigation',
    titleRotation: 0,
    tabRotation: 0,
    tabBar: {
        flex: 1,
        layout: {
            align: 'stretch',
            overflowHandler: 'scroller'
        }
    },
    responsiveConfig: {
        tall: {
            headerPosition: 'top'
        },
        wide: {
            headerPosition: 'left'
        }
    },
    defaults: {
        tabConfig: {
            plugins: 'responsive',
            responsiveConfig: {
                wide: {
                    iconAlign: 'left',
                    textAlign: 'left'
                },
                tall: {
                    iconAlign: 'top',
                    textAlign: 'center',
                    width: 120
                }
            }
        }
    },
    items: [{
            title: 'Usuarios',
            iconCls: 'fa-user',
            xtype: 'listaUsuarios'
        }, {
            title: 'Grupos',
            iconCls: 'fa-users',
            xtype: 'listaGrupos'
        }, {
            title: 'Niveles de acceso',
            iconCls: 'fa-lock',
            xtype: 'listaNivelesAcceso'
        }, {
            title: 'M&oacute;dulos',
            iconCls: 'fa-bars',
            xtype: 'listaModulos'
        }, {
            title: 'Escolaridades',
            iconCls: 'fa-graduation-cap'
        }, {
            title: 'Profesiones',
            iconCls: 'fa-briefcase'
        }, {
            title: 'Softwares',
            iconCls: 'fa-cogs'
        }, {
            title: 'Necesidades',
            iconCls: 'fa-comment'
        }, {
            title: 'Etiquetas',
            iconCls: 'fa-comment'
        }, {
            title: 'Solicitudes',
            iconCls: 'fa-file'
        }]
});
