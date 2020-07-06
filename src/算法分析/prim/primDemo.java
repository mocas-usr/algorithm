package 算法分析.prim;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/7/6 19:48
 * @email: wangyuhang_mocas@163.com
 */
public class primDemo {
    public static void main(String[] args) {
        //测试
        char[] data=new char[]{'A','B','C','D','E','F','G'};
        int verxs=data.length;

        int [][] weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9, 10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000, 6},
                {2,3,10000,10000,4,6,10000}
        };
        //创建mgraph对象
        mGraph graph=new mGraph(verxs);
        minTree minTree=new minTree();
        minTree.createGraph(graph,verxs,data,weight );
        //输出
        minTree.showGraph(graph);
        minTree.prim(graph,0);


    }


}
class minTree {
    //创建图的邻接矩阵
    public void createGraph(mGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];

            }
        }
    }

    public void showGraph(mGraph graph)
    {
        for (int[] link:graph.weight)
        {
            System.out.println(Arrays.toString(link));
        }

    }

    //编写prim算法，得到最小生成树
    public void prim(mGraph graph,int v)
    {
        int[] visited=new int[graph.verx];
        //visited默认是0
        for (int i=0;i<graph.verx;i++)
        {
            visited[i]=0;
        }
        visited[v]=1;
        //用h1和h2记录两个顶点的下标
        int h1=-1;
        int h2=-1;
        int minWeight=10000;//现将minweight初始化成一个大数，后面遍历的过程会被替换
        for (int k=1;k<graph.verx;k++)//因为有graph.verts顶点，
        {
            //确定每一次生成子图和哪个节点的距离最近
            for (int i=0;i<graph.verx;i++)//i表示被访问的节点
                for(int j=0;j<graph.verx;j++)//j节点表示还没有被访问的节点
                {
                    if (visited[i]==1 &&visited[j]==0&&graph.weight[i][j]<minWeight)
                    {
                        //替换minWeight
                        minWeight=graph.weight[i][j];
                        h1=i;
                        h2=j;


                    }
                }

            System.out.println("边"+graph.data[h1]+","+graph.data[h2]+"权值："+minWeight);
                //将这个最短距离点标记访问
            visited[h2]=1;
            //minweight重置为最大值
            minWeight=10000;


        }


    }

}
class mGraph
{

    int verx;//表示图节点的个数
    char[] data;//存放节点数据
    int[][] weight;//存放边，就是我们的邻接矩阵

    public mGraph(int verxs)
    {
        this.verx=verxs;
        data=new char[verx];
        weight=new int[verxs][verxs];
    }
}
