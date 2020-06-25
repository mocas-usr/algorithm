package 数据结构.tree;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/18 20:19
 * @email: wangyuhang_mocas@163.com
 */
public class heapSortDemo {
    public static void main(String[] args) {
        int[] arr=new int[8000000];
        for(int k=0;k<8000000;k++)
        {
            arr[k]= (int) (Math.random()*80000);//生成0-80000数值之间的8万个数
        }

        /*时间复杂度*/
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datestr=simpleDateFormat.format(date);
        System.out.println("排序前的时间："+datestr);
        /*测试冒泡排序*/
        heapSort(arr);
        Date date2=new Date();
        String datestr2=simpleDateFormat.format(date2);
        System.out.println("排序后的时间："+datestr2);
    }
    /*编写一个堆排序方法*/
    public static void heapSort(int[] arr)
    {
        int temp=0;
        System.out.println("堆排序");
        /*分步完成*/
//        adjustHeap(arr,1,arr.length);
//        System.out.println("第一次"+ Arrays.toString(arr));
//
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第二次"+Arrays.toString(arr));
        /*一次完成*/
        /*将无需序列构成一个堆，根据升序需求选择大顶堆，或者小顶堆*/
        for (int i=arr.length/2-1;i>=0;i--)
        {
            adjustHeap(arr,i,arr.length);
        }
        /*将栈顶元素与末尾元素交换，将最大元素沉到数组末尾
        * 重新调整结构，使其满足堆定义*/
        for (int j=arr.length-1;j>0;j--)
        {
            /*交换*/
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);

        }
       //System.out.println("数组="+Arrays.toString(arr));

    }
    /*将一个数组二叉树，调整一个大顶堆
    功能完成将以i 指向的对应的非叶子节点的数调整成大顶堆
    * arr待调整的数组
    * i表示非叶子节点在数组中的索引
    * length表示对多少个元素继续调整，length逐渐减小*/
    public static void adjustHeap(int[] arr,int i,int length)
    {
        int temp=arr[i];//先取出当前元素的值，保存临时变量
        //开始调整
        for (int k=i*2+1;k<length;k=2*k+1)
        {
            if (k+1<length && arr[k]<arr[k+1])//说明左子节点的值小于右子节点的值
            {
                k++;//k指向右子节点
            }

            if (arr[k]>temp)//如果子节点大于父节点
            {
                arr[i]=arr[k];
                i=k;//把较大的值赋给当前节点，然后i指向k，继续循环比较
            }
            else
            {break;}


        }
        /*for循环结束后，我们已经以i为父节点的树的最大值，放在了顶部*/
        arr[i]=temp;//将temp放到调整后的位置

    }
}
