package 数据结构与算法分析.search;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/13 10:27
 * @email: wangyuhang_mocas@163.com
 */
public class inserValueSearchDemo {
    public static void main(String[] args) {
        int[] arr=new int[100];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=i+1;

        }

        int index=insertValueSearch(arr,0,arr.length-1,56);
        System.out.println(index);
    }

    /*插值查找也需要有序的*/
    public static int insertValueSearch(int[] arr,int left,int right,int findVal)
    {

        /*这个必须有，这个条件
        * 否则，可能越界*/
        if (left>right || findVal<arr[0] ||findVal>arr[arr.length-1])
        {
            return -1;
        }

        /*求mid*/
        int mid=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal=arr[mid];

        if (findVal>midVal)/*如果查找的值比中间的大，向右递归*/
        {
            return insertValueSearch(arr,mid+1,right,findVal);
        }
        else if (findVal<midVal)
        {
            return insertValueSearch(arr, left,mid-1, findVal);

        }
        else
        {
            return mid;
        }

    }

}
