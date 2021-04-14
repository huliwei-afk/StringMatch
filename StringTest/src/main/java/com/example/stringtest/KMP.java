package com.example.stringtest;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext("ABCDABD");
        System.out.println("next =" + Arrays.toString(next));

        int index = kmpSearch(str1, str2,next);
        System.out.println(index);
    }

    //写出kmp搜索算法
    public static int kmpSearch(String s1, String s2, int[] next){
        //遍历
        for(int i = 0, j = 0; i < s1.length(); i++){
            //需要考虑处理str1.charAt(i) != str2.charAt(j)
            //kmp算法核心点
            while(j > 0 && s1.charAt(i) != s2.charAt(j)){
                j = next[j - 1];
            }

            if(s1.charAt(i) == s2.charAt(j)){
                j++;
            }

            if(j ==s2.length()){
                //找到了
                return i - j + 1;
            }
        }
        return -1;
    }

    //获取一个字符串的部分匹配值(表)；
    public static int[] kmpNext (String dest){
        //创建一个next数组保存部分匹配值
        int[] next = new int[dest.length()];
        //如果字符串是长度为1的字符串，部分匹配值就是0
        next[0] = 0;

        //j代表前缀和后缀相同元素的长度
        for(int i = 1, j = 0; i < dest.length(); i++){
            //当条件不满足即 charAr(i) != charAt(j)时，从next[j - 1]获取新的j
            //直到发现有上述条件满足时才退出
            //kmp算法的核心点
            while(j > 0 && dest.charAt(i) != dest.charAt(j)){
                //公式 那就记下来8
                j = next[j - 1];
            }

            //当这个条件满足时，部分匹配值就 + 1
            if(dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
