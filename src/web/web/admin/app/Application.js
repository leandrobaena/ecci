Ext.define('ecci.Application', {
    extend: 'Ext.app.Application',
    name: 'ecci',
    quickTips: false,
    platformConfig: {
        desktop: {
            quickTips: true
        }
    },
    stores: [
    ],
    launch: function () {
    }
});
