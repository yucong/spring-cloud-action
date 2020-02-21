# spring cloud action 实战演练

#### Feigin的使用注意事项

1. 在Feign技术中应用GZIP压缩：可使用Spring Boot中的GZIP技术
2. Feign的通讯优化：HttpClient客户端替换HttpURLConnection,支持HTTP连接池
3. Feign默认使用的HttpURLConnection（不支持连接池）,使用HttpClint升级
4. 当使用HttpClient技术作为Feign的底层HTTP技术应用时，
       使用GET请求方式请求头传递自定义类型对象是可行的，
       只要在服务标准对象中定义的方法参数上增加注解@RequestBody即可处理
5. 超时策略的使用优先级： 指定服务的超时策略 -> 全局配置的超时策略 -> 默认的超时策略(默认1s)。


#### Hystrix的使用注意事项

1. 从Dalston版本后，feigin默认关闭Hystrix支持
     （需要在配置位置中声明：feign.hystrix.enabled=true）
2. 使用Turbine做服务集群监控的时候，必须先启动application client集群，再启动Turbine。
        保证Turbine启动的时候，可以在eureka注册中心中发现要监控的服务集群
3. feign配合hystrix时，hystrix的超时时间必须要大于ribbon的超时时间
   hystrix的默认超时时间为1s，ribbon的超时时间还要算上重试时间，
       如果hystrix的超时时间小于ribbon的超时时间，
       一旦hystrix超时，立刻fallback，意味着ribbon的超时策略无效


#### Zuul的使用注意事项

1. 
2. 
3. 
4. 


