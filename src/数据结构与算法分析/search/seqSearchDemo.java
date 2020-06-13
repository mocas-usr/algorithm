package 数据结构与算法分析.search;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/13 9:02
 * @email: wangyuhang_mocas@163.com
 */
public class seqSearchDemo {
    public static void main(String[] args) {
        int[] arr={1,9,12,2,3,6};
        int index= seqSearch(arr,2);
        if (index==-1)
        {
            System.out.println("没有找到");
        }
        else
        {
            System.out.println("找到，下标是"+index);
        }

    }

    public static int seqSearch(int[] arr,int value){
        /*线性查找是逐一比对，发现有相同的值 。就返回下标*/
        for (int i=0;i<arr.length;i++)
        {
            if (arr[i]==value)
            {
                return i;
            }
        }
        return -1;

    }
}
