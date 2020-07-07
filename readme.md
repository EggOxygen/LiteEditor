# LiteEditor FE

> ~~孩子上网课老怕跑走？快用LiteEditor来实时监控孩子的学习情况。~~

> 不出意外 不再更新
>
> 致 人生中第一次在家上网课的时间 2020.03.02 - 2020.04.30

### 这东西怎么诞生的

这个东西是怎么来的参考 [这里](http://code.eggoxygen.top/2020/03/12/LiteEditor-开发记载/)

### 这东西简单来说是干啥的

就是一个同步的线上的网页编辑工具 老师端只需要给个地址给学生就可以线上~~鞭尸~~操作

### 这东西用到了啥东西来做

Client = Vue-Cli + ClipboardJS + element-ui + axios
Server = Nodejs + Express + Redis + uuid

### 关于FE分支

这个分支用的基本为前端的技术 替换 SpringBoot 版本 

对比 SpringBoot 上面除了少了一个文件管理相关 其他保持一致

非前端开发者 所以后端的部分按照自己的习惯来写的

---

### 配置相关

editor_client 为网页前端的文件 为 vue-cli 项目 可以直接跑起来

editor_server 为Nodejs后端的文件 为 Express 项目 可以直接跑起来


```javascript

/* editor_server 内部的 redis_utils 需要填入自己的 Redis 配置 */
const client = redis.createClient({
    host: '',
    password: ''
});

```

---

### 版本更新日志

* 0.4.0-FE
  * 替换为前端技术栈
* 0.3.0-SNAPSHOT
  * 支持多人线上 默认提供单人双人四人
  * 优化编辑者体验 现在可以看到HTML输出预览
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

