package 数据结构与算法分析.sort;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/6/4 19:58
 * @email: wangyuhang_mocas@163.com
 */
public class sparseArray {
    public static void main(String[] args) {
        /*创建一个原始数组11*11*/
        //0表示无棋子，1表示黑子，2表示白子
        int chessArr1[][]=new int[11][11];//动态初始化
        chessArr1[1][2]=1;
        chessArr1[2][4]=2;
        /*输出原始的二维数组*/
        System.out.println("原始的二维数组");
        for (int[] row:chessArr1)
        {
            for (int data:row)
            {
                System.out.printf("%d\t",data);//格式化printf
            }
            System.out.println();//这个会换行
        }

        /*将二维数组转换成稀疏数组*/
        //1 先遍历二维数组，得到非0元素的个数
        int sum=0;
        for (int i=0;i<11;i++)
        {
            for (int j=0;j<11;j++)
            {
                if (chessArr1[i][j]!=0)
                {
                    sum++;
                }
            }
        }

        //2.创建对应的稀疏数组
        int sparse[][]=new int[sum+1][3];
        //给稀疏数组赋值
        sparse[0][0]=11;
        sparse[0][1]=11;
        sparse[0][2]=sum;

        //遍历二维数组，将非0数值存放到sparse
        int count=0;//用于记录第几个数
        for (int i=0;i<11;i++)
        {
            for( int j=0;j<11;j++)
            {
                if (chessArr1[i][j]!=0)
                {
                    count++;
                    sparse[count][0]=i;
                    sparse[count][1]=j;
                    sparse[count][2]=chessArr1[i][j];//将数值赋值给sparse的位置
                }
            }
        }

        /*输出稀疏数组*/
        System.out.println("得到的稀疏数组");
        for (int i=0;i<sparse.length;i++)
        {
            System.out.printf("%d\t%d\t%d\t\n",sparse[i][0],sparse[i][1],sparse[i][2]);
        }

        /*将稀疏数组恢复原始的二维数组*/
        int[][] chessArr2=new int[11][11];
        /*输出恢复的数组    */
        System.out.println("恢复后的数组");
        /*读取数组，第二行开始赋值*/
        for (int i=1;i<sparse.length;i++)//i这里是sp的行
        {
            chessArr2[sparse[i][0]][sparse[i][1]]=sparse[i][2];//即ch2的k行j列数值对应sp的[i][0]
        }

        /*输出恢复的二维数组*/
        System.out.println("恢复后的数组");
        for (int[] row:chessArr2)
        {
            for (int data:row)
            {
                System.out.printf("%d\t",data);//格式化printf
            }
            System.out.println();//这个会换行
        }



    }

}
