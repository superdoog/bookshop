# bookshop
ssm书店 练手demo bootstrap SpringMVC+Spring+MyBatis

# 项目预览
[http://49.235.62.115:8080/BookShop](http://49.235.62.115:8080/BookShop) 前台
[http://49.235.62.115:8080/BookShop/backLogin](http://49.235.62.115:8080/BookShop/backLogin) 后台
前台账号：test 密码：123456
后台账号：admin 密码：admin

本demo页面使用Bootstrap搭建，后端使用SpringMVC+Spring+MyBatis框架，数据库使用MySQL，使用Maven管理依赖，开发工具IntelliJ IDEA。

## 版本
MySQL	8.0.15
c3p0		0.9.5.3
MyBatis 	3.5.2
Spring 		4.3.4.RELEASE

若MySQL版本为5.x 修改 database.properties
```properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306//book_shop?useUnicode=true&characterEncoding=UTF-8
```
# 项目结构
## 数据库
book 主键 bid					书
book_order 主键 oid		订单
order_detail 主键 id			订单细节
user 主键 uid					用户
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200426175407819.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzcwNDkxNQ==,size_16,color_FFFFFF,t_70)

## 代码
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200426164753122.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzcwNDkxNQ==,size_1,color_FFFFFF,t_70)


# 功能
前端功能
浏览记录 每次查看书籍详情页时从数据库中查出放入cookie
购物车 Cart类有两个属性，HashMap<Book,Integer> goods、double totalPrice。goods中Book为键，Integer书的数量为值。totalPrice为购物车内商品总价。当加入购物车时从数据库查出书本信息与购买数量存入session。
注册 user表中插入一条数据
登录 用户名密码 与user表中查出的信息校验
修改信息 在user表中update数据
搜索 以输入的书名为值在book表中模糊查询
分类导航 在book表中去重查询所有种类，以Set集合返回结果
结算 从session中获取用户信息购物车信息 在book_order、order_detail表中插入订单数据。book表中减少库存。在session中清除cart。
查看订单 book_order、order_detail、book 三张表联表查询，返回订单查看页面所有需要的信息。
后端功能类似不再赘述。


# 页面展示
## 前台
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200426165530970.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzcwNDkxNQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020042616561031.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzcwNDkxNQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200426165650740.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzcwNDkxNQ==,size_16,color_FFFFFF,t_70)
## 后台
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200426165841290.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzcwNDkxNQ==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200426165856909.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzcwNDkxNQ==,size_16,color_FFFFFF,t_70)




