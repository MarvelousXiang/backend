# 一些说明

## 如何启动

首先运行db.sql，主要作用就是创建名为wedb的数据库，也只要创建数据库就行了，不需要手动创建表，jpa会自动创建表；然后修改application.yml里的数据库用户名密码；然后就可以启动项目，第一次启动项目时会自动创建数据库表。

## 实体类设计

### Dish:菜品

```java
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private DishCategory dishCategory;
    @Column
    private DishTaste dishTaste;
    @Column
    private double price;
    @Column
    private String createDate;
    @Column
    private Integer numOfLikes;
}
```

### User:用户

```java
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column(unique = true,nullable = false)
    private String userName;
    @Column(unique = true,nullable = false)
    private String email;
    @Column
    private String password;
    @Column
    private String createDate;
    @Column
    private UserType userType;
}
```

### Likes:收藏，记录用户收藏的菜品，是一个多对多的关系

```java
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer dishId;
    @Column
    private Integer userId;
}
```

### Comment:评论，记录用户对某一道菜的评论

```java
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer userId;
    @Column
    private Integer dishId;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column
    private String createDate;
}
```

### DishCategory:菜品种类 枚举类

后续可以继续添加

```java
public enum DishCategory {
    Qinlei("1"),
    Shucai("2");

    private String value;
    DishCategory(String value){
        this.value=value;
    }
    @Override
    public String toString(){
        return value;
    }
}
```

### DishTaste:菜品味道 枚举类

后续可以继续添加

```java
public enum DishTaste {
    tian("1"),
    xian("2"),
    suan("3"),
    la("4");
    private String value;
    DishTaste(String value){
        this.value=value;
    }
    @Override
    public String toString(){
        return value;
    }
}
```

## 前后端交互

后端返回给前端的数据类型为JSON，具体是ResponseVO.java，和软工二大作业一样。前后端交互方式几乎和软工二大作业一样。

```java
public class ResponseVO {

    private Boolean success;

    private String message;

    private Object content;
}
```

## 面向前端开发人员的一些说明

如果觉得缺少或需要用到哪些接口，可以在下面的表格中自行添加，以提示后端开发工作人员及时完成响应的功能。

后端项目会上传到github，地址为https://github.com/SWargrave/backend ，你们可以git clone下来运行，看一下能不能和前端项目集成。前端项目也赶快建一个github仓库，以便合作编程和后端开发人员clone下来运行。

实体类设计后续肯定会要修改的，比如说菜品总得要有一些图片吧，就光添加这个功能Dish类就肯定要修改了，因为要存储图片URL，至于如何修改，需要前后端开发人员开会协商后再定。

本项目的整体设计目前看来是由前端开发人员决定的，后端部分其实是“面向前端编程”，就是完成前端给的一些任务，当然后续肯定要一起商量整个软件的设计。

本项目的后端将不使用微信的云开发功能，所有后端都运行在自己的服务器上(也就是你自己的电脑)，后续我会把整个后端项目部署在我自己的服务器上。

### User模块接口

以下接口都需要加/api/user前缀

| 请求URL            | 参数                                                         | 请求方法 | 作用                   | 返回值ResponseVO的一些说明 | 是否完成 |
| ------------------ | ------------------------------------------------------------ | -------- | ---------------------- | -------------------------- | -------- |
| /getAllUsers       |                                                              | GET      | 返回所有用户列表       | content类型为List<User>    | 是       |
| /deleteUser        | userName,email(这两个参数只要也只能传一个就行了)(都是String) | POST     | 删除一个用户           | content类型为String        | 是       |
| /register          | RegisterVO(详见具体代码)                                     | POST     | 注册一个用户           | content类型为String        | 是       |
| /updatePassword    | email,oldPassword,newPassword(都是String)                    | POST     | 更新用户密码           | content类型为String        | 是       |
| /getAllUsersOfType | String userType                                              | GET      | 获取某种类型的所有用户 | content类型为List<User>    | 是       |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |
|                    |                                                              |          |                        |                            |          |

### Dish模块接口

以下接口都需要加/api/dish前缀

