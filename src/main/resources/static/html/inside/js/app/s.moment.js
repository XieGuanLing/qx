/**
 * Created by Administrator on 2017/3/27.
 */
angular.module('s.moment', [])
    .factory('momentService',function(){
        return {
            preciseUtilDatePattern:'YYYY-MM-DD HH:mm:ss',
            simpleUtilDatePattern:'YYYY-MM-DD',
            preciseSqlDatePattern:'YYYY/MM/DD HH:mm:ss',
            simpleSqlDatePattern:'YYYY/MM/DD',
            preciseUtilDate:moment().format('YYYY-MM-DD HH:mm:ss'),
            simpleUtilDate:moment().format('YYYY-MM-DD'),
            preciseSqlDate:moment().format('YYYY/MM/DD HH:mm:ss'),
            simpleSqlDate:moment().format('YYYY/MM/DD'),
            moment:moment(),
            addDays2Moment: function (days) {
                return moment().add(days, 'days');
            },
            preciseUtilMoment: function (date) {
                return moment(date, this.preciseUtilDatePattern);
            },
            simpleUtilMoment: function (date) {
                return moment(date, this.simpleUtilDatePattern);
            },
            preciseSqlMoment: function (date) {
                return moment(date, this.preciseSqlDatePattern);
            },
            simpleSqlMoment: function (date) {
                return moment(date, this.simpleSqlDatePattern);
            },
            preciseUtilAddDays: function (days) {
                return moment().add(days, 'days').format(this.preciseUtilDatePattern);
            },
            simpleUtilAddDays: function (days) {
                return moment().add(days, 'days').format(this.simpleUtilDatePattern);
            },
            preciseSqlAddDays: function (days) {
                return moment().add(days, 'days').format(this.preciseSqlDatePattern);
            },
            simpleSqlAddDays: function (days) {
                return moment().add(days, 'days').format(this.simpleSqlDatePattern);
            },
            simpleSqlDays:function(date){
                return moment(date).format(this.simpleSqlDatePattern);
            }
        };
    });