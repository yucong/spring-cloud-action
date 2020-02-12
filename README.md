# spring cloud action 实战演练

#### 介绍
{**以下是码云平台说明，您可以替换此简介**
码云是 OSCHINA 推出的基于 Git 的代码托管平台（同时支持 SVN）。专为开发者提供稳定、高效、安全的云端软件开发协作平台
无论是个人、团队、或是企业，都能够用码云实现代码托管、项目管理、协作开发。企业项目请看 [https://gitee.com/enterprises](https://gitee.com/enterprises)}

#### 软件架构
软件架构说明


#### Feigin的使用注意事项

1. 在Feign技术中应用GZIP压缩：可使用Spring Boot中的GZIP技术
2. Feign的通讯优化：HttpClient客户端替换HttpURLConnection,支持HTTP连接池
3. Feign默认使用的HttpURLConnection（不支持连接池）,使用HttpClint升级
4. 当使用HttpClient技术作为Feign的底层HTTP技术应用时，
       使用GET请求方式请求头传递自定义类型对象是可行的，
       只要在服务标准对象中定义的方法参数上增加注解@RequestBody即可处理


5. 超时策略的使用优先级： 指定服务的超时策略 -> 全局配置的超时策略 -> 默认的超时策略(默认1s)。



#### 使用说明

1. xxxx
2. xxxx
3. xxxx

#### 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


#### 码云特技

1. 使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2. 码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3. 你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4. [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5. 码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6. 码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)