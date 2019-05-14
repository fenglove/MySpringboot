## 学习Spring Boot系列之shiro安全框架

shiro主要分为 **安全认证** 和 **接口授权** 两个部分，核心组件为`Subject`、`SecurityManager`、`Realms`，公共部分`shiro`已近封装好了
`Subject`表示主体，将用户的概念理解为当前操作的主体。
Subject代表当前用户的安全操作，SecurityManager管理所有用户的安全操作
`SecurityManager`即安全管理器，对所有Subject进行安全管理，通过它来提供安全管理的各种服务（认证、授权）
`Realm`充当应用与数据安全间的`桥梁`或`连接器`。当对用户执行认证和授权验证时，Shiro会从应用配置的Realm中查找用户及其权限信息

