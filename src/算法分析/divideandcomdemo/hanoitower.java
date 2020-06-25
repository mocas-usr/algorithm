package 算法分析.divideandcomdemo;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/25 16:35
 * @email: wangyuhang_mocas@163.com
 */
public class hanoitower {
    public static void main(String[] args) {

        hanoitower(5,'A','B','C');
    }

    /*汉诺塔移动方法*/
    //使用分治算法
    public static void hanoitower(int num,char a,char b,char c)
    {
        /*如果只有一个盘*/
        if (num==1)
        {
            System.out.println("第一个盘"+a+"->"+c);
        }else
        {
            /*如果我们有n>=2，我们总可以看成两个盘  1最下边的一个盘   2上面所有盘
            * 1先把最上面所有盘a>b，移动过程会使用c
            * */
            hanoitower(num-1,a,c,b);
            //2把下面的盘a>c
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //3把b塔所有盘从b移动到c，移动过程使用a塔
            hanoitower(num-1,b,a,c);



        }
    }
}
