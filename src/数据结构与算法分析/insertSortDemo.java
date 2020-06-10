package 数据结构与算法分析;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/9 19:33
 * @email: wangyuhang_mocas@163.com
 */
public class insertSortDemo {
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
        insertDemo(arr);
        Date date2=new Date();
        String datestr2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+datestr2);
    }

    /*插入排序*/
    public  static void insertDemo(int[] arr)
    {

        int insertValue = 0;

        int insertIndex = 0;//插入数之前的下标
        for (int i=1;i<arr.length;i++) {
            /*定义待插入的数*/
            insertValue = arr[i];

            insertIndex = i - 1;//插入数之前的下标

            /*给insertVal插入合适的位置*/
            /*1.inertInderx>=0 说明没有越界
             * 2.inertval<arr[index]说明还没找到合适位置
             * 3.就要将arr[index]后移*/

            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;


            }
            if (insertIndex + 1!=i)
            {
                /*退出循环时，找到插入位置，inertindex+1*/
                arr[insertIndex + 1] = insertValue;
            }


//            System.out.println("第i轮过后的数组");
//            System.out.println(Arrays.toString(arr));

        }

    }

}
