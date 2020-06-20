package 数据结构与算法分析.tree;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/17 19:48
 * @email: wangyuhang_mocas@163.com
 */
public class arrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        /*创建binarytree*/
        arrBinaryTree arrBinaryTree=new arrBinaryTree(arr);
        arrBinaryTree.preOrder(0);

    }

}

class arrBinaryTree{
    private int[]   arr;
    public arrBinaryTree(int[] arr)
    {
        this.arr=arr;
    }
    /*编写一个方法，完成顺序存储二叉树的前序遍历*/
    public void preOrder(int index)
    {
        /*如果数组为空，或者arr.length=0*/
        if (arr==null || arr.length==0)
        {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        /*输出当前这个元素*/
        System.out.println(arr[index]);
        /*向左递归*/
        if ((index*2+1)<arr.length)
        {
            preOrder(2*index+1);
        }
        /*向右递归  */
        if ((index*2+2)<arr.length)
        {
            preOrder(2*index+2);
        }
    }
}
