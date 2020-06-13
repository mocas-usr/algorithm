package 数据结构与算法分析.search;

import 数据结构与算法分析.radixSortDemo;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/13 10:56
 * @email: wangyuhang_mocas@163.com
 */
public class fibonacciSearchDemo {

    public static int maxsize=20;
    public static void main(String[] args) {

        int[] arr={1,85,65,23,75,288};
        radixSortDemo.radixSort(arr);
        System.out.println("需要查找的数组"+Arrays.toString(arr));
        int index=fibSearch(arr,1);
        System.out.println(index);

    }

    /*创建斐波那契数列*/
    public  static int[] fib()
    {
        int[] f=new int[maxsize];
        f[0]=1;
        f[1]=1;

        for (int i=2;i<maxsize;i++)
        {
            f[i]=f[i-1]+f[i-2];

        }
        return f;


    }

    /*编写斐波那契查找数列*/
/*使用非递归的方式*/
    public static int fibSearch(int[] arr,int key)
    {
        int low=0;
        int high=arr.length-1;
        int k=0;//表示斐波那契分割数值的下标

        int mid=0;//存放mid

        int[] f=fib();
        /*获取斐波那契分割数值的下标*/
        while (high>f[k]-1)
        {
            k++;

        }
        /*因为f[k]可能大于a的长度，因此需要Array类构造新的数组，指向temp[]*/
        /*不足的部分使用0填充 */
        int[] temp= Arrays.copyOf(arr,f[k]);
        for (int i=high+1;i<temp.length;i++)
        {
            temp[i]=arr[high];

        }

        /*使用while来循环处理，找到key*/
        while (low<=high)
        {
            mid=low+f[k-1]-1;
            if (key<temp[mid])//我们应该继续向数组的左边查找
            {
                high=mid-1;
                /*为什么是k--，
                *   1.全部元素=前面的元素+后面的元素
                * 2.f[k]=f[k-1]+f[k-2]
                * 3.因为前面有f[k-1]个元素，拆分成f[k-1]=f[k-2]+f[k-3]
                *
                * 4.即进入下一次循环*/
                k--;
            }
            else if (key>temp[mid])//向右边查找
            {
                low=mid+1;
                /*为什么是k-2*/
                k=k-2;
            }
            else//找到了
            {
                //需要确定是哪个条件
                if (mid<=high)
                {
                    return mid;
                }else
                {
                    return high;
                }
            }
        }
        return -1;


    }
}
