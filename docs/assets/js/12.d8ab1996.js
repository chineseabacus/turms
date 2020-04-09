(window.webpackJsonp=window.webpackJsonp||[]).push([[12],{254:function(s,r,a){"use strict";a.r(r);var v=a(28),t=Object(v.a)({},(function(){var s=this,r=s.$createElement,a=s._self._c||r;return a("ContentSlotsDistributor",{attrs:{"slot-key":s.$parent.slotKey}},[a("h3",{attrs:{id:"架构"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#架构"}},[s._v("#")]),s._v(" 架构")]),s._v(" "),a("p",[s._v("（TODO）")]),s._v(" "),a("p",[s._v("特别说明：在大部分即时通讯的技术架构中，都使用了独立的接入层，并通常带有专门的用户状态管理集群、服务注册中心集群与配置中心集群等。而Turms引擎最大程度地简化了架构，无需接入上述架构内容。Turms的架构最多只有两层，即：负载均衡层与Turms服务端集群（补充：Turms服务端集群自身也有负载均衡功能）。一方面，该架构的Overhead开销最小。另一方面，可以极大简化开发者的运维工作。")]),s._v(" "),a("h3",{attrs:{id:"负载均衡"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#负载均衡"}},[s._v("#")]),s._v(" 负载均衡")]),s._v(" "),a("p",[s._v("负载均衡的重要性不言而喻，为更好的与负载均衡服务器（负载均衡层）相搭配，Turms服务端提供了“负责用户策略”与“非负责用户策略”，并推荐您在负载均衡服务端处实现相应的算法（下文的“带业务判断的负载均衡架构”讲解了大致流程，您可以自行实现，或等v1.2.0版本时Turms引擎也将提供具体的配置与代码），二者相配合，能实现Turms集群性能与可用性的最优解。")]),s._v(" "),a("h4",{attrs:{id:"负责用户策略"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#负责用户策略"}},[s._v("#")]),s._v(" 负责用户策略")]),s._v(" "),a("p",[s._v("负责用户策略指的是：每个Turms服务端会根据一致性Hash算法，被动态地分配去管理不同用户（根据用户ID），并对这些用户负责。一名用户有且仅有一个服务端对其负责。")]),s._v(" "),a("h5",{attrs:{id:"具体场景"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#具体场景"}},[s._v("#")]),s._v(" 具体场景")]),s._v(" "),a("ul",[a("li",[s._v("如果一名用户试图与不对其负责的Turms服务端建立连接，则在该策略下，Turms服务端会在WebSocket的Handshake阶段主动拒绝与其建立连接，并根据配置，返回对其负责的服务端地址（IP+端口）。默认情况下，Turms客户端会自动根据该地址与新服务端建立连接。")]),s._v(" "),a("li",[s._v("如果一名用户与不对其负责的Turms服务端已建立了连接（出现这种情况是因为其他服务端的上线与下线操作，导致Turms服务端的管辖范围发送了变化），则Turms服务端会主动断开连接，并根据配置，返回对其负责的服务端地址（IP+端口）。默认情况下，Turms客户端会自动根据该地址与新服务端建立连接。")])]),s._v(" "),a("p",[s._v("该策略的特点是运作高效，可以通过本地简易的算法，来得知负责管理某用户的服务端，并直接与其进行交互。但缺点在于对于已经建立的连接，由于当服务端上下线时会导致服务端的管辖范围发生变化，从而产生惊群效应，使得一批已建立连接的用户被迫下线，当这些用户自动重连时又容易产生流量洪流，加大服务雪崩的概率。尤其是在服务端不稳定时，多个服务端反反复复上下线时，该类问题更为严重。")]),s._v(" "),a("p",[s._v("为了解决类似问题，Turms服务端又提供了非负责用户策略作为服务兜底策略（补充：负责用户策略是无法关闭的，而非负责用户策略可以关闭，并且非负责用户策略默认启动）。")]),s._v(" "),a("h4",{attrs:{id:"非负责用户策略"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#非负责用户策略"}},[s._v("#")]),s._v(" 非负责用户策略")]),s._v(" "),a("p",[s._v("特别注意：该策略属于服务补偿（服务兜底）策略，是对负责用户策略的补充，而非主策略。")]),s._v(" "),a("p",[s._v("用户进入非负责状态的任意条件有：")]),s._v(" "),a("ul",[a("li",[s._v("当一名用户试图与不对其负责的Turms服务端建立连接时")]),s._v(" "),a("li",[s._v("原本一个对某用户负责的服务端，因为其他服务端的上线或下线操作，导致服务端负责的用户范围发生了变化，使得用户进入到了不负责的状态")])]),s._v(" "),a("p",[s._v("该策略与传统的有状态服务架构的思路类似，传统的有状态服务架构通常将状态由从业务服务端中剥离出来，并交由专门的状态集群管理（通常是Redis或Memcached集群），而状态集群对外提供一致的状态表述，由此实现状态的一致性。非负责用户策略实现了类似的思想。")]),s._v(" "),a("h5",{attrs:{id:"具体场景-2"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#具体场景-2"}},[s._v("#")]),s._v(" 具体场景")]),s._v(" "),a("ul",[a("li",[a("p",[s._v("对于非负责用户发来的连接请求，Turms服务端会接受其请求并与其建立连接，同时会将该用户的ID与当前服务端的ID记录到一个全局的内存表当中。")])]),s._v(" "),a("li",[a("p",[s._v("对于已经建立连接的非负责用户，Turms不会关闭与其的连接，而是把其信息记录到这张全局表当中")])])]),s._v(" "),a("p",[s._v("（补充：在Turms服务端配置中，这两个功能是否启动是独立设置的）")]),s._v(" "),a("p",[s._v("（特别值得一提的是：这个全局的内存表由Hazelcast的ReplicatedMap实现，其提供冗余的副本数据，而非分片数据，因此每个Turms服务端都在本地存有这张表。并且该表非强一致，但最终一致，加之该表增删操作非同步操作，可能会出现小部分用户状态不一致的问题。在这个问题上，Turms通过给非负责用户记录设定TTL时间（可配置），当到达TTL时间时，则服务端主动强制与该非负责用户，并告知对其负责的服务端地址，以解决可能出现的小部分用户状态不一致的问题，同时也避免了一刀斩式断连情况下出现的流量洪流）")]),s._v(" "),a("p",[s._v("而在每次需要对用户状态进行判断的时候，Turms服务端会先走非负责用户策略的逻辑，通过这张全局副本表判断用户状态，如果该表不存在该用户的信息，则说明他未与非负责的服务端建立连接，进而转入负责用户策略进行后续的判断逻辑。")]),s._v(" "),a("p",[s._v("由此通过上述两种策略，互相取长补短。")]),s._v(" "),a("p",[s._v("提醒：非负责用户策略是负责用户策略的服务兜底策略，在实际使用中切不可主客颠倒。")]),s._v(" "),a("h4",{attrs:{id:"负载均衡层（可选）"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#负载均衡层（可选）"}},[s._v("#")]),s._v(" 负载均衡层（可选）")]),s._v(" "),a("p",[s._v("出于安全、高可用与后期运维等原因，负载均衡层通常在生产环境是必不可少的。这里我们主要讲解下Turms自身的负载均衡策略在不同负载均衡架构下的大致运用。")]),s._v(" "),a("h5",{attrs:{id:"无负载均衡层架构"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#无负载均衡层架构"}},[s._v("#")]),s._v(" 无负载均衡层架构")]),s._v(" "),a("p",[s._v("这里指的无负载均衡架构指的是：用户直接通过真实IP访问Turms服务端，或者用户通过访问单条A记录的DNS服务端直接访问Turms服务端。如果非负责用户策略被关闭，那么在这种情况下，被用户直接访问的Turms服务端会在实际上变为路由服务端（注意：Turms所有服务端都有路由功能），Turms服务端会在内部集群中，自动查询对其负责的服务端。如果该服务端就是对其负责的服务端，则与该用户建立连接，否则拒绝连接，并告知其对其负责的服务端的地址（IP+端口）。")]),s._v(" "),a("p",[s._v("如果非负责用户策略被启动，并且您还允许了用户可以与不对其负责的Turms服务端建立连接，则该服务端会一概直接建立连接，但这就会导致Turms内部的负载均衡功能失去意义。")]),s._v(" "),a("h5",{attrs:{id:"带业务判断的负载均衡架构"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#带业务判断的负载均衡架构"}},[s._v("#")]),s._v(" 带业务判断的负载均衡架构")]),s._v(" "),a("p",[s._v("这里指的带业务判断，即7层负载均衡，其本质与Turms自身的负载均衡策略一致，让Nginx在WebSocket的Handshake阶段，获取用户ID，再结合当前Turms集群状态（可通过dyups模块+Lua脚本。Turms会在v1.2.0版本中给出具体配置），计算出对其负责服务端地址，再将用户请求转发给该Turms服务端。")]),s._v(" "),a("p",[s._v("由于负载均衡层在获取Turms集群状态时，会有一定的延迟。因此可能会出现一部分用户被转发给了不对其负责的Turms服务端，这时候就适合允许了用户可以与不对其负责的Turms服务端建立连接。")]),s._v(" "),a("h5",{attrs:{id:"不带业务判断的负载均衡架构"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#不带业务判断的负载均衡架构"}},[s._v("#")]),s._v(" 不带业务判断的负载均衡架构")]),s._v(" "),a("p",[s._v("不带业务判断的负载均衡架构可以自由配置，没有特殊之处。但都可以加上Nginx并实现上述逻辑，以变成带业务判断的负载均衡架构。因此无论是DNS+Nginx负载均衡架构、DNS+LVS+Nginx负载均衡架等架构都可以变为带业务判断的负载均衡架构。")])])}),[],!1,null,null,null);r.default=t.exports}}]);