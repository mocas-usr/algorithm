package 数据结构.tree;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/13 19:53
 * @email: wangyuhang_mocas@163.com
 */
public class binaryTreeDemo {
    public static void main(String[] args) {
        /*先创建二叉树*/
        binarTree binarTree=new binarTree();
        /*需要创建的节点*/
        herNode root=new herNode(1,"宋江");
        herNode herNode2=new herNode(2,"吴勇");
        herNode herNode3=new herNode(3,"卢俊义");
        herNode herNode4=new herNode(4,"林冲");
        herNode herNode5=new herNode(5,"关胜");

        /*手动创建二叉树*/
        root.setLeft(herNode2);
        root.setRight(herNode3);
        herNode3.setRight(herNode4);
        herNode3.setLeft(herNode5);
        binarTree.setRoot(root);

        /*测试*/
//        System.out.println("前序遍历");
//        binarTree.preOrder();
//        System.out.println("中序遍历");
//        binarTree.infixOrder();
//        System.out.println("后序遍历");
//        binarTree.postOrder();

        /*前序遍历查找*/
//        herNode resNoder= binarTree.postOrderSearch(15);
//        if (resNoder!=null)
//        {
//            System.out.printf("找到了，信息为no=%d name=%s",resNoder.getNo(),resNoder.getName());
//        }
//        else {
//            System.out.printf("没有找到no=%d的英雄",5);
//        }

        /*中序遍历查找*/
        herNode resNoder= binarTree.infixOrderSearch(15);
        if (resNoder!=null)
        {
            System.out.printf("找到了，信息为no=%d name=%s",resNoder.getNo(),resNoder.getName());
        }
        else {
            System.out.printf("没有找到no=%d的英雄",5);
        }

        System.out.println("删除前，前序遍历");
        binarTree.preOrder();
        binarTree.delNode(5);
        System.out.println("删除后，前序遍历");
        binarTree.preOrder();


    }
}

/*定义二叉树*/
class binarTree{
    private herNode root;
    public void setRoot(herNode root)
    {
        this.root=root;

    }
    public void delNode(int no)
    {
            if (root!=null)
            {
                /*如果只有一个root节点，这里立即判断root是不是要删除的节点*/
                if (root.getNo()==no)
                {
                    root=null;
                }
                else
                {
                    //递归删除
                    root.delNode(no);
                }

            }
            else
            {
                System.out.println("空树，不能删除");
            }
    }

    /*前序遍历*/
    public void preOrder()
    {
        if (this.root!=null)
        {
            this.root.preOrder();
        }
            else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /*中序遍历*/
    public void infixOrder()
    {
        if (this.root!=null)
        {
            this.root.infixOrder();
        }
        else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    /*后序遍历*/
    public void postOrder()
    {
        if (this.root!=null)
        {
            this.root.postOrder();
        }
        else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /*前序遍历*/
    public herNode preOrderSearch(int no)
    {
        if (root!=null)
        {
            return root.preOrderSearch(no);
        }
        else
        {
            return null;
        }
    }
    /*中序遍历*/
    public herNode infixOrderSearch(int no)
    {
        if (this.root!=null)
        {
            return root.infixOrderSearch(no);
        }
        else {
            return null;
        }
    }
    /*后序遍历*/
    public herNode postOrderSearch(int no)
    {
        if (root!=null)
        {
            return root.postOrderSearch(no);
        }
        else {
            return null;
        }
    }

}

class herNode{
    private int no;
    private String name;
    private herNode left;
    private herNode right;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public herNode getLeft() {
        return left;
    }

    public void setLeft(herNode left) {
        this.left = left;
    }

    public herNode getRight() {
        return right;
    }

    public void setRight(herNode right) {
        this.right = right;
    }

    public herNode(int no, String name)
    {
        this.no=no;
        this.name=name;

    }

    @Override
    public String toString() {
        return "herNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /*递归删除节点*/
    /*1.如果是叶子节点，则删除该置为空
    * 2.如果是非叶子节点，则删除该子树*/
    public void delNode(int no)
    {
        /*判断左子节点是否是要删除的*/
        if ( this.left!=null && this.left.no==no )
        {
            this.left=null;
            return;
        }
        /*判断右节点*/
        if (this.right!=null &&this.right.no==no)
        {
            this.right=null;
            return;
        }
        /*左子树删除*/
        if (this.left!=null)
        {
            this.left.delNode(no);
        }

        if (this.right!=null)
        {
            this.right.delNode(no);
        }


    }

    /*遍历前序遍历的方法*/
    public void preOrder()
    {
        System.out.println(this);/*先输出父节点*/
        /*递归向左子树遍历*/
        if (this.left!=null)
        {
            this.left.preOrder();
        }
        /*递归向右子树遍历*/
        if (this.right!=null)
        {
            this.right.preOrder();
        }
    }

    /*中序遍历*/
    public void infixOrder()
    {
        /*递归向左子树遍历*/
        if (this.left!=null)
        {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null)
        {
            this.right.infixOrder();
        }
    }

    /*后序遍历*/
    public void postOrder()
    {
        if (this.left!=null)
        {
            this.left.postOrder();
        }
        if (this.right!=null)
        {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /*前序遍历查找*/
    public herNode preOrderSearch(int no)
    {

        /*比较当前节点是不是*/
        if (this.no==no)
        {
            return  this;
        }
        //则判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        //如果左递归前序查找，找到节点则返回
        herNode resNode=null;
        if (this.left!=null)
        {
            resNode=this.left.preOrderSearch(no);
        }

        if (resNode!=null)
        {
            return resNode;
        }

        //如果左边没找到，，当前节点的右子节点是否为空，如果不空，则向右递归
        if (this.right!=null)
        {
            resNode=this.right.preOrderSearch(no);

        }
        return resNode;


    }

    /*中序查找*/
    public herNode infixOrderSearch(int no)
    {
        /*判断左节点是否为空*/
        herNode resNode=null;
        if (this.left!=null)
        {
            resNode=this.left.infixOrderSearch(no);
        }

        if (resNode!=null)
        {return resNode;}
        if (this.no==no)
        {
            return this;
        }

        /*否则继续查找*/
        if (this.right!=null)
        {
            resNode=this.right.infixOrderSearch(no);

        }
        return resNode;
    }

    /*后序遍历查找*/
    public herNode postOrderSearch(int no)
    {
        /*判断左节点是否为空*/
        herNode resNode=null;
        if (this.left!=null)
        {
            resNode=this.left.postOrderSearch(no);

        }
        if (resNode!=null)
        {
            return resNode;

        }
        if (this.right!=null)
        {
            resNode=this.right.postOrderSearch(no);

        }
        if (resNode!=null)
        {
            return resNode;
        }

        if (this.no==no)
        {
            return this;
        }
        return resNode;
    }
}

