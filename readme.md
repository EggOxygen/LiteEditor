# LiteEditor

> ~~孩子上网课老怕跑走？快用LiteEditor来实时监控孩子的学习情况。~~

### 这东西怎么诞生的

这个东西是怎么来的参考 [这里](http://code.eggoxygen.top/2020/03/12/LiteEditor-开发记载/)

### 这东西简单来说是干啥的

就是一个同步的线上的网页编辑工具 老师端只需要给个地址给学生就可以线上~~鞭尸~~操作

### 这东西用到了啥东西来做

thymeleaf + spring boot + Vuejs + 杂乱的思维 **(编写时候由于习惯内部用的是Kotlin而非Java)**

### 如何使用它来帮助老师学习

如果你也是计算机方面专业的 如果你也有HTML相关的课程 并且你有一台可以跑的服务器

那么你就可以 clone 下来 改改端口 然后直接生成后跑起来 不需要额外的配置

### 有BUG咋办

这个说实话写的比较乱 不涉及任何数据库交互逻辑 部分逻辑现在看来是比较绕的 后期看看有没有良心做个更新啥的吧

真遇到问题了可以提出来 做个更新就好了的事情

---

### 配置相关

现在不需要单独的Apache服务器了 全部交给本地去处理

相关的逻辑参考 `fileHandler` 与本地 `static` 文件夹关联

需要在 application.properties 内手动进行相关配置

```bash

# LiteEditor Config
# 填入存放文件本地绝对路径
editor.upload-path=path_to_your_static_location

# Redis Config
spring.redis.port=6379

```

---

### 版本更新日志

* 0.2.7-SNAPSHOT
  * 使用本地路径作为文件存储
  * Redis 里面使用 Hash 作为储存
* 0.2.6-SNAPSHOT
  * 用 Redis 作为数据缓存
  * 完善代码
* 0.2.3-SNAPSHOT
  * 修复HTML标签读取跳转问题
  * 动态从配置读取版本号
  * 修改编辑器默认最大行限制
* 0.2.2-SNAPSHOT
  * 新增一个版本的文件管理
* 0.2.0-SNAPSHOT
  * 移除了部分无用部分
  * 输入页使用监听而不再是暴力POST
  * 规范一下代码
* 0.1.8-SNAPSHOT
  * 修复了CSS样式应用全局的问题
* 0.1.7-SNAPSHOT
  * 换了一个ArcEditor 支持代码高亮和代码提示了 不再鞭尸
* 0.1.6-SNAPSHOT
  * 删除了部分没啥用的代码
* 0.1.2-SHAPSHOT
  * 添加一个HTML展示区域 主要用到Vue的双向绑定
* 0.1.0-SHAPSHOT
  * 孵化出来了第一个版本