| 请求URL                       | 参数                         | 请求方法 | 作用                                                         | 返回值ResponseVO的一些说明 | 是否完成 |
| ----------------------------- | ---------------------------- | -------- | ------------------------------------------------------------ | -------------------------- | -------- |
| /getAllDishes                 |                              | GET      | 获取所有菜品                                                 | content类型为List<Dish>    | 是       |
| /getDishById                  | 菜品id(Integer)              | GET      | 根据菜品id获得相应的菜品                                     | content类型为Dish          | 是       |
| /getDishByName                | name(String)                 | GET      | 根据菜品名称获得相应的菜品列表(因为可能有菜品重名)           | content类型为List<Dish>    | 是       |
| /getDishByCategory            | category(String)             | GET      | 根据菜品类型获得相应的菜品列表                               | content类型为List<Dish>    | 是       |
| /getDishByTaste               | taste(String)                | GET      | 根据菜品味道获得相应的菜品列表                               | content类型为List<Dish>    | 是       |
| /addDish                      | DishVO(详见代码)             | POST     | 添加一种菜品                                                 | content为String            | 是       |
| /deleteDish                   | dishId(Integer)              | POST     | 删除一种菜品                                                 | content为String            | 是       |
| /getAllDishesSortByNumOfLikes | String category,String taste | GET      | 获取特定种类、特定味道的菜品列表，并按收藏人数降序排列，种类和味道这两个参数都不是必须的，如不传某个参数，则不会对才参数进行过滤。 | content为List<Dish>        | 是       |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |
|                               |                              |          |                                                              |                            |          |

### Likes模块接口

以下接口都需要加/api/likes前缀

| 请求URL                 | 参数                    | 请求方法 | 作用                       | 返回值ResponseVO的一些说明 | 是否完成 |
| ----------------------- | ----------------------- | -------- | -------------------------- | -------------------------- | -------- |
| /addLike                | userId，dishId(Integer) | POST     | 用户添加某一道菜到收藏夹   | content类型为String        | 是       |
| /deleteLike             | userId,dishId(Integer)  | POST     | 用户取消收藏某一道菜       | content类型为String        | 是       |
| /getAllLikeDishesOfUser | userId(Integer)         | GET      | 获取某个用户的所有收藏的菜 | content类型为List<Dish>    | 是       |
| /getAllLikeUsersOfDish  | dishId(Integer)         | GET      | 获取收藏某道菜的所有用户   | content类型为List<User>    | 是       |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |
|                         |                         |          |                            |                            |          |

### Comment模块接口

以下接口都需要加/api/comment前缀

| 请求URL                         | 参数                    | 请求方法 | 作用                             | 返回值ResponseVO的一些说明 | 是否完成 |
| ------------------------------- | ----------------------- | -------- | -------------------------------- | -------------------------- | -------- |
| /addComment                     | CommentVO(详见具体代码) | POST     | 添加一条评论                     | content类型为String        | 是       |
| /deleteOneCommentById           | id                      | POST     | 删除一条评论                     | content类型为String        | 是       |
| /deleteCommentByUserIdAndDishId | userId,dishId           | POST     | 删除某个用户在某道菜下的所有评论 | content类型为String        | 是       |
| /deleteAllCommentOfUser         | userId                  | POST     | 删除某个用户的所有评论           | content类型为String        | 是       |
| /deleteAllCommentOfDish         | dishId                  | POST     | 删除某道菜的所有评论             | content类型为String        | 是       |
| /getAllCommentOfUser            | userId                  | GET      | 获取某个用户的所有评论           | content类型为List<Comment> | 是       |
| /getAllCommentOfDish            | dishId                  | GET      | 获取某道菜的所有评论             | content类型为List<Comment> | 是       |
| /getCommentByUserIdAndDishId    | userId,dishId           | GET      | 获取某个用户在某道菜下的所有评论 | content类型为List<Comment> | 是       |
|                                 |                         |          |                                  |                            |          |
|                                 |                         |          |                                  |                            |          |
|                                 |                         |          |                                  |                            |          |



## 面向后端开发人员的一些说明

### 数据访问层的框架说明

软工二大作业采用了MyBatis框架，而这里使用的是Spring Boot Jpa框架，个人认为Jpa比MyBatis更加简单好用，不需要手动创建数据库表，只需要写好java实体类，jpa会自动执行创建表的SQL语句，我们只要把数据库建好就行了，其次是jpa不需要写繁琐的xml映射文件，jpa本身就有许多方法可以直接调用，只有当觉得不够用时才需要自己写，关于jpa可以自己上网搜索Spring Boot jpa，很快就能入门。

