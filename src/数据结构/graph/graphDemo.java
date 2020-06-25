package 数据结构.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/25 9:15
 * @email: wangyuhang_mocas@163.com
 */
public class graphDemo {
    private ArrayList<String> vertList;//存储顶点集合
    private int[][] edges;//存储图相应的邻接矩阵
    private int numOfEdges;//存储边的数目
    //定义数组，来标记节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        /*测试图是否创建成功*/
        int n=5;//节点的个数
        String vertexs[]= {"A","B","C","D","E"};
        /*创建图对象*/
        graphDemo graph=new graphDemo(n);
        /*循环添加顶点*/
        for (String vertex:vertexs)
        {
            graph.insertVertex(vertex);
        }
        /*添加边*/
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        /*显示*/
        graph.showGraph();
        //graph.dfs();
        /*广度优先*/
        System.out.println("广度优先");
        graph.bfs();

    }

    /*构造器*/
    public graphDemo(int n)
    {
        /*初始化矩阵*/
        edges=new int[n][n];
        vertList=new ArrayList<String>(n);
        numOfEdges=0;
        isVisited=new boolean[5];
    }
    /*构造第一个邻接节点的下标
    * 如果存在就返回对应下标，否则返回-1*/
    public int getFirstNeighbor(int index)
    {
        for (int j=0;j<vertList.size();j++)
        {
            if (edges[index][j]>0)
            {
                return j;
            }
        }
        return -1;
    }
    /*根据下一个邻接节点的下标来获取下一个邻接节点*/
    public int getNextNeighbor(int v1,int v2)
    {
        for (int j=v2+1;j<vertList.size();j++)
        {
            if (edges[v1][j]>0)
            {
                return j;
            }
        }
        return -1;
    }
    /*深度优先遍历算法*/
    public void dfs(boolean[] isVisited,int i)
    {
            /*首先访问该节点*/
        System.out.print(getValueByIndex(i)+"->");
        /*将节点设置为已经访问*/
        isVisited[i]=true;
        /*获取i的第一个节点w*/
        int w=getFirstNeighbor(i);
        while (w!=-1)//说明有w节点
        {
            if (!isVisited[w])//如果没被访问
            {
                dfs(isVisited,w);
            }
            //如果w已经被访问过
            w=getNextNeighbor(i,w);
        }
    }

    /*对dfs重载，遍历所有节点并进行dfs*/
    public void dfs(){
        isVisited=new boolean[5];
        /*遍历所有dfs*/
        for (int i=0;i<getNumofVertex();i++)
        {
            if (!isVisited[i])
            {
                dfs(isVisited,i);
            }
        }
    }

    /*进行广度优先的方法遍历*/
    public void bfs(boolean[] isVisited,int i)
    {
        int u;  //表示队列的头节点对应的下标
        int w;//邻接节点w
        //队列，节点访问的顺序
        LinkedList queue=new LinkedList();
        //访问节点
        System.out.print(getValueByIndex(i)+"=>");
        /*标记为已访问*/
        isVisited[i]=true;
        //将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty())
        {
                /*取出队列的头节点下标*/
            u=(Integer) queue.removeFirst();
            /*得到第一个邻接点的下标w*/
            w=getFirstNeighbor(u);

            while (w!=-1)//找到，是否访问过
            {
                //是否访问过
                if (!isVisited[w])
                {
                    System.out.print(getValueByIndex(w)+"=>");
                    //标记已经访问的
                    isVisited[w]=true;
                    queue.addLast(w);

                }
                //以u为前驱节点，找w后面的下一个邻接点
                w=getNextNeighbor(u,w);//体现出广度优先
            }
        }


    }
    /*遍历所有节点都要进行广度优先搜索*/
    public void bfs()
    {
        isVisited=new boolean[5];
        for (int i=0;i<getNumofVertex();i++)
            if (!isVisited[i])
            {
                bfs(isVisited,i);
            }
    }

    /*返回节点的个数*/
    public int getNumofVertex()
    {
        return vertList.size();
    }
    /*得到边的数目*/
    public  int getNumOfEdges()
    {
        return numOfEdges;
    }
    /*显示图对应的矩阵*/
    public void showGraph()
    {
        for (int[] link:edges)
        {
            System.out.println(Arrays.toString(link));
        }
    }
    /*返回节点i对应的数据，*/
    public String getValueByIndex(int i)
    {
        return vertList.get(i);
    }
    /*返回v1 v2的权值*/
    public int getWeight(int v1,int v2)
    {
        return edges[v1][v2];
    }
    /*插入节点  */
    public void insertVertex(String vertex)
    {
        vertList.add(vertex);

    }
    /*添加边
    * v1表示点的下标
    * 即第几个顶点*/
    public void insertEdge(int v1,int v2,int weight)
    {
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }


}
