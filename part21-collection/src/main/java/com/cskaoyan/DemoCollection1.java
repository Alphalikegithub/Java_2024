package com.cskaoyan;

/**
 * @author alpha
 * @program: Java_2024
 * @description:
 * @since 2024-07-22 10:21
 **/


import java.util.Collection;
import java.util.LinkedList;

/**
 boolean	add(E e)
 确保此集合包含指定的元素（可选操作）。
 boolean	addAll(Collection<? extends E> c)
 将指定集合中的所有元素添加到此集合（可选操作）。
 void	clear()
 从此集合中删除所有元素（可选操作）。
 boolean	contains(Object o)
 如果此集合包含指定的元素，则返回 true 。
 boolean	containsAll(Collection<?> c)
 如果此集合包含指定 集合中的所有元素，则返回true。
 boolean	equals(Object o)
 将指定的对象与此集合进行比较以获得相等性。
 int	hashCode()
 返回此集合的哈希码值。
 boolean	isEmpty()
 如果此集合不包含元素，则返回 true 。
 Iterator<E>	iterator()
 返回此集合中的元素的迭代器。
 default Stream<E>	parallelStream()
 返回可能并行的 Stream与此集合作为其来源。
 boolean	remove(Object o)
 从该集合中删除指定元素的单个实例（如果存在）（可选操作）。
 boolean	removeAll(Collection<?> c)
 删除指定集合中包含的所有此集合的元素（可选操作）。
 default boolean	removeIf(Predicate<? super E> filter)
 删除满足给定谓词的此集合的所有元素。
 boolean	retainAll(Collection<?> c)
 仅保留此集合中包含在指定集合中的元素（可选操作）。
 int	size()
 返回此集合中的元素数。
 default Spliterator<E>	spliterator()
 创建一个Spliterator在这个集合中的元素。
 default Stream<E>	stream()
 返回以此集合作为源的顺序 Stream 。
 Object[]	toArray()
 返回一个包含此集合中所有元素的数组。
 <T> T[]	toArray(T[] a)
 返回包含此集合中所有元素的数组;返回的数组的运行时类型是指定数组的运行时类型。
 */
public class DemoCollection1 {
    public static void main(String[] args) {
        Collection<String> collection = new LinkedList<>();
        //1.boolean	add(E e)
        collection.add("zhangsan");
        collection.add("lisi");
        collection.add("wangwu");

        System.out.println(collection);
        System.out.println("---------------------------------------------");


        Collection<String> collection2 = new LinkedList<>();
        //2.boolean	addAll
        collection2.addAll(collection);//相当于把collection复制一份放到collection2中
        System.out.println(collection2);
        System.out.println("---------------------------------------------");


        //3.boolean	remove(Object o)
        collection.remove("zhangsan");
        System.out.println(collection);
        System.out.println("---------------------------------------------");


        collection2.add("ceshi");
        collection2.add("teat");
        //4.boolean	removeAll(Collection<?> c)
        collection2.removeAll(collection);
        System.out.println(collection2);
        System.out.println("---------------------------------------------");


        //5.boolean	contains(Object o)
        System.out.println(collection.contains("zhangsan"));
        System.out.println(collection.contains("lisi"));
        System.out.println("---------------------------------------------");



// -------------------------------- 集合类中增删(改)查的方法 --------------------------------
//    boolean	add(E e)确保此集合包含指定的元素（可选操作）。
//    boolean	addAll(Collection<? extends E> c)将指定集合中的所有元素添加到此集合（可选操作）。
//    boolean	contains(Object o)如果此集合包含指定的元素，则返回 true 。
//    boolean	containsAll(Collection<?> c)如果此集合包含指定 集合中的所有元素，则返回true。
//    boolean	remove(Object o)从该集合中删除指定元素的单个实例（如果存在）（可选操作）。
//    boolean	removeAll(Collection<?> c)删除指定集合中包含的所有此集合的元素（可选操作）。
//    default boolean	removeIf(Predicate<? super E> filter)删除满足给定谓词的此集合的所有元素。
//    boolean	retainAll(Collection<?> c)仅保留此集合中包含在指定集合中的元素（可选操作）。



// -------------------------------- 集合类一般都具有的方法 --------------------------------

        System.out.println("collection2.isEmpty() = " + collection2.isEmpty());
        System.out.println("collection.equals(collection2) = " + collection.equals(collection2));
        System.out.println("(collection == collection2) = " + (collection == collection2));

        Collection collection3 = new LinkedList<>();
        collection3.addAll(collection);
        System.out.println("collection3 = " + collection3);
        collection3.clear();
        System.out.println("collection3 = " + collection3);
        System.out.println("---------------------------------------------");

//    boolean	isEmpty()如果此集合不包含元素，则返回 true 。
//    int	size()返回此集合中的元素数。
//    boolean	equals(Object o)将指定的对象与此集合进行比较以获得相等性。
//    int	hashCode()返回此集合的哈希码值。
//    void	clear()从此集合中删除所有元素（可选操作）。

        Object[] objects = collection.toArray();
        for(int i = 0; i < objects.length; i ++){
            System.out.print(objects[i]);
            System.out.print(" ");

        }

// -------------------------------- 集合类中的特殊方法 --------------------------------

//    Iterator<E>	iterator()返回此集合中的元素的迭代器。
//    Object[]	toArray()返回一个包含此集合中所有元素的数组。
//    <T> T[]	toArray(T[] a)返回包含此集合中所有元素的数组;返回的数组的运行时类型是指定数组的运行时类型。
    }


}
