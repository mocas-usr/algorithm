package 数据结构与算法分析.sort;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/4 20:57
 * @email: wangyuhang_mocas@163.com
 */
public class arrayQueueDemo {
    /*进行测试*/
    public static void main(String[] args) {

        /*创建一个队列*/
        arrayQueue arrayQueue=new arrayQueue(3);
        char key=' ';//接受用户输入
        Scanner sc=new Scanner(System.in);

        boolean loop=true;
        while (loop)
        {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加程序");
            System.out.println("g(get):取数据");
            System.out.println("h(head):显示头数据");
            key=sc.next().charAt(0);

            switch (key)
            {
                case 's':
                    arrayQueue.show();
                    break;
                case 'a':
                    System.out.println("输入一个数值");
                    int x=sc.nextInt();

                    arrayQueue.addQueue(x);
                    break;
                case 'g':
                    try
                    {
                        int res=arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);

                    }catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try
                    {
                        int res=arrayQueue.headQueue();
                        System.out.printf("取出的数据是%d\n",res);

                    }catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop=false;//程序退出
                    System.out.println("退出功能");
                    break;
                default:
                    break;

            }
        }
        System.out.println("程序结束");

    }

}

/*用数组模拟一个队列*/
class arrayQueue{
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//用于存放数据，模拟队列

    /*创建队列的构造器*/
    public arrayQueue(int arrmaxSize)
    {
        maxSize=arrmaxSize;
        arr=new int[maxSize];
        front=-1;//指向队列头部，分析出指向列头的前一个位置,重点
        rear=-1;//指向队列尾部，指向队列尾的数据，即是最后一个数据
    }

    /*判断队列是否是满的*/
    public boolean isFull()
    {
        return rear==maxSize-1;
    }
    /*判断队列是否为空*/
    public boolean isEmpty()
    {
        return rear==front;
    }

    /*添加数据到队列*/
    public void addQueue(int n)
    {
        /*判断队列是否满*/
        if (isFull())
        {
            System.out.println("队列已经满了，不能加入数据");
            return;
        }
        /*如果没有满*/
        rear++;//尾部后移
        arr[rear]=n;

    }

    /*获取队列数值，出队列*/
    public int getQueue()
    {

        /*判断队列是否为空*/
        if (isEmpty())
        {
            throw new RuntimeException("队列为空，不能出队列");
        }

        front++;//front后移
        return arr[front];
    }

    /*显示队列所有值*/
    public void show()
    {
        if (isEmpty())
        {
            System.out.println("队列为空。");
            return;
        }
        for (int i=0;i<arr.length;i++)
        {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);

        }
    }

    /*显示队列的头数据，不是取数据*/
    public int headQueue()
    {
        if (isEmpty())
        {
            throw new RuntimeException("队列头为空");
        }
        return arr[front+1];
    }

}
