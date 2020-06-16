package 数据结构与算法分析.tree;

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
        System.out.println("前序遍历");
        binarTree.preOrder();
        System.out.println("中序遍历");
        binarTree.infixOrder();
        System.out.println("后序遍历");
        binarTree.postOrder();


    }
}

/*定义二叉树*/
class binarTree{
    private herNode root;
    public void setRoot(herNode root)
    {
        this.root=root;

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
}
