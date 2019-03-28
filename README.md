spring boot 整合示例
=======================


1. 分页

gradle dependencies
gradle build --refresh-dependencies 


2.SimpleJpaRepository 的 delete(ID id) 会先查找，再删除
如果自定义实现，只执行删除操作，可能造成nativeQuery 与 hql 在同一个@transaction中更新，会出现更新状态不一致



测试URL
curl -XPOST http://127.0.0.1:9000/user/index
curl -XPOST http://127.0.0.1:9000/user/findByGroupName


curl -XGET http://127.0.0.1:9000/html/inside/ads.html

curl -XGET http://127.0.0.1:9000/swagger-ui.html



mysql -h127.0.0.1 -P3307  -uroot -proot -Dqx -A

redis-cli -h 192.168.1.251
redis-cli -h 127.0.0.1

redis-cli config set notify-keyspace-events Egx

curl -XPOST  -i -d '{"companyId":8021}' -H 'content-type: application/json;charset=UTF-8' http://127.0.0.1:9000/user/login
curl -XPOST  -i -d '{"companyId":8021}' -H 'content-type: application/json;charset=UTF-8' http://127.0.0.1:9000/user/index
