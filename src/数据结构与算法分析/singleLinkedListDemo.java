package 数据结构与算法分析;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/6 20:19
 * @email: wangyuhang_mocas@163.com
 */
public class singleLinkedListDemo {

    public static void main(String[] args) {

        /*进行测试，先创建节点*/
        HerNode hero1=new HerNode(1,"宋江","及时雨");
        HerNode hero2=new HerNode(2,"乔峰","玉麒麟");
        HerNode hero3=new HerNode(3,"张三丰","豹子头");
        HerNode hero4=new HerNode(4,"卢沟桥","函件");

        /*创建链表*/
        singleLinkedList singleLinkedList=new singleLinkedList();
        /*加入*/
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        singleLinkedList.addByorder(hero1);
        singleLinkedList.addByorder(hero4);
        singleLinkedList.addByorder(hero2);
        singleLinkedList.addByorder(hero3);
        singleLinkedList.list();
        /*测试修改节点的代码*/
        HerNode newhero3=new HerNode(3,"张三丰（宝宝）","~豹子头");
        singleLinkedList.update(newhero3);

        //显示
        System.out.println("修改后的情况");
        singleLinkedList.list();
        /*删除测试*/
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
        System.out.println("删除后的情况");
        singleLinkedList.list();

    }
}

/*定义singleLinkedList，管理我们的英雄*/
class singleLinkedList{

    /*先初始一个头节点，头结点不要动，不存放具体数据*/
    private HerNode head=new HerNode(0,"","");

    /*添加节点到单向链表
    * 思路：当不考虑编号顺序时
    * 1.找到当前列表的最后节点
    * 2.将最后这个节点的next指向新的节点*/
    public void add(HerNode herNode)
    {
        /*因为head节点不能动，所以需要一个辅助遍历temp*/
        HerNode temp=head;

        /*遍历链表，找到最后*/
        while (true)
        {
            //找到链表的最后
            if (temp.next==null)
            {
                break;
            }
            /*后移，*/
            temp=temp.next;


        }
        //当退出while循环时，temp就指向了链表最后最后
        //将这个next指向新的节点
        temp.next=herNode;


    }


    /*修改节点，根据no编号来修改*/
    public void update(HerNode newHernode)
    {
        /*判断是否为空*/
        if (head.next==null)
        {
            System.out.println("链表为空");
            return;
        }
        /*找到需要修改的节点
        * 定义辅助变量*/
        HerNode temp=head.next;
        boolean flag=false;//表示是否找到该节点
        while (true)
        {
            if (temp==null)
            {
                break;//表示已经遍历结束
            }
            if (temp.no==newHernode.no)//找到
            {
                flag=true;
                break;
            }
            temp=temp.next;
        }

        /*根据flag判断是否找到要修改的节点*/
        if (flag)
        {
            temp.name=newHernode.name;
            temp.nickname=newHernode.nickname;

        }
        else//没有找到
        {
            System.out.printf("没有找到编号为%d的节点，不能修改\n",newHernode.no);
        }

    }

    /*删除节点
    * 1.head不能动，因此需要一个辅助节点找到删除节点的前一个节点
    * 2.说明我们再比较时，是temp.next.no与需要删除的节点no比较*/

    public void delete(int no)
    {
        HerNode temp=head;
        boolean flag=false;//是否找到删除节点
        while (true)
        {
            if (temp.next==null)//已经到链表的最后
            {break;}
            if (temp.next.no==no)
                //找到删除节点的前一个位置
            {
                flag=true;
                break;
            }
            temp=temp.next;

        }

        if (flag)
        {
            //可以删除
            temp.next=temp.next.next;
        }
        else
        {
            System.out.printf("没有找到要删除的节点%d",no);
        }

    }
    /*插入节点*/
    public void addByorder(HerNode herNode)
    {
        /*因为头节点不动，仍然通过辅助指针来帮助找到添加位置*/
        /*因为单链表，所以temp是位于添加位置的前一个节点，否则插入不了*/

        HerNode temp=head;
        boolean flag=false;//添加的编号是否存在，默认是false
        while (true)
        {
            if (temp.next==null)//说明temp已经在链表的最后
            {
                break;
            }
            if (temp.next.no>herNode.no)//位置找到了，就在temp的后面插入
            {
                break;
            }
            else if (temp.next.no==herNode.no)//说明已经存在插入的node，插入成功
            {
                flag=true;
                break;
            }
            temp=temp.next;//后移，遍历链表，直到找到


        }

        /*如果flag是真，*/
        if (flag)
        {
            System.out.printf("待插入编号%d已经存在，不能加入",herNode.no);
        }
        else
        {
            //插入到链表中，插入temp中
            herNode.next=temp.next;
            temp.next=herNode;
        }

    }

    /*显示链表*/
    public void list()
    {
        /*判断是否为空*/
        if (head.next==null)
        {
            System.out.println("链表为空");
            return;
        }


        /*因为头节点，不能动，因此需要一个辅助变量来遍历*/
        HerNode temp=head.next;
        while (true)
        {
            /*判断链表是否到最后*/
            if (temp==null)
            {
                break;

            }

            /*输出节点信息*/
            System.out.println(temp);
            //将temphouyi
            temp=temp.next;


        }

    }


}

/*定义hernode，每一个hernode就是一个节点*/
class HerNode{
    public  int no;
    public String name;
    public  String nickname;
    public  HerNode next;//指向下一个节点
    /*构造器*/
    public HerNode(int no,String name,String nickname)
    {
        this.name=name;
        this.no=no;
        this.nickname=nickname;

    }

    @Override
    public String toString() {
        return "HerNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +

                '}';
    }





}
