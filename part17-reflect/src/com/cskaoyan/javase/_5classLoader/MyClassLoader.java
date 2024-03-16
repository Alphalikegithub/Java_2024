package com.cskaoyan.javase._5classLoader;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-16 15:41
 **/
//继承ClassLoader 重写findClass方法
public class MyClassLoader extends ClassLoader{
    //定义成员变量
    String classPath;

    public MyClassLoader(String classPath) {

    }

    /**
     * 加载class文件，并读取，转为二进制数据，返回的是Class对象
 * @param name
     * @return java.lang.Class<?>
     * @author DOC
     * @since 2024/03/16 16:14
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class cls = null;
        //读取这个class文件，读取到内存，转为二进制数据 放入byte[]
        try {
            byte[] data = getData();
            //将一个byte数组转换为Class类的实例
            // String name-->类名,byte[] b-->字节码文件的数据,int off,int len
            cls = defineClass(name, data, 0, data.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cls;
    }

    private byte[] getData() throws IOException {
        //创建字节输入流读取class文件
        FileInputStream fileInputStream = new FileInputStream(classPath);
        //借助一个类ByteArrayOutputStream()
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int readCount;
        while((readCount = fileInputStream.read(bytes)) != -1){
            out.write(bytes,0,readCount);
        }
        //while结束后 表明class文件中的数据都已写入byte[]
        //得到这个数组 byteArray中存放的都是class文件中的数据
        byte[] byteArray = out.toByteArray();
        return byteArray;
    }
}
//