jpa里的dao层相当于MyBatis项目里的mapper层，如此项目里的UserDao的作用就相当于软工二大作业里面的UserMapper(好像应该是AccountMapper)，其实也不一定要命名成UserDao，命名成UserMapper也完全一样。

### 开发流程

后端开发其实大部分时间都花在了对数据库的增删改查上面，很多高级的功能也只不过是高级一点的增删改查而已(个人观点)，所以当有一个新需求时，首先看一下该需求对应的dao层有没有我们想要的功能，如果没有，再自行添加，其次再看service层，最后是controller层；比如说，我要添加一个更新用户密码的功能（因为该功能比较简单，dao、service、controller几乎都是直接调用上一层的语句，自己本身好像什么事都没做，但情况要是复杂的话就不是这样了），首先要看UserDao.java下有没有这个功能，因为UserDao继承自JpaRepository，所以即使你一行代码也不写，就有很多接口可供调用，在这里我就自己写了一个updatePassword方法（也许这个功能jpa本来就有了，但是我懒得去查，就自己写了一下，因为也不是很复杂），写完之后再在UserService和UserServiceImpl添加响应的方法，并利用UserDao里的方法完成相应的功能，最后在UserController里面添加updatePassword方法，并借助UserService来实现。

当有一个新的需求出现时，开发流程几乎和上述一样；这样的不同的后端开发人员可以相对独立的完成一些功能点。

添加、修改、删除接口时都需要及时修改上面的表格，及时通知前端开发人员。

### 合作编程

我会把所有代码上传到GitHub，地址为https://github.com/SWargrave/backend ，你们点击Fork，然后会在你们的账户下创建一个这个仓库的拷贝，然后git clone你们拷贝到自己账户下的仓库到本地电脑，然后完成开发，然后push到远程仓库(这个仓库还是你们自己账户下的，就是你们Fork过去的)，然后再到https://github.com/SWargrave/backend 界面，点击New pull request，就可以把你们的修改合并到我的仓库。（整个工作流程其实和软工二大作业也差不多）

![image.png](https://i.loli.net/2020/06/09/tI9gEPyuZrQwADN.png)

### 其他的一些说明

TestController.java和templates文件夹下的一些html文件不会在实际的项目中使用，只是用来给后端开发人员测试而已。

其他一些后续可能会用到的东西：

1. MailServiceImpl

```java
@Component
public class MailServiceImpl {
    @Resource
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;
    public void sendMail(String to,String subject,String text){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}
```

这个类可以向指定邮箱发送指定内容，可能应用场景：注册时或找回密码时验证邮箱。

2. CaptchaUtilController

```java
@RestController
@RequestMapping("/api/captcha")
public class CaptchaUtilController {
    @GetMapping("/getOneCaptcha")
    public void getOneCaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        CaptchaUtil vc = new CaptchaUtil();
        BufferedImage image = vc.getImage();
        String text = vc.getText();
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("captchaCode", text);
        CaptchaUtil.output(image, httpServletResponse.getOutputStream());
        System.out.println(text);
    }
}
```

该类可以生成图形验证码，如下图所示，可能应用场景：登录时需要用户输入图形验证码。

![getOneCaptcha.jpg](https://i.loli.net/2020/06/09/TOvW1DXfhKmejgY.jpg)

3. UploadUtil

```java
public class UploadUtil {
    private static final String ACCESS_KEY="ZPeyXAYzF-S_98CMqEpJxkVZQG4VFK5_3svLyn9E";
    private static final String SECRET_KEY="bz9CO0Ujvm8i5ufaAxesI01OFCu0WnRqa8ZEg4LW";
    //    private static final String DOMAIN="http://qb876xjwm.bkt.clouddn.com";
    private static final String DOMAIN="http://file.jwargrave.com";
    private static final String BUCKET_NAME="jwargrave";
    public static String uploadFile(FileInputStream file, String key) {
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
            String upToken = auth.uploadToken(BUCKET_NAME);
            try {
                Response response = uploadManager.put(file, key, upToken, null, null);
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return DOMAIN + "/" + putRet.key;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ignored) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
```

用于上传文件，可能应用场景：菜品图片上传、用户头像上传等。