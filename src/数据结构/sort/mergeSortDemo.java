package 数据结构.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/11 19:33
 * @email: wangyuhang_mocas@163.com
 */
public class mergeSortDemo {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,6,2};
        int[] temp=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);

        System.out.println("排序后"+ Arrays.toString(arr));

    }
    /*分加合的方法*/
    public  static void mergeSort(int[] arr,int left,int right,int[] temp) {
        if (left < right)
        {
            int mid=(left+right)/2;
            /*向左递归分解*/
            mergeSort(arr,left,mid,temp);
            /*向右*/
            mergeSort(arr,mid+1,right,temp);

            /*合并*/
            merge(arr,left,mid,right,temp);
        }
    }

    /*合并的方法
    * 1.left左边有序序列的初始索引
    * 2.mid中间索引
    * 3.temp中转的数组
    * */
    public static  void merge(int[] arr,int left,int mid,int right,int[] temp)
    {
        int i=left;
        int j=mid+1;
        int t=0;//指向temp当前的索引
        /*1.先把左右两边的数据按照顺序填充到temp数组*/
        /*直到左右两边的有序序列，有一边处理为止*/
        while (i<=mid && j<=right)
        {
            /*如果左边元素小于右边元素，将左边拷贝到temp数组
            * 然后t++，i++*/
            if (arr[i]<=arr[j])
            {
                temp[t]=arr[i];
                t+=1;
                i+=1;
            }
            else//反之，则将右边有序的当前元素填充到temp组
            {
                temp[t]=arr[j];
                t+=1;
                j+=1;

            }
        }

        /*2.把有剩余数据的一边的数据，依次全部填充到temp*/

        while(i<=mid)//说明左边的序列，还有剩余，则填充过去temp
        {
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }
        while(j<=right)//说明左边的序列，还有剩余，则填充过去temp
        {
            temp[t]=arr[j];
            t+=1;
            j+=1;
        }

        /*3.将temp数组的元素重新拷贝的到arr*/
        t=0;
        int tempLeft=left;
        while (tempLeft<=right)
        {
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }


    }


}
