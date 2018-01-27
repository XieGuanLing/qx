angular.module('s.employee', [])
    .factory('employeeService', function (httpService) {
        return {
            ctrl: '/internal/',
            authMark:{},
            hasAuth: function (code) {
                var codes = localStorage.getItem('internalAuthCode') || [];
                var authMark = codes.split(',');
                if(!authMark) return false;
                return this.isManager() || authMark.indexOf(code) != -1;
            },
            isManager: function () {
                var isManager = localStorage.getItem('isManager');
                return isManager == 'true';
            },

            saveInternalUser: function (data, success) {
                var url = this.ctrl + 'saveInternalUser';
                httpService.post(true, url, data, success);
            },
            updateInternalUser: function (data, success) {
                var url = this.ctrl + 'updateInternalUser';
                httpService.post(true, url, data, success);
            },
            queryInternalUser: function (data, success) {
                var url = this.ctrl + 'queryInternalUser';
                httpService.post(true, url, data, success);
            },
            deleteInternalUser: function (data, success) {
                var url = this.ctrl + 'deleteInternalUser';
                httpService.post(true, url, data, success);
            },
            listInternalUser :function (data, success) {
                var url = '/internal/listInternalUser';
                httpService.post(true, url, data, success);
            },
            saveInternalRole: function (data, success) {
                var url = this.ctrl + 'saveInternalRole';
                httpService.post(true, url, data, success);
            },
            updateInternalRole: function (data, success) {
                var url = this.ctrl + 'updateInternalRole';
                httpService.post(true, url, data, success);
            },
            deleteInternalRole: function (data, success) {
                var url = this.ctrl + 'deleteInternalRole';
                httpService.post(true, url, data, success);
            },
            listRoles: function ( success) {
                var url = this.ctrl + 'listRoles';
                httpService.post(true, url, {}, success);
            },
            listAuth: function (success) {
                var url = this.ctrl + 'listAuth';
                httpService.post(false, url, {}, success);
            },
            addRoleToUser: function (data, success) {
            var url = this.ctrl + 'addRoleToUser';
            httpService.post(true, url, data, success);
            },
            addRoleToUsers: function (data, success) {
                var url = this.ctrl + 'addRoleToUsers';
                httpService.post(true, url, data, success);
            },
            deleteRole : function (id, success) {
                var url = this.ctrl + 'deleteInternalRole';
                var data = {"id":id};
                httpService.post(false, url, data, success);
            }

        };
    });
