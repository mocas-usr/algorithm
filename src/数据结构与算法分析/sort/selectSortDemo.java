package 数据结构与算法分析.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/8 20:51
 * @email: wangyuhang_mocas@163.com
 */
public class selectSortDemo {
    public static void main(String[] args) {
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
        selectSort(arr);
        Date date2=new Date();
        String datestr2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+datestr2);

    }

    /*选择排序*/
    public static void selectSort(int[] arr) {
        /*逐步推导，先复杂，后简单
         * 先简答的思路，后复杂的整合*/

        for (int i = 0; i < arr.length-1; i++)
        {
            int minIndex = i;
            int min = arr[i];


            /*第一轮排序，最小值确定*/
            for (int j = 0 + 1; j < arr.length; j++) {
                if (min > arr[j])//说明假定的最小数，不是最小
                {
                    min = arr[j];//重置min
                    minIndex = j;


                }
            }
            /*最小值和arr[i]做一个交换*/
            if (minIndex!=i)
            {
                arr[minIndex] = arr[0];
                arr[0] = min;
            }

//
//            System.out.println("第一轮之后");
//            System.out.println(Arrays.toString(arr));
        }
    }
}