audit 是一个 springcloud项目。

audit-base 公用的基础实体类
audit-common-mongoUtil mongo封装工具类
audit-common-util 通过工具类

audit-rest 是负责向外暴露的服务，只负责提供接口；
audit-service 只有接口类，没有实现，负责给 audit-restapi 调用。
audit-service-user 实现 audit-service-api中接口，负责用户登录模块
audit-service-order 实现 audit-service-api中接口，负责订单模块。、

PORT:
eureka-server: 9010
zuul: 9020
rest: 9011
user: 9012
order:

