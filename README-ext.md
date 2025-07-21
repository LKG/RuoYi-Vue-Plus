添加
Crane4j 
Liquibase
x-file-storage
mybatis-flex
<crane4j.version>2.9.0</crane4j.version>
<knife4j.version>4.5.0</knife4j.version>
<tlog.version>1.5.2</tlog.version>
<truelicense.version>1.33</truelicense.version>
<zip4j.version>2.11.5</zip4j.version>
* 适配 Liquibase 用于管理数据库版本，跟踪、管理和应用数据库变化。
* 适配 Crane4j 数据填充组件，减少因为一个用户名而产生的联表回填；
* 适配 SpEL Validator 基于 SpEL 的 Java 参数校验，使用 SpEL 表达式，强化基础参数校验。例如：当其中一个字段为 xxx 时，另一个字段不能为空等等；
* 适配 JetCache 缓存框架（比 Spring Cache 更强大易用），通过注解声明即可快速实现方法级缓存，极大改善编码式缓存体验，且支持灵活的二级缓存配置、分布式自动刷新等能力；
* 适配  Knife4j
* 适配  dy-java  https://gitee.com/dromara/dy-java
## 添加技术栈
| 名称                                                                             | 版本         | 简介                                                                                      |
|:-------------------------------------------------------------------------------|:-----------|:----------------------------------------------------------------------------------------|
| <a href="https://github.com/liquibase/liquibase" target="_blank">Liquibase</a> | 4.27.0     | 用于管理数据库版本，跟踪、管理和应用数据库变化。                                                                |
| [Crane4j](https://createsequence.gitee.io/crane4j-doc/#/)                      | 2.9.0      | 一个基于注解的，用于完成一切 “根据 A 的 key 值拿到 B，再把 B 的属性映射到 A” 这类需求的字段填充框架。                            |
| [SpEL Validator](https://spel-validator.sticki.cn/)                            | 0.5.0-beta | 基于 SpEL 的 jakarta.validation-api 扩展增强包。                                                 |
| [CosID](https://cosid.ahoo.me/guide/getting-started.html)                      | 2.13.0     | 旨在提供通用、灵活、高性能的分布式 ID 生成器。                                                               |
| [Knife4j](https://doc.xiaominfo.com/)                                          | 4.5.0      | 前身是 swagger-bootstrap-ui，集 Swagger2 和 OpenAPI3 为一体的增强解决方案。                              |
| [AJ-Captcha](https://ajcaptcha.beliefteam.cn/captcha-doc/)                     | 1.3.0      | Java 行为验证码，包含滑动拼图、文字点选两种方式，UI支持弹出和嵌入两种方式。                                               |
| Easy Captcha                                                                   | 1.6.2      | Java 图形验证码，支持 gif、中文、算术等类型，可用于 Java Web、JavaSE 等项目。                                     |
| [dy-java](https://gitee.com/dromara/dy-java)                                   | 1.0.0      | DyJava 是一款功能强大的抖音 Java 开发工具包（SDK），支持抖音各个应用 OpenAPI 快速调用，包括但不限于移动/网站应用、抖音开放平台、抖店和抖音小程序等。 |



## 模块结构

```
ruoyi-vue-plus
├─ ruoyi-admin（后台打包部署模块）
│  ├─ src
│  │  ├─ main
│  │  │  ├─ java/org/dromara
│  │  │  │  └─ DromaraApplication.java（启动程序）
│  │  │  └─ resources
│  │  │     ├─ application-dev.yml（开发环境配置文件）
│  │  │     ├─ application-prod.yml（生产环境配置文件）
│  │  │     └─ application.yml（通用配置文件）
│  │  │     ├─ db/changelog（Liquibase 数据脚本配置目录）
│  │  │     │  ├─ mysql（MySQL 数据库初始 SQL 脚本目录）
│  │  │     │  ├─ postgresql（PostgreSQL 数据库初始 SQL 脚本目录）
│  │  │     │  └─ db.changelog-master.yaml（Liquibase 变更记录文件）
│  │  │     ├─ templates（模板配置目录，例如：邮件模板）
│  │  │     ├─ banner.txt（Banner 配置文件）
│  │  │     └─ logback-spring.xml（日志配置文件）
│  │  └─ test（测试相关代码目录）
│  └─ pom.xml（包含打包相关配置）
├─ ruoyi-common（核心模块：包含线程池等自动配置）
│      └─ ruoyi-commone-license （证书模块：license）
├─ ruoyi-modules（业务模块）
│    └─ ruoyi-edu（教育模块）
│    └─ ruoyi-cms（内容模块）
│    └─ ruoyi-member（会员模块）
│    └─ ruoyi-crm（crm模块）
│    └─ ruoyi-erp（erp模块）
│    └─ ruoyi-ai（ai模块）
├─ pom.xml（包含打包相关配置）
```