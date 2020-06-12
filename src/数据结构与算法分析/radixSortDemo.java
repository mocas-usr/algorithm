package 数据结构与算法分析;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/12 19:51
 * @email: wangyuhang_mocas@163.com
 */
public class radixSortDemo {
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
        radixSort(arr);
        Date date2=new Date();
        String datestr2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+datestr2);


    }
    /*基数排序方法*/
    public static void radixSort(int[] arr)
    {
        /*第一轮，针对每个元素的个位进行排序处理*/
        /*定义一个二维数组，表示十个桶，每个桶就是一个一维数组*/
        /*说明，
        1.二维数组包括十个一维数组
        * 2.为了防止在放入数的时候，数据溢出，则每个一维数组大小定为arr.length
        3.基数排序是时间换空间的经典算法*/
        int[][] bucket=new int[10][arr.length];
        //bucket[i][j]，i表示第几个桶，j表示第i个桶中放的元素个数，下面用bucketCount[k]表示个数，k表示第几个桶=i

        /*先得到数组中最大数的位数*/
        int max=arr[0];
        for (int i=1;i<arr.length;i++)
        {
            if (arr[i]>max)
            {
                max=arr[i];
            }
        }
        /*得到最大位数*/
        int maxLength=(max+"").length();
        /*为了记录每个桐中，实际存放了多少个数据，我们定义一个一维数组来记录每次放入的数据个数
        * bucketCount[0]记录的就是bucket[0]桶放入的数据个数
        *
        * */

        int[] bucketCount=new int[10];

        /*使用循环处理代码*/
        for (int i=0,n=1;i<maxLength;i++,n=n*10)
        {

            /*第n轮针对每个元素个位进行排序处理,第二次是十位，第三次百位*/
            for (int j = 0; j < arr.length; j++) {
                /*取出每个元素的个位数*/
                int digitElement = arr[j] / n % 10;
                /*放到对应桶中*/
                bucket[digitElement][bucketCount[digitElement]] = arr[j];
                bucketCount[digitElement]++;
            }
            /*按照这个桶的顺序，一维数组的下标依次取出，放回原来数组*/
            int index = 0;
            /*遍历每一个桶，并将桶中数据放入原数组,k表示第几个桶*/
            for (int k = 0; k < bucketCount.length; k++) {
                /*如果桶中有数据，我们才放入原数组*/
                if (bucketCount[k] != 0) {
                    /*循环该桶，即第k个桶，放入*/
                    for (int l = 0; l < bucketCount[k]; l++) {
                        /*取出元素放入到arr*/
                        arr[index++] = bucket[k][l];
                    }
                }
                /*第一轮结束之后要清零*/
                bucketCount[k] = 0;
            }
        }




    }


}

