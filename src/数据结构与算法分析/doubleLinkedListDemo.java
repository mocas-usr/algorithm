package 数据结构与算法分析;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/7 10:14
 * @email: wangyuhang_mocas@163.com
 */
public class doubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        /*进行测试，先创建节点*/
        HerNode2 hero1=new HerNode2(1,"宋江","及时雨");
        HerNode2 hero2=new HerNode2(2,"乔峰","玉麒麟");
        HerNode2 hero3=new HerNode2(3,"张三丰","豹子头");
        HerNode2 hero4=new HerNode2(4,"卢沟桥","函件");
        /*创建双向链表*/
        doubleLinkedList doubleLinkedList=new doubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        /*显示*/
        doubleLinkedList.list();
        /*修改*/
        HerNode2 newhernod=new HerNode2(4,"张无忌","多情人");
        doubleLinkedList.update(newhernod);
        System.out.println("修改后的链表");
        doubleLinkedList.list();

        /*删除*/
        doubleLinkedList.delete(3);
        System.out.println("删除后的链表");
        doubleLinkedList.list();

    }

}


class doubleLinkedList {
    /*先初始一个头节点，头结点不要动，不存放具体数据*/
    private HerNode2 head = new HerNode2(0, "", "");

    //返回头节点
    public HerNode2 getHead() {
        return head;
    }

    /*显示链表*/
    public void list() {
        /*判断是否为空*/
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }


        /*因为头节点，不能动，因此需要一个辅助变量来遍历*/
        HerNode2 temp = head.next;
        while (true) {
            /*判断链表是否到最后*/
            if (temp == null) {
                break;

            }

            /*输出节点信息*/
            System.out.println(temp);
            //将temphouyi
            temp = temp.next;


        }

    }

    /*添加节点到单向链表
     * 思路：当不考虑编号顺序时
     * 1.找到当前列表的最后节点
     * 2.将最后这个节点的next指向新的节点*/
    public void add(HerNode2 herNode) {
        /*因为head节点不能动，所以需要一个辅助遍历temp*/
        HerNode2 temp = head;

        /*遍历链表，找到最后*/
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            /*后移，*/
            temp = temp.next;


        }
        //当退出while循环时，temp就指向了链表最后最后
        //形成双向链表
        temp.next = herNode;
        herNode.pre = temp;


    }

    /*修改节点，根据no编号来修改，双向链表修改和单向一样*/
    public void update(HerNode2 newHernode) {
        /*判断是否为空*/
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        /*找到需要修改的节点
         * 定义辅助变量*/
        HerNode2 temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;//表示已经遍历结束
            }
            if (temp.no == newHernode.no)//找到
            {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        /*根据flag判断是否找到要修改的节点*/
        if (flag) {
            temp.name = newHernode.name;
            temp.nickname = newHernode.nickname;

        } else//没有找到
        {
            System.out.printf("没有找到编号为%d的节点，不能修改\n", newHernode.no);
        }


    }

    /*删除节点
     * 1.head不能动，因此需要一个辅助节点找到删除节点的前一个节点
     * 2.说明我们再比较时，是temp.next.no与需要删除的节点no比较*/
        /*  对于双向链表，可以实现自我删除
        * */
    public void delete(int no)
    {
        /*判断当前链表是否为空*/
        if (head.next==null)
        {
            System.out.println("空链表，无法删除");
            return;
        }
        HerNode2 temp=head.next;
        boolean flag=false;//是否找到删除节点
        while (true)
        {
            if (temp.next==null)//已经到链表的最后
            {break;}
            if (temp.no==no)
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
            //单向链表temp.next=temp.next.next;
            temp.pre.next=temp.next;
            /*如果是最后一个节点，会出现异常*/
            if (temp.next!=null){
                temp.next.pre=temp.pre;
            }


        }
        else
        {
            System.out.printf("没有找到要删除的节点%d",no);
        }

    }
}
/*定义hernode，每一个hernode就是一个节点*/
class HerNode2{
    public  int no;
    public String name;
    public  String nickname;
    public  HerNode2 next;//指向下一个节点
    public HerNode2 pre;
    /*构造器*/
    public HerNode2(int no,String name,String nickname)
    {
        this.name=name;
        this.no=no;
        this.nickname=nickname;

    }

    @Override
    public String toString() {
        return "HerNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
