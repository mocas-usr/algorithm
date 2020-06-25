package 数据结构.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/10 19:47
 * @email: wangyuhang_mocas@163.com
 */
public class quickSortDemo {
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
        quickSort(arr,0,arr.length-1);
        Date date2=new Date();
        String datestr2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+datestr2);
    }

    public static void quickSort(int[] arr,int left,int right)
    {
        int l=left;
        int r=right;
        /*中值*/
        int pivot=arr[(left+right)/2];
        int temp=0;
        /*while循环的目的是让比pivot小的放到左边，比他大的放在右边*/
        while(l<r)
        {
            /*在pivot的左边一直找，找到大于或者等于pivot的值，才退出*/
            while(arr[l]<pivot)
            {
                /*在pivot左边一直找，找到大于等于pivot值时，才退出*/
                l+=1;

            }

            while (arr[r]>pivot)
            {
                /*在pivot右边一直找，找到大于等于pivot值时，才退出*/
                r-=1;
            }
            /*如果l>=r，说明pivot的左右两边的值，全部是左边小于pivot，右边大于pivot*/
            if (l>=r)
            {break;}

            /*交换*/
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            /*交换完后，发现arr[l]=pivot相等r--，前移*/
            if (arr[l]==pivot)
            {
                r-=1;
            }
            /*如果交换完之后，发现这个arr[r]=pivot，l++*/
            if (arr[r]==pivot)
            {
                l+=1;
            }
        }
        /*如果l==r，必须l++，r--否则出现栈溢出*/
        if (l==r)
        {
            l+=1;
            r=r-1;
        }
        if (left<r)
        {
            /*向左递归*/
            quickSort(arr,left,r);
        }
        if (right>l)
        /*向右递归*/
        {quickSort(arr,l,right);}
    }

}
