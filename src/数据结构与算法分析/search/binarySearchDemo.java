package 数据结构与算法分析.search;

import 数据结构与算法分析.mergeSortDemo;
import 数据结构与算法分析.radixSortDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/13 9:11
 * @email: wangyuhang_mocas@163.com
 */
/*使用二分数组的查找，要求数组必须有序*/
public class binarySearchDemo {
    public static void main(String[] args) {
        int[] arr={1,8,28,15,79,15,15,56};
        radixSortDemo.radixSort(arr);
        System.out.println("需要查找的数组是"+ Arrays.toString(arr));
//        int index=binarySearch(arr,0,arr.length,16);
        List<Integer> resultIndex=binarySearch(arr,0,arr.length-1,15);
        System.out.println(resultIndex);
    }

    /**/
    public static  ArrayList<Integer> binarySearch(int[] arr,int left,int right,int findVal)
    {
        if (left>right)
        {
            return new ArrayList<Integer>();
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];

        /*前提从小到大的排序*/
        if (findVal>midVal)/*向右递归*/
        {
            return binarySearch(arr,mid+1,right,findVal);

        }
        else if (findVal<midVal)
        {
            return binarySearch(arr,left,mid-1,findVal);
        }
        else
        {
            /*出现多个查找的数值时，需要引入arraylist
            * 因为排序按照大小排序，所以值相同的一定相邻*/
            ArrayList<Integer> resIndex=new ArrayList<Integer>();
            /*向mid左边扫描，将所有满足条件的元素的下标，加入arraylist*/
            int temp=mid-1;
            while (true)
            {
                if (temp<0 ||arr[temp]!=findVal)
                {
                        break;
                }
                resIndex.add(temp);//把左边的放入
                temp-=1;
            }
            resIndex.add(mid);//中间的放入
            /*向右扫描*/
            temp=mid+1;
            while (true)
            {
                if (temp>arr.length-1 ||arr[temp]!=findVal)
                {
                    break;
                }
                resIndex.add(temp);//把左边的放入
                temp+=1;
            }
            return resIndex;
        }
    }



}
