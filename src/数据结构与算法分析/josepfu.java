package 数据结构与算法分析;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/7 14:51
 * @email: wangyuhang_mocas@163.com
 */
public class josepfu {
    public static void main(String[] args) {
            /*测试*/
        circleSingleLinkedList circleSingleLinkedList=new circleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);//加入五个小孩
        circleSingleLinkedList.showBoy();

        /*测试小孩出圈是否正确*/
        /*出圈顺序2 4 1 5 3
        * n=5，表示5个人
        * k=1，表示从第一个人数
        * m=2，数两下
        * */
        circleSingleLinkedList.countBoy(1,2,5);

    }

}


/*创建环形的单向链表*/
class circleSingleLinkedList{
/*创建第一个first节点，当前没有编号*/
    private boy first=null;
        /*添加小孩节点，构建一个 环形链表*/
    public void addBoy(int nums)
    {
        /*做一个数据校验*/
        if (nums<1)
        {
            System.out.println("num的值不正确");
            return;
        }
        boy curboy=null;
        /*使用for来创建我们的环形链表*/
        for (int i=1;i<=nums;i++)
        {
            //根据编号，创建小孩节点
            boy boy=new boy(i);
            /*考虑第一个小孩*/
            if (i==1)
            {
                first=boy;
                first.setNext(first);//构成环
                curboy=first;// 让curboy指向第一个小孩

            }else
            {
                curboy.setNext(boy);
                boy.setNext(first);
                curboy=boy;
            }
        }
    }

    /*遍历当前的环形链表*/
    public void showBoy()
    {
        /*判断是否为空*/
        if (first==null)
        {
            System.out.println("链表为 空");

        }

        /*因为first不能动，还是用辅助指针*/
        boy curboy=first;
        while (true)
        {
            System.out.printf("小孩的编号%d\n",curboy.getNo());
            if (curboy.getNext()==first)//说明已经遍历结束
            {
                break;
            }
            curboy=curboy.getNext();//curboy后移
        }
    }

    /*根据用户的输入，计算小孩出圈的数据
    * startNo表示从第几个小孩数数
    *countNum 表示数几下
    * nums表示最初多少个小孩在圈中*/
    public void countBoy(int startNo,int countNum,int nums)
    {
        if (first==null || startNo<1 ||startNo>nums)
        {
            System.out.println("参数输入有误，重新输入");
            return;
        }
        /*创建辅助指针，帮助小孩出圈*/
        boy helper=first;
        //创建一个需要，helper应该事先指向链表最后的节点
        while (true)
        {
            if (helper.getNext()==first)
            {break;}
            helper=helper.getNext();

        }
        /*先让小孩报数前，让first和helper移动k-1次*/
        for (int j=0;j<startNo-1;j++)
        {
            first=first.getNext();
            helper=helper.getNext();

        }
        /*让小孩报数时，让first和helper移动m-1次，然后出圈
        * 这里是一个循环操作，直到圈中只有一个人
        * */
        while (true)
        {
            if (helper==first)//圈中只有一个节点
            {
                break;
            }
            /*让first和helper都移动m-1*/
            for (int j=0;j<countNum-1;j++)
            {
                first=first.getNext();
                helper=helper.getNext();

            }
            /*这时first指向的节点，就是小孩要出圈的小孩节点*/
            System.out.printf("这时小孩%d出圈\n",first.getNo());
            /*这时将first指向的小孩出圈*/
            first=first.getNext();
            helper.setNext(first);

        }
        System.out.printf("最后留在圈中的小孩的编号%d",helper.getNo());

    }


}
/*  创建一个boy，表示一个节点*/
class boy{
    private int no;//编号
    private boy next;
    public boy(int no)
    {
        this.no=no;

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public boy getNext() {
        return next;
    }

    public void setNext(boy next) {
        this.next = next;
    }
}