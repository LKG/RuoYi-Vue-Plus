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

TrueLicense
## 模块结构

```
continew-starter
├─ continew-starter-core（核心模块：包含线程池等自动配置）
├─ continew-starter-json（JSON 模块）
│  └─ continew-starter-json-jackson
├─ continew-starter-api-doc（接口文档模块：Spring Doc + Knife4j）
├─ continew-starter-validation（校验模块：Hibernate Validator）
├─ continew-starter-web（Web 开发模块：包含跨域、全局异常+响应、链路追踪等自动配置）
├─ continew-starter-cache（缓存模块）
│  ├─ continew-starter-cache-redisson（Redisson）
│  ├─ continew-starter-cache-jetcache（JetCache 多级缓存）
│  └─ continew-starter-cache-springcache（Spring 缓存）
├─ continew-starter-auth（认证模块）
│  ├─ continew-starter-auth-satoken（国产轻量认证鉴权）
│  └─ continew-starter-auth-justauth（第三方登录）
├─ continew-starter-data（数据访问模块）
│  ├─ continew-starter-data-core（核心模块）
│  ├─ continew-starter-data-mp（MyBatis Plus）
│  └─ continew-starter-data-mf（MyBatis Flex）
├─ continew-starter-security（安全模块）
│  ├─ continew-starter-security-crypto（加密：字段加解密）
│  ├─ continew-starter-security-xss（XSS 过滤）
│  ├─ continew-starter-security-mask（脱敏：JSON 数据脱敏）
│  └─ continew-starter-security-password（密码编码器）
├─ continew-starter-ratelimiter（限流模块）
├─ continew-starter-idempotent（幂等模块）
├─ continew-starter-trace（链路追踪模块）
├─ continew-starter-captcha（验证码模块）
│  ├─ continew-starter-captcha-graphic（静态验证码）
│  └─ continew-starter-captcha-behavior（动态验证码）
├─ continew-starter-messaging（消息模块）
│  ├─ continew-starter-messaging-mail（邮件）
│  └─ continew-starter-messaging-websocket（WebSocket）
├─ continew-starter-log（日志模块）
│  ├─ continew-starter-log-core（核心模块）
│  ├─ continew-starter-log-aop（基于 AOP 实现）
│  └─ continew-starter-log-interceptor（基于拦截器实现（Spring Boot Actuator HttpTrace 增强版））
├─ continew-starter-excel（Excel 文件处理模块）
│  ├─ continew-starter-excel-core（核心模块）
│  ├─ continew-starter-excel-fastexcel（FastExcel）
│  └─ continew-starter-excel-poi（POI）
├─ continew-starter-storage（存储模块）
│  └─ continew-starter-storage-local（本地存储）
├─ continew-starter-license（License 模块）
│  ├─ continew-starter-license-core（核心模块）
│  ├─ continew-starter-license-generator（License 生成器）
│  └─ continew-starter-license-verifier（License 校验器）
└─ continew-starter-extension（扩展模块）
   ├─ continew-starter-extension-datapermission（数据权限模块）
   │  ├─ continew-starter-extension-datapermission-core（核心模块）
   │  └─ continew-starter-extension-datapermission-mp（MyBatis Plus）
   ├─ continew-starter-extension-tenant（租户模块）
   │  ├─ continew-starter-extension-tenant-core（核心模块）
   │  └─ continew-starter-extension-tenant-mp（MyBatis Plus）
   └─ continew-starter-extension-crud（CRUD 模块）
      ├─ continew-starter-extension-crud-core（核心模块）
      ├─ continew-starter-extension-crud-mp（MyBatis Plus）
      └─ continew-starter-extension-crud-mf（MyBatis Flex）
```