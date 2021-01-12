package exer;

import java.util.Scanner;

/**
 * @author 石致彬
 * @create 2021-01-03 16:31
 */
public class Test {
    public static void main(String[] args) {
        Jdbc jdbc = new Jdbc();
//        jdbc.insertData();
        Scanner scanner = new Scanner(System.in);
        boolean f = false;
        while (true) {
            System.out.println("******菜单******");
            System.out.println("***1.更新数据***");
            System.out.println("***2.查询数据***");
            System.out.println("***3.退出*******");
            System.out.println("请输入(1-3):");
            int type = scanner.nextInt();
            switch (type) {
                case 1:
                    jdbc.updateData();
                    break;
                case 2: {
                    System.out.println("1.China");
                    System.out.println("2.US");
                    System.out.println("3.United Kingdom");
                    System.out.println("4.Japan");
                    System.out.println("请输入要查询的国家(1-4)：");

                    int country = scanner.nextInt();
                    if (country == 1) {
                        jdbc.queryData("China");
                    } else if (country == 2) {
                        jdbc.queryData("US");
                    } else if (country == 3) {
                        jdbc.queryData("United Kingdom");
                    } else if (country == 4) {
                        jdbc.queryData("Japan");
                    }

                }
                break;
                case 3: {
                    System.out.println("退出成功");
                    f = true;
                }
                break;
            }
            if (f) {
                break;
            }
        }
    }
}
