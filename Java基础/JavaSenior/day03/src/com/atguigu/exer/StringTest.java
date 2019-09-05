package com.atguigu.exer;

/**
 * 一道面试题
 * @author shkstart
 * @create 2019 上午 11:32
 */
public class StringTest {

    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }
    public static void main(String[] args) {

        String s = "userlist";
        System.out.println(s.length());
        System.out.println(s.charAt(1));
        System.out.println(s.isEmpty());
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(s.trim());
        System.out.println(s.equals("s"));
        System.out.println(s.compareTo("ssssssssssssss"));
        System.out.println(s.substring(2));

    }
}




