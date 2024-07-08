package com.cskaoyan.javase.stack;

/**
 * @author alpha
 * @program: Java_2024
 * @description: 栈的相关应用
 * @since 2024-07-08 16:43
 **/

public class Demo3 {
    public static void main(String[] args) {
        String str = "123456789";
        //987654321
        String reNumber = reNumber(str);
        System.out.println("reNumber = " + reNumber);

        /* ************************************* */
        String str1 = "public class Demo4 {public static void main(String[] args) { return 0} } {";
        boolean bool = judgeBracket(str1);
        System.out.println("bool = " + bool);
    }



    /**
     * 反转字符串
     * 实现reNumber(str)方法，反转字符串
     * @return void
     * @author alpha
     * @since 2024/07/08 16:44
     */
    private static String reNumber(String str) {
        MyLinkedStack<Character> stack = new MyLinkedStack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        StringBuffer buffer = new StringBuffer();
        while(!stack.isEmpty()){
            Character pop = stack.pop();
            //拼接字符串
            buffer.append(pop);
        }
        return buffer.toString();
    }


    /**
     * 括号匹配问题
     * 实现judgeBracket(str)方法来判断括号匹配
     * @param str
     * @return boolean
     * @author alpha
     * @since 2024/07/08 17:09
     */
    private static boolean judgeBracket(String str) {
        MyArrayStack<Character> stack = new MyArrayStack<>();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);

            if(charAt == '{'){
                stack.push('}');
            } else if(charAt == '('){
                stack.push(')');
            } else if (charAt == '[') {
                stack.push(']');
            } else if (charAt == ']' || charAt == ')' || charAt == '}') {
                //解决'{'  '['  '('  在最前面的问题
                if(stack.isEmpty()){
                    return false;
                }

                Character pop = stack.pop();
                if(pop != charAt){
                    return false;
                }
            }
        }
        //解决'}'  ']'  ')'  在最后面的问题
        return stack.isEmpty();
    }

}
