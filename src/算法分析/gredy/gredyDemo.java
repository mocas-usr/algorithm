package 算法分析.gredy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/7/5 15:15
 * @email: wangyuhang_mocas@163.com
 */
public class gredyDemo {

    public static void main(String[] args) {
        //创建电台，放入map
        HashMap<String, HashSet<String>> broadcasts=new HashMap<String, HashSet<String>>();
        HashSet<String> hashSet1=new HashSet<String >();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2=new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3=new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4=new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5=new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入map
        broadcasts.put("k1",hashSet1);
        broadcasts.put("k2",hashSet2);
        broadcasts.put("k3",hashSet3);
        broadcasts.put("k4",hashSet4);
        broadcasts.put("k5",hashSet5);

        HashSet<String> allAreas=new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("深圳");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //存放选择的电台集合
        ArrayList<String>  selects=new ArrayList<String>();
        //定义临时集合，在遍历过程中，存放遍历过程中，电台覆盖和没有覆盖的交集
        HashSet<String> tempSet=new HashSet<String>();

        //定义给maxkey，保存一次遍历过程，能够覆盖的最大未覆盖的地区对应的电台key
        //如果maxkey不为null，则会加入selects
        String maxKey=null;
        while(allAreas.size()!=0)
        {
            //每一次进行清空，要将
            maxKey=null;
                //遍历broadcast
            for (String key:broadcasts.keySet())
            {
                //
                tempSet.clear();
                //当前key能够覆盖的地区
                HashSet<String> areas=broadcasts.get(key);
                tempSet.addAll(areas);
                //求tempSet和allAreas的交集
                tempSet.retainAll(allAreas);
                //如果当前的这个集合包括未覆盖地区的数量。比maxKey指向的集合地区还多
                if (tempSet.size()>0 && (maxKey==null || tempSet.size()>broadcasts.get(maxKey).size()))
                {
                        maxKey=key;
                }

            }
            //maxkey!=null
            if (maxKey!=null)
            {
                selects.add(maxKey);
                //将maxkey指向的广播电台覆盖的地区，从allAreas去掉
                allAreas.removeAll(broadcasts.get(maxKey));

            }
        }

        System.out.println("得到的选择结果"+selects);

    }


}
