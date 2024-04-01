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
 * 包的概念:
 * 在IDEA的工程（module）下，可以：
 * 右键src目录 --> new --> package来创建包（这里不再配图，因为比较简单）。
 * 注意：
 * 如果直接输入一个字符串就是创建一级包名。
 * 如果想要创建多级包，那么每级包名之间用"."隔开。
 *
 * 包的作用:
 *      1.和操作系统中的文件夹作用是一样的
 *      a.组织起庞大的Java文件体系,用来区分分类
 *      b.(重要)同包下不允许出现同名的Java文件,当然同名的类也是不可以的
 *      扩展:
 *      1.一个Java文件中，只能有一个public修饰的类，并且该public class的类名必须和Java文件的名字保持一致。
 *      但是非public class在一个Java文件中既不限制数量,也不限制名字
 *
 *      2.一个Java文件中可以有多个class,这些class类都是同包的关系
 *      而同包不允许出现同名类
 *      不管public还是非public,类名在同包下都不能同名
 *
 * 注释的概念:
 *      1.单词的问题
 *      Java中的注释英文翻译应当是comment,而不是annotation
 *      annotation在Java中被翻译成注解
 *      注解和class是相当的东西,是一类东西
 *
 *      2.语法问题
 *      3.格式问题,建议把注释写在代码的上面,用来解释下面的代码
 *      建议不要写在后面
 *
 * IDEA的快捷键(重点)
 * ctrl + z 撤销操作
 * (重点)Alt + Enter	快速修复光标位置的(编译)错误，光标放在的位置不同提示的结果也不同 （必备）
 *      重要的不是提示的作用
 *      而是能够快速完成这个工作
 *
 * (最重点)Ctrl + Alt + L	格式化代码，非常重要，强烈建议每写几行代码下意识的按一下该快捷键（必备）
 *
 * Ctrl + Y	删除光标所在行 或 删除选中的行 （必备）
 * Ctrl + D	复制光标所在行 或 复制选择内容，并把复制内容插入光标位置下面（必备）
 * Ctrl + /	注释光标所在行代码，会根据当前不同文件类型使用不同的注释符号 （必备）
 * Ctrl + Shift + /	多行注释（必备）
 *
 */
public class HelloWorld {
    /**
     * 解释main方法的文档注释
     * psvm main方法的快捷键
     * main方法是约定俗成的Java程序的入口方法,启动一个Java程序,被约定成从一个叫main的方法开始
     * 只是约定俗成,但不是强制的要求,main不是关键字或保留字
     * 但也最好不要用main起名字
     */
    public static void main(String[] args) {
        // 该行代码会在控制台打印"hello world!"
        System.out.println("hello world!"); // 该行代码会在控制台打印"hello world!"
        int a = 10;
        int b = 20;
        int sum = a + b;
        // sout输出语句的快捷键
        System.out.println(sum);
        int main;
    }
}

