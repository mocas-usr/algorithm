package 算法分析.binarysortDemo;

import static 数据结构.sort.radixSortDemo.radixSort;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/25 15:59
 * @email: wangyuhang_mocas@163.com
 */
public class binarySearchDemo {
    public static void main(String[] args) {

        int[] arr={1,3,8,6,38,26,28,15,85};
        radixSort(arr);
        System.out.println(arr);
        int index=binarySearch(arr,2);
        System.out.println("index="+index);
    }
    /*二分查找的非递归实现，默认arr是升序*/
    public static int   binarySearch(int[] arr,int target)
    {
        int left=0;
        int right=arr.length-1;
        while (left<=right)
        {
            int mid=(left+right)/2;
            if (arr[mid]==target)
            {
                return mid;
            }else if (arr[mid]>target)
            {
                right=mid-1;//需要向左边查找
            }
            else
            {
                left=mid+1;
            }

        }
        return -1;
    }
}
