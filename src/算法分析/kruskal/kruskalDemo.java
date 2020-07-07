package 算法分析.kruskal;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/7/7 19:55
 * @email: wangyuhang_mocas@163.com
 */
public class kruskalDemo {
    private int edgeNum;//边的个数
    private char[] vertexs;//顶点数组
    private int[][] matrix;//邻接矩阵
    //使用INF表示两个顶点不能联通
    private static final int INF=Integer.MAX_VALUE;

    public static void main(String[] args) {

    }


    //构造器
    public kruskalDemo(char[] vertexs,int[][] matrix)
    {
        //初始化顶点数和边的个数
        int vlen=vertexs.length;

        //初始化顶点
        this.vertexs=new char[vlen];
    }
}
