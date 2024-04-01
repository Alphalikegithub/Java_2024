/**
 * 这是一个示例类，请参考下述注释，将该Java程序启动，并在控制台输出HelloWorld！
 *
 *  怎么运行从Git上下载下来的代码?
 *      1,首先观察本页面右上角的提示，如果有提示的话：
 *          根据文件右上角的提示，点击setup SDK,然后选择JDK8的版本（或者指向JDK8的安装目录）
 *
 *      2,然后按住快捷键ctrl + alt + shift + s 或者左上角 File --> Project Structure
 *          如此进入工程结构设置，下面的操作都是在该页面下进行
 *
 *      3,设置Project选项页
 *          点击左侧的Project选项页，进行如下设置
 *              a.设置Project SDK为Java8（选择JDK目录即可）
 *              b.将Project Language Level设置为8
 *              c.Project Compiler Output中需要设置一个目录
 *                  该目录为project中java文件编译后class文件的存放位置
 *                  建议设置为：当前工程目录/out
 *                  比如当前工程目录为 E:/idea_space/35th/java35th
 *                  建议out目录设置为 E:/idea_space/35th/java35th/out
 *          如此，完成Project选项页的设置，这一步是工程的基本设置，必须要完成。
 *
 *      4,设置Modules选项页
 *          点击左侧的Modules选项页，进行如下设置：
 *              a.点击页面中间位置的“+”加号，选择选项中Import Module
 *                  （Module已存在，只是不能识别而已，所以直接导入即可，不要点击New Module）
 *              b.找到想要导入module的硬盘位置
 *                  比如0-test这个module位于E:\idea_space\35th\java35th\0-_3test
 *                  直接选择module文件夹，选择OK
 *              c.在随后弹出的窗口中直接next到底，最后选择OK关闭设置。
 *                  如果出现override（覆盖）提示，说明选错了module文件夹，再仔细看一下目录
 *          如此，完成Modules选项页的设置，这一步可以自行选择想要运行代码的module进行import
 *
 *      5，以上完成import module，可以测试一下module下的代码是否正常运行，正常运行即为添加成功
 *
 *      如果出现问题可以尝试再按照步骤操作一遍，实在不行可以重新拉取一遍代码仓库，再整个操作一遍
 *
 *
 * 注释的概念:
 * Java注释,对应英文单词"comment",而英文单词"annotation",对应Java中的注解
 * 单行注释和多行注释都是为了解释一句代码或者一段代码的,区别在于单行注释一行写完解释性语句,而多行注释可以写一段.
 * 文档注释,是用来解释一整个代码结构的,比如解释整个类的类注释,解释整个方法的方法注释等,都需要使用文档注释.
 *
 * 注意事项:
 * 无论是什么注释,都是为了解释下面的一行/一段代码的
 * 所以正确的注释应该写在被注释代码的上面,不应该平行,更不能写在下面
 *
 * 包的概念:
 * 在IDEA当中写Java代码，存在包的概念。Java当中的包有点类似于操作系统中的文件夹，但又不同于文件夹。
 * 包是一个非常基础的概念，下面来讲解一下。
 * 包的作用:
 *      1.和操作系统中的文件夹作用一样,用于
 *          a.组织起庞大的java文件体系,分类管理
 *          b.区分同名的java文件,在同包下不允许出现同名类
 *      2.(面向对象再讲) 用于划分Java语法访问权限
 *
 * 细节/注意事项:
 *      1.在一个Java文件中,只能存在一个public class
 *          并且public class的类名必须和文件名保持一致
 *      2.在一个Java文件中,可以存在很多个非public class
 *          这些非public class和public class 只要是在同一个Java文件中
 *          它们都是同包的关系
 *          而同包下不允许出现同名类
 *      3.(重要)
 *      在任何情况下,都不应该将Java代码(文件)直接写在src目录下
 *      而是必须要先创建一个包,然后在包下创建Java文件
 *
 * 常用IDEA快捷键:
 * (重要)Alt + Enter	快速修复光标位置的编译错误(给出修正提示)，光标放在的位置不同提示的结果也不同 （必备）
 * 在代码中碰到了编译报错(红色波浪线)
 * 或者黄色警告(黄色的阴影)
 * 都可以尝试用该快捷键,IDEA会自动给出提示,以修正代码!
 *
 * (重要)Ctrl + Alt + L	格式化代码，强迫症必备，建议每写几行代码下意识的按一下该快捷键（必备）
 * 非常重要的快捷键,要养成习惯,写几行代码就使用一下该快捷键
 * 注意:
 *      1.该快捷键一定会和QQ的锁定QQ冲突,请关闭QQ的该快捷键
 *      2.该快捷键的使用非常重要,当成大家作业的考核标准,没有使用该快捷键的代码一律不合格!
 *
 * (重要)Ctrl + /	注释光标所在行代码，会根据当前不同文件类型使用不同的注释符号 （必备）
 * (重要)Ctrl + Shift + /	多行注释（必备）
 * Ctrl + Y	删除光标所在行 或 删除选中的行 （必备）
 * Ctrl + D	复制光标所在行 或 复制选择内容，并把复制内容插入光标位置下面（必备）
 *
 * (重要,后面再讲)Alt + Insert	代码自动生成，比如构造方法，get/set方法等等（必备）
 */
public class HelloWorld1 {
    public static void main(String[] args) {
        // 该语句在控制台输出"hello world"字符串
        // 解释性的语句
        System.out.println("hello world!");  // 这里不应该写注释,注释应该单独成行,写在代码的上面

        int a = 10;
        int b = 20;
        int sum = a + b;
        System.out.println(sum);

        /*
            main既不是关键字也不是保留字,它只是约定俗成的程序的入口方法的方法名
            但既然已经是约定俗成了,我们日常开发也尽量不要使用
         */
        int main;
        // int class;
    }
}

// Duplicate class: 'HelloWorld'
// class HelloWorld{}
class A {
}

class B {
}

class C {
}
