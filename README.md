# SuperVCDSellSystem

### 作者：vili &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 联系方式：vili_wzl@126.com

*该程序是一个vcd贩卖系统，主要包括客户端和服务端。1.客户端主要功能：用户注册和登录、专辑根据分类与关键字查询、专辑详细信息查询、专辑内音乐试听（播放与停止）、订单生成、订单查询、收货地址查询、增加收货地址、设置默认收货地址等 2.服务端主要功能：对客户端消息进行处理与转发，与数据库进行交互并将处理结果返回至客户端*

## 目录

* [1.客户端](#1)
* [2.服务端](#2)
* [3.其他信息](#3)
* [4.部署步骤](#4)

<h2 id="1">SuperVCD</h2>

1.该应用为项目的客户端，使用IDEA 2017.3.5编写。

2.主要界面截图如下：

登录界面：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/登录界面.png)

注册界面：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/注册界面.png)

主界面：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/主界面.png)

用户信息管理界面：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/用户信息管理界面.png)

地址管理界面：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/地址管理界面.png)

专辑详细信息界面：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/专辑详细信息界面.png)

创建订单界面：

![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/创建订单界面.png)

订单查询界面：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/订单查询界面.png)

3.功能请大家运行一下就可以了。

4.用户名存储在数据库的user表中，可以自行添加，或通过注册功能直接注册。

<h2 id="2">SuperVCDServer</h2>

1.该应用为项目的服务端，使用IDEA 2017.3.5编写。

2.运行时先启动服务端，再启动客户端。

<h2 id="3">其他信息</h2>

1.两个工程都是采用IDEA 2017.3.5编写。

2.数据库使用MySQL,版本为5.7，数据库文件为MySQLWorkbench导出，直接回复即可。

3.jdk版本为1.8_181，版本问题可以更改配置文件解决(IDEA 有上角运行框拉下来点击配置文件即可设置jdk路径)。

4.客户端与服务端采用Socket进行通信。

5.通信框架基本如下：
![avatar](https://raw.githubusercontent.com/vi-li/MarkdownPictureRepository/master/SuperVCD网络通信架构.jpg)

<h2 id="4">部署步骤</h2>

1.将数据库文件恢复至你自己的数据中。

2.将SuperVCD项目中的net包下的client类中的IP地址与端口号进行修改。

3.将SuperVCDServer项目中的server包下的Server类中的监听端口与客户端修改为一致（若部署到服务器上，则需要开放对应端口，客户端链接IP写公网IP，本机写“127.0.0.1”即可）

4.将SuperVCDServer项目中的Tool包下的MySQLHelper类中的连接字符串，用户名，密码填写为需要的数据。

5.将CloudMusic文件夹复制到你的D盘（如果没有D盘，请修改数据库中的VCDSong表中的songpath字段，修改为你本地的路径）

6.先运行服务端，再运行客户端。完美！！！
