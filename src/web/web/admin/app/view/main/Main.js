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
        'ecci.view.modulos.Lista',
        'ecci.view.escolaridades.Lista',
        'ecci.view.profesiones.Lista',
        'ecci.view.etiquetas.Lista',
        'ecci.view.softwares.Lista',
        'ecci.view.calificaciones.Lista',
        'ecci.view.necesidades.Lista',
        'ecci.view.solicitudes.Lista'
    ],
    controller: 'main',
    titleRotation: 0,
    tabRotation: 0,
    tabPosition: 'left',
    tabBar: {
        flex: 1,
        style: {
            backgroundColor: 'gray'
        },
        layout: {
            align: 'stretch',
            overflowHandler: 'scroller'
        }
    },
    responsiveConfig: {
        tall: {
            headerPosition: 'left'
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
            iconCls: 'x-fa fa-user',
            xtype: 'listaUsuarios'
        }, {
            title: 'Grupos',
            iconCls: 'x-fa fa-users',
            xtype: 'listaGrupos'
        }, {
            title: 'Niveles de acceso',
            iconCls: 'x-fa fa-lock',
            xtype: 'listaNivelesAcceso'
        }, {
            title: 'M&oacute;dulos',
            iconCls: 'x-fa fa-bars',
            xtype: 'listaModulos'
        }, {
            title: 'Permisos',
            iconCls: 'x-fa fa-exclamation-triangle'
        }, {
            title: 'Escolaridades',
            iconCls: 'x-fa fa-graduation-cap',
            xtype: 'listaEscolaridades'
        }, {
            title: 'Profesiones',
            iconCls: 'x-fa fa-briefcase',
            xtype: 'listaProfesiones'
        }, {
            title: 'Softwares',
            iconCls: 'x-fa fa-cogs',
            xtype: 'listaSoftwares'
        }, {
            title: 'Necesidades',
            iconCls: 'x-fa fa-list-ul',
            xtype: 'listaNecesidades'
        }, {
            title: 'Etiquetas',
            iconCls: 'x-fa fa-comment',
            xtype: 'listaEtiquetas'
        }, {
            title: 'Solicitudes',
            iconCls: 'x-fa fa-file',
            xtype: 'listaSolicitudes'
        }, {
            title: 'Calificaciones de software',
            iconCls: 'x-fa fa-check',
            xtype: 'listaCalificaciones'
        }, {
            title: 'Cerrar sesi&oacute;n',
            iconCls: 'x-fa fa-times'
        }
    ],
    listeners: {
        tabchange: function (tp, n, o, op) {
            if(n.title == "Cerrar sesi&oacute;n"){
                window.location = 'logout.jsp'
            }
        }
    }
});
