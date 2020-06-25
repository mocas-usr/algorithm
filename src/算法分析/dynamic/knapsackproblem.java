package 算法分析.dynamic;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/25 20:15
 * @email: wangyuhang_mocas@163.com
 */
public class knapsackproblem {

    public static void main(String[] args) {
        int[] w={1,4,3};
        int[] val={1500,3000,2000};//物品的价值
        int m=4;//背包的容量
        int n=val.length;//物品的个数

        /*为了记录商品情况，定义二维数组*/
        int[][] path=new int[n+1][m+1];

        /*创建二维数组，表*/
        //v[i][j]表示在i个物品中能够装入容量为j的背包的最大价值
        int[][] v=new int[n+1][m+1];
        /*初始化第一行，第一列，本程序可以不处理，默认是0*/
        for (int i=0;i<v.length;i++)
        {
            v[i][0]=0;
        }
        for (int i=0;i<v[0].length;i++)
        {
            v[0][i]=0;
        }

        /*根据前面得到的公式进行处理*/
        for (int i=1;i<v.length;i++)//不处理第一行，第一列
        {
            for (int j=1;j<v[0].length;j++)
            {
                if (w[i-1]>j)
                {
                    v[i][j]=v[i-1][j];
                }
                else
                {
                    /*公式里的i进行了调整*/
                    //v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    if (v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]])
                    {
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        //把当前情况记录到path
                        path[i][j]=1;
                    }
                    else
                    {
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }
        /*输出一下v。看目前的情况*/
        for (int i=0;i<v.length;i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        /*最后放入最后哪些商品*/
//        for (int i=0;i<path.length;i++)
//        {
//            for (int j=0;j<path[i].length;j++)
//            {
//                if ()
//                System.out.printf( "第%d个商品放入到背包\n",i);
//            }
//        }
        int i=path.length-1;//行的最大下标
        int j=path[0].length-1;
        while (i>0 && j>0)//从path最后开始走
        {
            if (path[i][j]==1)
            {
                System.out.printf( "第%d个商品放入到背包\n",i);
                j-=w[i-1];
            }
            i--;
        }
//        for (int k=0;k<path.length;k++)
//        {
//            for (int h=0;h<path[i].length;h++)
//            {
//                System.out.printf(path[k][h]+"  ");
//            }
//        }




    }
}
