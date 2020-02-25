package homework.listmap;

import java.util.*;

/**
 * 作者：北京动力节点老崔
 */
public class Test {
    public static void main(String[] args) {
        //1)定义List集合，存储Map<String,String>
        List< Map<String,String> > list = new ArrayList<>();

        //2)向list集合中添加元素
        Map<String,String> map = new HashMap<>();       //先定义map
        //向map中添加数据
        map.put("date", "今天（周三）");
        map.put("weather", "多云");
        map.put("wind", "微风");
        map.put("temperature", "23℃");
        list.add(map);              //把map添加到list集合中

        map = new HashMap<>();       //先定义map
        //向map中添加数据
        map.put("date", "明天（周四）");
        map.put("weather", "雷阵雨转中雨");
        map.put("wind", "微风");
        map.put("temperature", "29～22℃");
        list.add(map);              //把map添加到list集合中

        map = new HashMap<>();       //先定义map
        //向map中添加数据
        map.put("date", "后天（周五）");
        map.put("weather", "阴转多云");
        map.put("wind", "微风");
        map.put("temperature", "31～23℃");
        list.add(map);              //把map添加到list集合中

        map = new HashMap<>();       //先定义map
        //向map中添加数据
        map.put("date", "大后天（周六）");
        map.put("weather", "多云");
        map.put("wind", "微风");
        map.put("temperature", "31～24℃");
        list.add(map);              //把map添加到list集合中

        System.out.println(list);

        //再把List集合中的数据生成指定格式的字符串
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        //遍历list集合的每个元素, list中存储的是Map
        for( int i  = 0 ; i < list.size(); i++) {
            //返回指定位置 的元素
            Map<String, String> tmpMap = list.get(i);
            //把tmpMap中的数据连接到sb字符串中,
            sb.append("\t{\n");
            Set<Map.Entry<String, String>> entrySet = tmpMap.entrySet();
            int count = 0;      //记录遍历map键值对的数量
            for( Map.Entry<String,String> entry : entrySet){
                sb.append("\t\t" + entry.getKey() + " : " + entry.getValue() );
                count++;        //计数器加1
                if ( count < entrySet.size()){
                    sb.append(",");
                }
                sb.append("\n");
            }
            sb.append("\t}");
            //map之间,添加逗号, 即如果不是最后一个map就添加逗号
            if (i < list.size() - 1 ){
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append("]\n");
        System.out.println(sb);

    }
}
