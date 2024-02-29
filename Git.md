# Git

## 1. 介绍

Git是一个<span style='color:red;background:yellow;font-size:文字大小;font-family:字体;'>**版本控制**</span>工具。可以帮助我们追踪文件在不同时间点下不同的的状态，记录文件产生的变化。

为什么要记录文件产生的变化呢？

![image-20220505100734629](img/image-20220505100734629.png)

上图中：

1. 用户A向文件中添加了注册功能
2. 用户B向文件中添加了登录功能

假如此时项目组来了一个新人，这个新人把A和B的代码都删掉了，那么如果没有版本控制的话，A和B之前的工作就都白费了，所以我们要去记录文件在不同时间点下的不同的状态，去对文件进行版本控制。

>历史：linus，其实在早期的时候就是用来去管理Linux的内核代码的



Git特点：

- 分布式
- 离线工作
- 可以回退





## 2. 安装

- 下载

  [官网下载地址](https://github.com/git-for-windows/git/releases/download/v2.36.0.windows.1/Git-2.36.0-64-bit.exe)

  ![image-20220505101837549](img/image-20220505101837549.png)



- 安装

  傻瓜式安装即可。

  ![image-20220505102146840](img/image-20220505102146840.png)

​	上面的这一步一定要勾上，这个表示记住Git登录凭证



## 3. 使用

### 3.0 分布式版本控制工具

SVN：集中式的版本控制工具

GIT：分布式版本控制工具

![image-20220505103216305](img/image-20220505103216305.png)

### 3.1 Git工作流程

![image-20220505110902889](img/image-20220505110902889.png)





### 3.2 Git操作

#### 3.2.0 注册账号

去Gitee | Github | Gitlab 注册账号

<span style='color:red;background:yellow;font-size:文字大小;font-family:字体;'>**记住：用户名 | 密码 | 邮箱**</span>

#### 3.2.1 新建远程仓库

![image-20220505111951730](img/image-20220505111951730.png)



- 修改为开源项目

![image-20220505112108500](img/image-20220505112108500.png)



#### 3.2.2 clone

我们可以使用 clone把远程仓库中的文件拉取到本地

> git clone https://gitee.com/ciggar/test-39th.git
>
> 默认会创建一个和远程仓库同名的文件夹

> 也可以克隆到指定的文件夹
>
> git clone  https://gitee.com/ciggar/test-39th.git path

init：也可以初始化本地仓库，初始化本地仓库之后还需要和远程仓库建立联系，现在基本不使用了



#### 3.2.3 status

status这个命令可以显示出工作区和暂存区的变化。

<span style='color:white;background:red;font-size:文字大小;font-family:字体;'>**工作区的变化**</span>

<span style='color:white;background:green;font-size:文字大小;font-family:字体;'>**暂存区的变化**</span>

![image-20220505113728974](img/image-20220505113728974.png)



#### 3.2.4 add

add可以把工作去中的变化提交到暂存区。

add有几种提交的方式

> 指定文件提交：git add fileName 
>
> 指定文件的类型提交：git add *.txt
>
> 提交所有的文件：git add .



#### 3.2.5 commit

提交是指：把暂存区中的变化提交到本地仓库。

可不可以指定文件提交呢？不能



提交这一步有几个注意事项：

1. 会产生版本信息
2. 需要记录提交的内容
3. 第一次提交的时候需要设置用户名和邮件地址



提交之前，我们需要设置用户名和邮件，两种方式

- 直接在当前用户的家目录下创建一个  `.gitconfig` 文件，在里面增加如下信息

  ```ini
  [user]
  	name = ciggar
  	email = 291136733@qq.com
  ```

- 通过命令来配置

  ```shell
  git config --global user.name ciggar
   
  git config --global user.email 291136733@qq.com
  ```

接下来就可以去提交：

```shell
git commit -m "提交信息"

# 提交信息：可以统一一个模板，例如：Date:20220505 Auther:ciggar Msg:增加了几个文件
```

提交会产生一个版本信息

![image-20220505115431670](img/image-20220505115431670.png)



#### 3.2.6 log

可以查看本地仓库中版本信息

![image-20220505143810286](img/image-20220505143810286.png)



#### 3.2.7 push

当本地仓库中的版本领先于远程仓库的时候，就可以把本地仓库中的变化提交到远程仓库。

当我们第一次提交的时候，我们需要输入对应的网站（Gitee | Github | Gitlab ）的用户名和密码。

![image-20220505144311101](img/image-20220505144311101.png)



#### 3.2.8 pull

当本地仓库的版本落后于远程仓库的时候，就可以通过pull 来拉取远程仓库中的变化。

![image-20220505144832529](img/image-20220505144832529.png)



### 3.3 协作开发

#### 邀请成员

![image-20220505145514981](img/image-20220505145514981.png)

#### 版本冲突

![image-20220505152108206](img/image-20220505152108206.png)

在上这种情况中，假如开发A和开发B变化的是不同的文件或者是内容的话，Git可以自动合并，只需要我们提交 commit信息就可以。





![image-20220505150856664](img/image-20220505150856664.png)



<span style='color:red;background:yellow;font-size:文字大小;font-family:字体;'>**假如开发A和开发B开发的是同一个文件的话，那么就会产生冲突，这个时候我们就需要处理冲突然后再提交。**</span>



从以上的案例中我们可以得知几个经验：

1. 当我们需要push代码的时候，先pull一下，不然可能会push失败

2. 先push的人不解决冲突，后push的人需要解决冲突

3. 一早上进公司之后第一件事情就是拉取代码，下班之前最后一件事情就是提交代码

4. 每开发完一个功能就向远程仓库推送一次代码，不要积累到一起了再推送，不然可能会有大量的冲突要你解决

5. 冲突会在文件中产生 `<<<<<<<< | >>>>>>>>>` 这样的文件内容，后续我们在开发的时候可以通过idea中的快捷键快速查找到冲突产生的位置。

   全局搜索：ctrl + shift + f 



### 3.4 后悔药

![image-20220505160910201](img/image-20220505160910201.png)

#### git checkout

可以回退工作区的内容。回退的内容不能找到，一定要慎用。

#### git reset

可以让暂存区中的变化回退到工作区，没有对工作区中文件的内容产生影响

#### git reset --hard 版本号

可以让本地仓库回退到历史的一个版本

###  3.5 忽略文件

我们可以再Git仓库的根目录下，创建一个  `.gitignore` 文件，这个文件中 可以配置 在本Git仓库中，哪些文件不被追踪变化。

在`.gitignore`中可以配置哪些内容呢？

```properties
# 忽略 .idea文件夹
.idea
target

# 忽略单个文件
cskaoyan.txt

# 忽略某个文件类型
*.iml
```

>1. .gitignore自己本身要被git管理起来，让小组内的成员都使用同一个忽略文件
>2. <span style='color:red;background:yellow;font-size:文字大小;font-family:字体;'>**忽略文件一定在要一开始建立仓库的时候就创建**</span>，已经被追踪的内容，不能再前行忽略





