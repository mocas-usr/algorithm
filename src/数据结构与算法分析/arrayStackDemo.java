package 数据结构与算法分析;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/7 16:18
 * @email: wangyuhang_mocas@163.com
 */
public class arrayStackDemo {
    public static void main(String[] args) {

        /*测试*/
        System.out.println("测试");
        /*创建一个arraystack*/
        arrayStack stack=new arrayStack(4);
        String key="";
        boolean loop=true;
        Scanner scanner=new Scanner(System.in);
        while (loop) {
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示添加数据到栈，入栈");
            System.out.println("pop:表示取栈");
            System.out.println("请输入你的选择");

            key = scanner.next();
            switch (key)
            {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int val=scanner.nextInt();
                    stack.push(val);
                    break;
                case "pop":
                    try
                    {
                        int res=stack.pop();
                        System.out.println("取出的数据是"+res);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

/*表示栈*/
class  arrayStack
{
    private int maxSize;//栈的大小
    private int[] stack;//数组，数组模拟栈，数据就应该放在该数组
    private int top=-1;//top表示栈顶，初始化为-1
    /*构造器*/
    public arrayStack(int maxSize)
    {
        this.maxSize=maxSize;
        stack=new int[this.maxSize];
    }

    /*栈满*/
    public boolean isFull()
    {
        return top==maxSize-1;

    }
    /*栈空*/
    public boolean isEmpty()
    {
        return top==-1;
    }

    /*入栈操作*/
    public void push(int val)
    {
        /*先判断是否满*/
        if (isFull())
        {
            System.out.println("栈满了");
            return;
        }
        top++;
        stack[top]=val;
    }

    /*出栈pop，将栈顶的数据返回*/
    public int pop(){
        /*先判断栈是否为空*/
        if (isEmpty())
        {
            throw new RuntimeException("栈空，没有数据");

        }

        int val=stack[top];
        top--;
        return val;
    }

    /*遍历栈*/
    public void list()
    {
        /*遍历时，要从栈顶开始显示数据*/
        if (isEmpty())
        {
            System.out.println("栈空，没有数据");
            return;
        }
        /*从栈顶开始走*/
        for (int i=top;i>=0;i--)
        {
            System.out.printf("取出的数据是stack[%d]=%d\n",i,stack[i]);
        }
    }
}
