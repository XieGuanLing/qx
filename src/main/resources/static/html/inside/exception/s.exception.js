/**
 * Created by somebody on 2017/7/31.
 */
angular.module("s.exception", [])
    .factory('exceptionLogService', function (httpService) {
        return {
            query: function (q, success) {
                var url = '/internal/exceptionLog/query';
                httpService.post(true, url, q, success);
            },
            resolve: function (m, success) {
                var url = '/internal/exceptionLog/resolve';
                httpService.post(false, url, m , success);
            }
        };
    })

;
