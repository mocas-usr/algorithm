package 数据结构.hashTable;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/13 14:40
 * @email: wangyuhang_mocas@163.com
 */
public class hashTableDemo {
    public static void main(String[] args) {
        /*创建hashtable*/
        hashTable hashTable=new hashTable(7);

        /*写一个简单的菜单*/
        String key="";
        Scanner sc=new Scanner(System.in);

        while (true)
        {
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出系统");
            key=sc.next();
            switch (key)
            {
                case "add":
                    System.out.println("输入id");
                    int id=sc.nextInt();
                    System.out.println("输入雇员姓名");
                    String  name=sc.next();
                    /*创建雇员*/
                    emp emp=new emp(id,name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                    case "find":
                    System.out.println("请输入查找id");
                    id=sc.nextInt();
                    hashTable.findEmpById(id);
                    break;
                case "exit":
                    sc.close();

                    System.exit(0);
                default:
                    break;
            }
        }

    }

}

/*创建一个雇员*/
class emp{
    public int id;
    public String name;
    public  emp next;//默认为null
    public emp(int id,String name)
    {
        this.id=id;
        this.name=name;
    }

}
/*hash表*/
class hashTable{
    private empLinkedList[] empLinkedLists;
    private int size;//多少条链表
        /*构造器*/
    public hashTable(int size)
    {
        /*初始化*/
        this.size=size;
        empLinkedLists=new empLinkedList[size];
        /*一定要初始化链表*/
        for(int i=0;i<size;i++)
        {
            empLinkedLists[i]=new empLinkedList();
        }
    }


    /*根据输入的id，查找雇员*/
    public void findEmpById(int id)
    {
        /*使用散列函数确定哪条链表  查找*/
        int empLinkedListNo=hashFun(id);
        emp emp=empLinkedLists[empLinkedListNo].findById(id);
        if (emp!=null)
        {
            System.out.printf("找到了，在%d条链表，id=%d\n",empLinkedListNo+1,id);
        }
        else
        {
            System.out.println("没有找到该雇员信息");
        }
    }
    /*添加雇员*/
    public void add(emp emp)
    {
        /*根据员工的id，决定加入哪个链表*/
        int empLinedListNo=hashFun(emp.id);
        /*将emp添加到对应的链表中*/
        empLinkedLists[empLinedListNo].add(emp);

    }
    /*遍历所有链表*/

    public void list()
    {
        for (int i=0;i<size;i++)
        {
            empLinkedLists[i].list(i);
        }
    }
    /*编写散列函数，使用简单的取模法*/
    public int hashFun(int id)
    {
        return id%size;
    }
}


/*创建链表*/
class empLinkedList{
    /*头指针，执行第一个emp，因此我们这个链表的hea是指向第一个emp*/
    private emp head;//默认为空

    /*添加雇员到链表，假定添加雇员时 ，id是自增长的  */
    public void add(emp emp)
    {
        /*如果是添加第一个雇员*/
        if (head==null)
        {
            head=emp;
            return;
        }
        /*如果不是第一个雇员，则使用一个指针，帮助定位到最后*/
        emp curEmp=head;
        while (true)
        {
            if (curEmp.next==null)
            {
                break;
            }
            curEmp=curEmp.next;

        }
        /*退出时，将emp加入链表*/
        curEmp.next=emp;


    }
    public void list(int no)
    {
        if (head==null)
        {
            System.out.println("当前第"+(no+1)+"链表为空，");
            return;
        }
        System.out.print("当前第"+(no+1)+"链表的信息");
        emp curEmp=head;//辅助指针
        while (true)
        {
            System.out.printf("=>id=%d name=%s",curEmp.id,curEmp.name);
            System.out.println();
            if (curEmp.next==null)
            {
                break;
            }else
            {
                curEmp=curEmp.next;//后移遍历
            }

        }
    }

    public emp findById(int id)
    {
        if (head==null)
        {
            System.out.println("链表为空");
            return null;
        }
        /*辅助指针*/
        emp curEmp=head;
        while (true)
        {
            if (curEmp.id==id)
            {
                break;
            }
            if (curEmp.next==null)
            {
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;

        }
        return curEmp;

    }


}
