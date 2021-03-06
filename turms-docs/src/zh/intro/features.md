# 特性

Turms解决方案最大的特点就是：所有大中小型的商用即时通讯解决方案的核心实现就是Turms一套方案的实现。如果您的团队曾做过大中型商用即时通讯架构的设计与开发，相信您的团队会对Turms的架构设计与各种实现细节感到亲切。

### 功能特性

1. 业务功能完善性。Turms支持几乎所有商用即时通信产品所支持的即时通信相关功能（甚至还有更多的业务功能），并且无任何增值功能收费，无需提交工单以申请功能，无业务功能限制。（注意：Turms也“故意地”不支持某些功能，具体原因请查看 [Turms集合设计](https://turms-im.github.io/docs/for-developers/schema.html)）
   （数据分析与挖掘功能会在之后发布turms-data的时候提供，具体细节可查阅 [Turms数据分析](https://turms-im.github.io/docs/for-developers/data-analytics.html)）
2. 功能拓展性。Turms同时支持两种拓展模式。配置参数；自定义Plugin插件。当然您也完全可以对源码进行修改。目前接入的MinIO对象存储服务端就是基于Plugin机制实现的。
3. 功能配置灵活性。Turms提供了上百个配置参数供用户定制，以满足各种即时通信场景。并且大部分配置都可以在集群运作时，进行集群级别的同步动态更新，并且不损失性能。（注意：对集群进行配置更新的时候，不需要停机）

### 架构特性

1. 支持用户无感知停机更新，为快速迭代提供可能
2. 无状态架构，支持Turms集群横向扩展
3. 支持接入安全防护层（主要就是抵御DDoS攻击，方便做流量清洗）
4. 支持异地多活的部署实现
5. 方便与云服务对接，实现全自动化部署与运维（Turms还将推出turms-cli来辅助运维工作）
6. 能同时支持大中小型即时通讯场景，即便用户体量由小变大也无需重构（当然，对于大型运用场景还有很多优化的工作需要做，但当前架构不影响后期的无痛升级）
7. 核心架构“轻量”，方便学习与二次开发（原因请查阅 [Turms架构设计](https://turms-im.github.io/docs/for-developers/architecture.html)）
8. 数据库集群支持请求路由、读写分离、分片与副本架构

### 其他特性

1. 重视可观察性体系建设（详细文档：[Turms监控系统](https://turms-im.github.io/docs/for-developers/observibility.html)）。具体而言包括以下三个维度：

   * 日志（针对事件）：共提供了三大类日志：监控日志、业务日志、统计日志
   * 度量（针对可聚合数据）。包括系统运行状态的实时监控信息，以及业务相关数据的实时信息
   * 链路追踪

   注意：Turms服务端自身会在实现高效的前提下尽可能提供更多监控数据，对于一些尽管常见但对性能影响较大的功能不予提供（如：日活）。对于这类拓展功能，您可以通过Turms的日志与度量离线或实时分析实现。

2. 运作极为高效。

   - （网络I/O）Turms服务端的所有代码均采用“响应式编程”模式，是目前全球范围内对响应式编程实践最为深刻的开源项目。Turms服务端的所有网络请求在底层都是基于Netty的异步无阻塞模型实现的（包括数据库调用、Redis调用、服务发现注册、RPC等）
   - （线程）Turms服务端具有优秀的线程模型，其线程数恒定，与在线用户规模以及请求数无关
   - （内存）Turms服务端与Turms客户端间的所有通信数据均为Protobuf二进制数据，并在划分内存空间时，合理且充分地循环利用堆内内存与堆外内存
   - （缓存）Turms服务端各功能模块充分利用本地内存缓存