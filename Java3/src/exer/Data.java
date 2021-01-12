package exer;

import bean.All;
import bean.Province;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 石致彬
 * @create 2020-12-28 21:36
 */
public class Data {
    private  ArrayList<All> list1 = new ArrayList<>();
    private  ArrayList<Province> list2 = new ArrayList<>();

    public Data() {
    }

    public  void get() {
        String str1 = GetData.getData("China");
        String str2 = GetData.getData("US");
        String str3 = GetData.getData("United%20Kingdom");
        String str4 = GetData.getData("Japan");
        JSONObject jsonObject = JSON.parseObject(str1);
        ArrayList<String> allKey = GetData.getAllKey(jsonObject);
        Iterator<String> iterator = allKey.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("All")) {
                All all = JSON.parseObject(jsonObject.get(next).toString(), All.class);
                list1.add(all);
            } else {
                Province province = JSON.parseObject(jsonObject.get(next).toString(), Province.class);
                province.setName(next);
                province.setCountry("China");
                list2.add(province);
            }
        }
        JSONObject jsonObject2 = JSON.parseObject(str2);
        ArrayList<String> allKey2 = GetData.getAllKey(jsonObject2);
        Iterator<String> iterator2 = allKey2.iterator();
        while (iterator2.hasNext()) {
            String next = iterator2.next();
            if (next.equals("All")) {
                All all = JSON.parseObject(jsonObject2.get(next).toString(), All.class);
                list1.add(all);
            } else {
                Province province = JSON.parseObject(jsonObject2.get(next).toString(), Province.class);
                province.setName(next);
                province.setCountry("US");
                list2.add(province);
            }
        }
        JSONObject jsonObject3 = JSON.parseObject(str3);
        ArrayList<String> allKey3 = GetData.getAllKey(jsonObject3);
        Iterator<String> iterator3 = allKey3.iterator();
        while (iterator3.hasNext()) {
            String next = iterator3.next();
            if (next.equals("All")) {
                All all = JSON.parseObject(jsonObject3.get(next).toString(), All.class);
                list1.add(all);
            } else {
                Province province = JSON.parseObject(jsonObject3.get(next).toString(), Province.class);
                province.setName(next);
                province.setCountry("United Kingdom");
                list2.add(province);
            }
        }
        JSONObject jsonObject4 = JSON.parseObject(str4);
        ArrayList<String> allKey4 = GetData.getAllKey(jsonObject4);
        Iterator<String> iterator4 = allKey4.iterator();
        while (iterator4.hasNext()) {
            String next = iterator4.next();
            if (next.equals("All")) {
                All all = JSON.parseObject(jsonObject4.get(next).toString(), All.class);
                list1.add(all);
            } else {
                Province province = JSON.parseObject(jsonObject4.get(next).toString(), Province.class);
                province.setName(next);
                province.setCountry("Japan");
                list2.add(province);
            }
        }
    }

    public  ArrayList<All> getList1() {
        return list1;
    }

    public  ArrayList<Province> getList2() {
        return list2;
    }

}
