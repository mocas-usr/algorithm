package 数据结构.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/9 20:13
 * @email: wangyuhang_mocas@163.com
 */
public class shellSortDemo {
    public static void main(String[] args) {
        int[] arr=new int[80000];
        for(int k=0;k<80000;k++)
        {
            arr[k]= (int) (Math.random()*80000 );//生成0-80000数值之间的8万个数
        }

        /*时间复杂度*/
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr=simpleDateFormat.format(date);
        System.out.println("排序前的时间："+datestr);
        shellSort2(arr);
        Date date2=new Date();
        String datestr2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+datestr2);

    }

    /*移位式希尔排序*/
    public static  void  shellSort(int[] arr)
    {
        //第一轮排序
        int temp=0;
        //十个数据分两组
        int count=0;
        for (int gap=arr.length/2;gap>0;gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                /*遍历所有元素，共五组，每个有2个*/
                for (int j = i - gap; j >= 0; j -= gap)//j-5保证每次i循环，执行一次
                {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;


                    }
                }

            }
//            System.out.println("第"+(++count)+"轮的排序结果"+Arrays.toString(arr));
        }
//        System.out.println("第"+(++count)+"轮的排序结果"+Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr));
//        /*第二轮排序*/
//        for (int i=2;i<arr.length;i++)
//        {
//            /*遍历所有元素，共五组，每个有2个*/
//            for (int j=i-2;j>=0;j-=2)//j-5保证每次i循环，执行一次
//            {
//                if (arr[j]>arr[j+2])
//                {
//                    temp=arr[j];
//                    arr[j]=arr[j+2];
//                    arr[j+2]=temp;
//
//
//                }
//            }
//
//        }
//        System.out.println("第二轮的排序结果");
//        System.out.println(Arrays.toString(arr));
    }

    /*移位式希尔排序2*/
    public static  void  shellSort2(int[] arr)
    {

        /*增量gap。并逐步缩小增量*/
        for (int gap=arr.length/2;gap>0;gap/=2)
        {
            /*从第gap元素，逐个对其所在租进行直接插入排序*/
            for (int i=gap;i<arr.length;i++)
            {
                /*目的是同一分组的数，进行插入排序*/
                int j=i;
                int temp=arr[j];
                if (arr[j]<arr[j-gap])
                {
                    while (j-gap>=0 && temp<arr[j-gap])
                    {
                        /*移动*/
                        arr[j]=arr[j-gap];
                        j-=gap;


                    }
                    /*退出while时*/
                    arr[j]=temp;

                }
            }
        }
    }





}
