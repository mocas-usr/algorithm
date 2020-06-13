package 数据结构与算法分析.sort;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/7 20:50
 * @email: wangyuhang_mocas@163.com
 */
public class recursionTest {
    public static void main(String[] args) {

        /*回顾打印机制*/
//        test(4);
        test1(4);
        factorial(4);
    }

    public static void test(int n)
    {
        if (n>2)
        {
            test(n-1);
        }
        System.out.println("n="+n);

    }
    public static void test1(int n)
    {
        if (n>2)
        {
            test1(n-1);
        }
        else
        {
            System.out.println("n="+n);
        }


    }

    public static int   factorial(int n)
    {
        if (n==1)
            return 1;
        else
        {
            return factorial(n-1)*n;
        }
    }
}
