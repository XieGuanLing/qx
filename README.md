spring boot 整合示例
=======================


gradle dependencies
gradle build --refresh-dependencies 



测试URL
curl -XPOST http://127.0.0.1:9000/user/index
curl -XPOST http://127.0.0.1:9000/user/findByGroupName


curl -XGET http://127.0.0.1:9000/html/inside/ads.html

curl -XGET http://127.0.0.1:9000/swagger-ui.html




redis-cli -h 192.168.1.251
redis-cli -h 127.0.0.1

redis-cli config set notify-keyspace-events Egx

curl -XPOST  -i -d '{"companyId":8021}' -H 'content-type: application/json;charset=UTF-8' http://127.0.0.1:9000/user/login
curl -XPOST  -i -d '{"companyId":8021}' -H 'content-type: application/json;charset=UTF-8' http://127.0.0.1:9000/user/index
