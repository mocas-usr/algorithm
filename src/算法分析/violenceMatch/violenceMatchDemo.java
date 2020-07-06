package 算法分析.violenceMatch;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/7/5 9:02
 * @email: wangyuhang_mocas@163.com
 */
public class violenceMatchDemo {
    public static void main(String[] args) {
        //测试暴力匹配算法
        String str1="nihho,今天是个好日子，天气很不错";
        String str2="天气很不错";
        int index=violenceMatch(str1,str2);
        System.out.println("index"+index);

    }
    //暴力匹配
    public static int violenceMatch(String str1,String str2)
    {
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();

        int s1Len=s1.length;
        int s2Len=s2.length;

        int i=0;//i索引指向s1
        int j=0;//j索引指向s2
        while (i<s1Len &&j<s2Len)//保证匹配不越界
        {
            if (s1[i]==s2[j])
            {
                j++;
                i++;
            }
            else {//没有匹配成功
                i=i-(j-1);
                j=0;

            }
        }
        if (j==str2.length())
        {
            return i-j;
        }
        else {
             return -1;
        }
    }
}
