angular.module('internal.filters',[])
    .filter('FeedbackState', function() {
        return function(input) {
            //0表进行中，1表已提车， 2表待结账
            var stateDesc = '';
            if(input==0){
                stateDesc='未处理';
            }else if(input==1){
                stateDesc='已处理';
            }
            return stateDesc;
        };
    })
    .filter('ReceptionState', function() {
        return function(input) {
            //0表进行中，1表已提车， 2表待结账
            var stateDesc = '已挂账';
            if(input==0){
                stateDesc='进行中';
            }else if(input==1){
                stateDesc='已提车';
            }else if(input==2){
                stateDesc = '待结账';
            }
            return stateDesc;
        };
    })
    .filter('MouthAndDate', function() {
        return function(input) {
            if(input){
                var mouth = input.substring(5,7);
                if(mouth.substring(0,1)==0){
                    mouth = mouth.substring(1,2);
                }
                var date = input.substring(8,10);
                if(date.substring(0,1)==0){
                    date = date.substring(1,2);
                }
                return mouth + '月' + date + '日';
            }
        };
    })
    .filter('OnlyDate', function() {
        return function(input) {
            if(input){
                return input.substring(5,10);
            }
        };
    })
    .filter('FloatMoney', function() {
        return function(input) {
            if(input){
                return parseFloat(input).toFixed(2);
            }
        };
    })
    .filter('FormatCurrency', function() {
        return function(input, isHideZero) {
            if(isHideZero && input=='0'){
                return '';
            }
            var numStr = input + '',
                n = 2,
                pointIndex = numStr.indexOf('.'),
                beforePoint,
                afterPoint;
            //input是整数
            if(pointIndex < 0){
                beforePoint = numStr;
                afterPoint = '.00';
            }else{
                //input非整数
                beforePoint = numStr.substring(0, pointIndex);
                afterPoint = numStr.substring(pointIndex, pointIndex + n + 1);
            }
            var re = /(-?\d+)(\d{3})/;
            while(re.test(beforePoint)){
                beforePoint = beforePoint.replace(re,"$1,$2");
            }
            return beforePoint + afterPoint;

        };
    })
    .filter('DigitUppercase', function() {
        return function(n) {
            var fraction = ['角', '分'];
            var digit = [
                '零', '壹', '贰', '叁', '肆',
                '伍', '陆', '柒', '捌', '玖'
            ];
            var unit = [
                ['元', '万', '亿'],
                ['', '拾', '佰', '仟']
            ];
            var head = n < 0 ? '欠' : '';
            n = Math.abs(n);
            var s = '';
            for (var i = 0; i < fraction.length; i++) {
                s += (digit[Math.floor(n * 10 * Math.pow(10, i)) % 10] + fraction[i]).replace(/零./, '');
            }
            s = s || '整';
            n = Math.floor(n);
            for (var i = 0; i < unit[0].length && n > 0; i++) {
                var p = '';
                for (var j = 0; j < unit[1].length && n > 0; j++) {
                    p = digit[n % 10] + unit[1][j] + p;
                    n = Math.floor(n / 10);
                }
                s = p.replace(/(零.)*零$/, '').replace(/^$/, '零') + unit[0][i] + s;
            }
            return head + s.replace(/(零.)*零元/, '元')
                    .replace(/(零.)+/g, '零')
                    .replace(/^整$/, '零元整');

        };
    })
;