package 数据结构与算法分析;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/8 19:51
 * @email: wangyuhang_mocas@163.com
 */
public class sortDemo {
    public static void main(String[] args) {
//        int[] arr={2,9,1,-3,10};
       /*测试冒泡排序*/
//        bubbleSort(arr);
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
        /*测试下 冒泡排序的速度，给80000个数据进行测试*/
        /*创建80000个随机数组*/

        int[] arr=new int[80000];
        for(int k=0;k<80000;k++)
        {
            arr[k]= (int) (Math.random()*80000);//生成0-80000数值之间的8万个数
        }

        /*时间复杂度*/
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr=simpleDateFormat.format(date);
        System.out.println("排序前的时间："+datestr);
        /*测试冒泡排序*/
        bubbleSort(arr);
        Date date2=new Date();
        String datestr2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+datestr2);
//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));

       /* *//*第二趟排序*//*
        for (int j=0;j<arr.length-1-1;j++)
        {*//*如果前面的数比后面的数大，则交换*//*
            if (arr[j]>arr[j+1])
            {
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }

        System.out.println("第二趟排序是");
        System.out.println(Arrays.toString(arr));


        *//*第三趟排序*//*

        for (int j=0;j<arr.length-1-2;j++)
        {*//*如果前面的数比后面的数大，则交换*//*
            if (arr[j]>arr[j+1])
            {
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }

        System.out.println("第三趟排序是");
        System.out.println(Arrays.toString(arr));

        *//*第四趟排序*//*

        for (int j=0;j<arr.length-1-3;j++)
        {*//*如果前面的数比后面的数大，则交换*//*
            if (arr[j]>arr[j+1])
            {
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }

        System.out.println("第四趟排序是");
        System.out.println(Arrays.toString(arr));*/
    }

    /*将冒泡排序封装成方法*/
    public static void bubbleSort(int[] arr)
    {
        /*将排序演变过程展示*/
        //第一趟排序就是将最大的数放在后面
        int temp=0;//临时变量
        boolean flag=false;
        for (int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {/*如果前面的数比后面的数大，则交换*/
                if (arr[j] > arr[j + 1]) {
                    flag=true;//发生了交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag)//如果是false，说明这一趟交换没发生，
            {
                break;
            }
            else
            {
                flag=false;//重置为false，等待下一次循环排序
            }
//            System.out.println("第"+(i+1)+"趟排序是");
//            System.out.println(Arrays.toString(arr));

        }
    }
}
