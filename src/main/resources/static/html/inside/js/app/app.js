/**
 * Created by lihaodi on 2016/7/20.
 */
angular.module('internal', ['controllers-data-transform', 'internal.filters',
        'services-base', 'services-data-transform', 'c.ad', 'c.modal', 'c.exception', "s.exception",
        'ui.router', 'ui.select', 'ui.bootstrap', 'ngFileUpload', 's.moment', 'datePicker', 'ngSanitize'
        , 's.employee', 'c.employee', 'c.demand'
    ]
    )
    .factory('HttpPostInterceptor', function ($q) {
        var urls = [];
        return {
            'request': function (request) {
                if (request.method === 'POST') {
                    var canceler = $q.defer();
                    if (urls.indexOf(request.url) != -1) {
                        //Promise 是 Deferred 响应数据的输出
                        //promise that should abort the request when resolved.
                        request.timeout = canceler.promise;
                        // Canceling request
                        canceler.resolve();
                        //重定向
                        request.url = '/wechat/timestamp';
                    } else {
                        urls.push(request.url);
                    }
                }
                return request;
            },
            'response': function (response) {
                if (response.config.method === 'POST') {
                    urls.remove(response.config.url);
                }
                return response;
            },
            'responseError': function (response) {
                if (response.config.method === 'POST') {
                    urls.remove(response.config.url);
                }
                return response;
            }
        };
    })
    .config(['$stateProvider', '$urlRouterProvider', '$locationProvider', '$provide', '$httpProvider',
        function ($stateProvider, $urlRouterProvider, $locationProvider, $provide, $httpProvider) {

            $httpProvider.interceptors.push('HttpPostInterceptor');


            $provide.decorator('mFormatFilter', function () {
                return function newFilter(m, format, tz) {
                    if (!(moment.isMoment(m))) {
                        return '';
                    }
                    return tz ? moment.tz(m, tz).format(format) : m.format(format);
                };
            });
            $urlRouterProvider
                .otherwise('/data-transform');
            $stateProvider
                .state('data-transform', {
                    url: '/data-transform',
                    templateUrl: 'data-transform.html',
                    controller: 'data-transform-list-ctrl'
                })
                .state('data-export', {
                    url: '/data-export',
                    templateUrl: 'data-export.html',
                    controller: 'data-export-ctrl'
                })
                .state('assert-detail', {
                    url: '/assert-detail/{batchId}',
                    templateUrl: 'assert-detail.html',
                    controller: 'assert-detail-ctrl'
                })
                .state('sheet-detail', {
                    url: '/sheet-detail/{batchId}/{model}/{sheetName}',
                    templateUrl: 'sheet-detail.html',
                    controller: 'sheet-detail-ctrl'
                })
                .state('feedback', {
                    url: '/feedback',
                    templateUrl: 'feedback.html',
                    controller: 'feedback-ctrl'
                })
                .state('wechat-template', {
                    url: '/wechat-template',
                    templateUrl: 'wechat-template.html',
                    controller: 'wechat-template-ctrl'
                })
                .state('wechat-template-delete', {
                    url: '/wechat-template-delete',
                    templateUrl: 'wechat-template-delete.html',
                    controller: 'wechat-template-delete-ctrl'
                })
                .state('wechat-menu', {
                    url: '/wechat-menu',
                    templateUrl: 'wechat-menu.html',
                    controller: 'wechat-menu-ctrl'
                })
                .state('feature-enroll', {//车店开通
                    url: '/feature-enroll',
                    templateUrl: 'feature-enroll.html',
                    controller: 'feature-enroll-ctrl'
                })
                .state('chain-shop', {//连锁关系
                    url: '/chain-shop',
                    templateUrl: 'chain-shop.html',
                    controller: 'chain-shop-ctrl'
                })
                .state('company-lakala', {
                    url: '/company-lakala',
                    templateUrl: 'company-lakala.html',
                    controller: 'company-lakala-ctrl'
                })
                .state('companyClear', {//车店数据清理
                    url: '/companyClear',
                    templateUrl: 'companyClear.html',
                    controller: 'company-clear-ctrl'
                })
                .state('demand-list', {//需求清单
                    url: '/demand-list',
                    templateUrl: 'view/demand/demand-list.html',
                    controller: 'demand-list-ctrl'
                })
                .state('demand-edit', {//需求编辑
                    url: '/demand-edit',
                    templateUrl: 'view/demand/demand-edit.html'
                })
                .state('demand-record', {//调研记录
                    url: '/demand-record',
                    templateUrl: 'view/demand/demand-record.html',
                    controller: 'demand-record-ctrl'
                })
                .state('ads', {//广告配置
                    url: '/ads',
                    templateUrl: 'ads.html',
                    controller: 'ads-ctrl'
                })
                .state('exception-logs', {//错误日志
                    url: '/exception-logs/{flattenMd5}/{flattenLength}',
                    templateUrl: 'exception/exception-logs.html',
                    controller: 'exception-logs-ctrl'
                })
                .state('role', {//权限设置
                    url: '/role',
                    templateUrl: 'role.html',
                    controller: 'role-ctrl'
                })
                .state('internalUser', {//内部成员
                    url: '/internalUser',
                    templateUrl: 'internalUser.html',
                    controller: 'internal-user-ctrl'
                })
                .state('apkUpdate',{//上传安卓apk更新包
                    url:'/apkUpdate',
                    templateUrl:'apkUpdate.html',
                    controller:'apk-update-ctrl'
                })
                .state('page-setting', {//网页样式
                    url: '/page-setting',
                    templateUrl: 'page-setting.html',
                    controller: 'page-setting-ctrl'
                });



        }]);