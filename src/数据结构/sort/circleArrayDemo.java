package 数据结构.sort;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/5 20:32
 * @email: wangyuhang_mocas@163.com
 */
public class circleArrayDemo {

    public static void main(String[] args) {
        /*测试*/
        System.out.println("测试环形队列");
        /*创建一个队列*/
        circleArray arrayQueue=new circleArray(4);//有效数据最大为3
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

class circleArray{
    private int maxSize;//表示数组的最大容量
    /*front变量有调整，front指向队列的第一个元素，也就是arr[front]是第一个元素*/
    private int front;//队列头
    /*rear变量指向队列最后一个元素的后一个位置，*/
    private int rear;//队列尾
    private int[] arr;//用于存放数据，模拟队列

    public circleArray(int arrmaxSize)
    {
        maxSize=arrmaxSize;
        arr=new int[maxSize];
        front=0;//
        rear=0;//
    }

    /*判断队列是否满*/
    public boolean isFull()
    {
        return (rear+1)%maxSize==front;
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

        /*直接将数据加入*/
        arr[rear]=n;
        /*将rear后移*/
        rear=(rear+1)%maxSize;

    }

    /*获取队列数值，出队列*/
    public int getQueue()
    {

        /*判断队列是否为空*/
        if (isEmpty())
        {
            throw new RuntimeException("队列为空，不能出队列");
        }

        /*这里front是指向队列的第一个元素    */
        /*1.先把front值保存到一个临时变量
        * 2.将front后移，考虑取模
        * 3.将临时变量返回*/
        int val=arr[front];
        front=(front+1)%maxSize;
        return val;
    }
    /*显示队列所有值*/
    public void show()
    {
        if (isEmpty())
        {
            System.out.println("队列为空。");
            return;
        }

        /*从front遍历，遍历多少个元素  */
        for (int i=front;i<front+size();i++)
        {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);

        }
    }

    /*求出当前队列有效的个数*/
    public int size()
    {
        return (rear+maxSize-front)%maxSize;
    }
    /*显示队列的头数据，不是取数据*/
    public int headQueue()
    {
        if (isEmpty())
        {
            throw new RuntimeException("队列头为空");
        }
        return arr[front];
    }
}