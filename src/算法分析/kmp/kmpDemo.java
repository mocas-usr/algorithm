package 算法分析.kmp;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/7/5 10:24
 * @email: wangyuhang_mocas@163.com
 */
public class kmpDemo {
    public static void main(String[] args) {
        String str1="abdcbcbcsahdjkabcdesdhj";
        String str2="abcde";
        int[] next=kmpNext(str2);
        System.out.println("next="+ Arrays.toString(next));

        int index=kmpSearch(str1,str2,next);
        System.out.println("index="+index);

    }

    //写出我们的kmp算法
    //str1源字符串，str2子串，next部分匹配表，子串对应的部分匹配表，如果是-1就是没有匹配到
    public static int kmpSearch(String str1,String str2,int[] next)
    {
        //遍历
        for (int i=0,j=0;i<str1.length();i++)
        {
            //kmp核心点,不相等的时候调整j
            while (j>0 && str1.charAt(i)!=str2.charAt(j))
            {
                j=next[j-1];
            }
            if (str1.charAt(i)==str2.charAt(j))
            {
                j++;
            }
            if (j==str2.length())
            {
                return i-j+1;
            }
        }
        return -1;
    }
    //获取字符串，部分匹配值
    public static int[] kmpNext(String dest)
    {
        //创建next数组
        int[] next=new int[dest.length()];
        next[0]=0;//如果dest的长度是1，则部分匹配值是0
        for (int i=1,j=0;i<dest.length();i++)
        {
            //如果不等时，需要从next[j-1]获取最新的j
            //直到发现有相等条件
            while (j>0 && dest.charAt(i)!=dest.charAt(j))
            {
                j=next[j-1];

            }
            //条件满足时。部分匹配值就需要+1
            if (dest.charAt(i)==dest.charAt(j))
            {
                j++;
            }
            next[i]=j;

        }
        return next;

    }
}
