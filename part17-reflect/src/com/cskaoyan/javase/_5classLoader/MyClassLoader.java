package com.cskaoyan.javase._5classLoader;

/**
 * @program: Java_2024
 * @description:
 * @create: 2024-03-16 15:41
 **/
//继承ClassLoader 重写findClass方法
public class MyClassLoader extends ClassLoader{
    /**
     *  
     * @param name 
     * @return java.lang.Class<?>
     * @author DOC
     * @since 2024/03/16 16:10 
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
//