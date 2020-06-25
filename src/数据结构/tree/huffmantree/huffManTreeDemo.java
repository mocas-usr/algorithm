package 数据结构.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/19 20:18
 * @email: wangyuhang_mocas@163.com
 */
public class huffManTreeDemo {
    public static void main(String[] args) {
        int[] arr={13,7,8,3,29,6,1};
        Node root=  createHuffmanTree(arr);
        preOrder(root);

    }

    /*编写前序遍历*/
    public static void preOrder(Node root)
    {
        if (root!=null)
        {
            root.preOrder();
        }else
        {
            System.out.println("是空树，不能遍历");
        }
    }

    /*创建huffman树*/
    public static Node createHuffmanTree(int[] arr)
    {
        /*遍历arr数组*/
        /*将arr 的每个元素构成一个node
        * 将node放入ArrayList*/

        List<Node> nodes=new ArrayList<Node>();
        for (int value:arr)
        {
            nodes.add(new Node(value));
        }


        while(nodes.size()>1) {

            /*处理过程是循环过程*/
            /*从小到大排序*/
            Collections.sort(nodes);
            //System.out.println("node=" + nodes);

            /*取出根节点权值最小的 两颗二叉树*/
            /*取出权值最小的节点*/
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            /*构建一个新的二叉树*/
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            /*从ArrayList中删除处理过得二叉树*/
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            /*将parent加入*/
            nodes.add(parent);

            //System.out.println("第一次处理后" + nodes);
        }

        /*返回树的root节点*/
        return nodes.get(0);
    }


}

/*创建节点类*/
/*让node实现compareable接口*/
class Node implements Comparable<Node>{
    int value;//节点权值
    Node left;//指向左子节点
    Node right;//指向右子节点

    /*前序遍历*/
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null)
        {
            this.left.preOrder();
        }
        if (this.right!=null)
        {
            this.right.preOrder();
        }
    }
    public Node(int value)
    {
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        /*从小到大排序*/
        return this.value-o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
