package com.example.stringtest;

public class BruteForce {
    //暴力匹配算法
    public static void main(String[] args) {
        //测试暴力匹配法
        String str1 = "dfsgregegfv";
        String str2 = "sgre";
        int index = violenceMatch(str1,str2);
        System.out.println(index);

    }

    public static int violenceMatch(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0;//索引指向s1
        int j = 0;//索引指向s2

        while(i < s1Len && j < s2Len){
            //保证匹配不越界

            if(s1[i] == s2[j]) {
                i++;
                j++;
            }else { //未匹配成功
                //匹配失败,把i置为开始匹配时i的后一个
                //j置为0，从头开始
                //性能在这里很低，回溯为第一个
                i = i - (j - 1);
                j = 0;
            }
        }

        //判断是否匹配成功
        if(j == s2Len){
            return i - j;
        }else {
            return -1;
        }
    }

}