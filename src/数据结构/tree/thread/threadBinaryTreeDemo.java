package 数据结构.tree.thread;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/17 20:43
 * @email: wangyuhang_mocas@163.com
 */
public class threadBinaryTreeDemo {
    public static void main(String[] args) {

        /*测试下中序二叉树的功能*/
        herNode root=new herNode(1,"tom");
        herNode node2=new herNode(3,"jack");
        herNode node3=new herNode(6,"smith");
        herNode node4=new herNode(8,"mary");
        herNode node5=new herNode(10,"king");
        herNode node6=new herNode(14,"dim");

        /*后面要递归创建*/
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        /*线索化*/
        threadbinarTree threadbinarTree=new threadbinarTree();
        threadbinarTree.setRoot(root);
        threadbinarTree.threadNodes();

        /*测试*/
        herNode leftNode=node5.getLeft();
        herNode rightNode=node5.getRight();
        System.out.println("10号节点的前驱节点是="+leftNode);
        System.out.println("10号节点的后继节点是="+rightNode);


    }



}
/*创建节点*/
class herNode{
    private int no;
    private String name;
    private herNode left;
    private herNode right;


    /*说明。如果leftType=0,则指向左子树，如果是1表示指向前驱节点
    * 2.同理right*/

    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

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

/*定义二叉树*/
class threadbinarTree{
    private herNode root;
    /*为了线索化，需要创建要给当前指向当前节点的前驱节点的指针，
    * 2为递归进行线索化时，pre总是保留一个节点*/
    private herNode pre=null;

    /*重载一把threadbinarytree*/
    public  void  threadNodes()
    {
        this.threadNodes(root);
    }
    /*编写二叉树进行中序线索化的方法，*/
    public void threadNodes(herNode node)
    {
        /*如果node==null*/
        if (node==null)
        {
            return;
        }
        ///*1.先线索化左子树，
        threadNodes(node.getLeft());
        //* 2.线索化当前节点
        //处理当前节点的前驱节点
        if (node.getLeft()==null)
        {
            //让当前节点的做指针指向前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }
        /*处理后继节点*/
        if (pre!=null && pre.getRight()==null)
        {
            /*让前驱节点的右指针指向当前节点*/
            pre.setRight(node);
            /*修改前驱节点的右指针类型*/
            pre.setRightType(1);
        }
       // * 3.线索化右子树*/

        /*每处理一个节点，让当前节点是下一个节点的前驱节点*/
        pre=node;




    }

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
