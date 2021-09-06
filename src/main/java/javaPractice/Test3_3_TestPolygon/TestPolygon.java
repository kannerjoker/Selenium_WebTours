package javaPractice.Test3_3_TestPolygon;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*3.3选择一个形状（1长方形、2正方形、3三角形、4圆形）
        根据不同的选择让用户输入不同的信息，
        长方形有长和宽、
        正方形有边长、
        三角形有底和高、
        圆形有半径，
        计算输出指定形状的面积*/
public class TestPolygon {
    double area;
    String s;

    public void getPolArea() {
        TestPolygon tp = new TestPolygon();
        double area = tp.theArea();
        //正常面积>0，异常情况下面积被赋值为-0.1
        if(area < 0){
            return;
        }else{
            System.out.println("面积是：" + String.format("%.2f",area));
        }
    }

    public double check(String matcher,String pattern){
        Pattern pa = Pattern.compile(pattern);
        Matcher ma = pa.matcher(matcher);
        if(!ma.find()){
            System.out.println("您输入的参数有误，请检查后重新输入！");
            return -0.1d;
        }else{
            return Double.valueOf(matcher);
        }
    }

    public double theArea(){
        TestPolygon tp = new TestPolygon();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入多边形类型，请参照\"1长方形、2正方形、3三角形、4圆形\"：");
        s = sc.next();
        switch(s){
            case "1长方形":
                double length;
                double widthR;
                System.out.println("请输入长方形的长：");
                String l1_1 = sc.next();
                System.out.println("请输入长方形的宽：");
                String w1_2 = sc.next();
                //判断是否匹配到小数
                double num1_1 = tp.check(l1_1,"^\\d+(.\\d+)?$");
                double num1_2 = tp.check(w1_2,"^\\d+(.\\d+)?$");
                if (num1_1 != -0.1 && num1_2 != -0.1) {       //匹配到小数，正常赋值
                    length = num1_1;
                    widthR = num1_2;
                } else {      //未匹配到小数，让长宽为-0.1
                    length = -0.1;
                    widthR = -0.1;
                }
                return tp.rectangle(length,widthR);

            case "2正方形":
                double widthS;
                System.out.println("请输入正方形的边长：");
                String w2 = sc.next();
                double num2 = tp.check(w2,"^\\d+(.\\d+)?$");
                if(num2 != -0.1){
                    widthS = num2;
                }else{
                    widthS = -0.1;
                }
                return tp.square(widthS);
            case "3三角形":
                double widthT;
                double height;
                System.out.println("请输入三角形的底长：");
                String w3 = sc.next();
                System.out.println("请输入三角形的高长：");
                String h3 = sc.next();
                double num3_1 = tp.check(w3,"^\\d+(.\\d+)?$");
                double num3_2 = tp.check(h3,"^\\d+(.\\d+)?$");
                if(num3_1 != -0.1 && num3_2 != -0.1){
                    widthT = num3_1;
                    height = num3_2;
                }else{
                    widthT = -0.1;
                    height = -0.1;
                }
                return tp.triangle(widthT,height);
            case "4圆形":
                double r;
                System.out.println("请输入圆的半径：");
                String r4 = sc.next();
                double num4 = tp.check(r4,"^\\d+(.\\d+)?$");
                if(num4 != -0.1){
                    r = num4;
                }else{
                    r = -0.1;
                }
                return tp.circle(r);
            default:
                System.out.println("您输入的多边形类型有误，请参照\"1长方形、2正方形、3三角形、4圆形\"");
                return -0.1d;
        }

    }
    public double rectangle(double length,double width){
        if(length >=0 && width >= 0){
            area = length * width;
            return area;
        }else{
            area = -0.1;
            return area;
        }
    }
    public double square(double width){
        if(width >= 0){
            area = Math.pow(width,2);
        }else{
            area = -0.1;
        }
        return area;

    }
    public double triangle(double width,double height){
        if(width >= 0 && height >=0){
            area = 0.5 * width * height;
        }else{
            area = -0.1;
        }

        return area;
    }
    public double circle(double radius){
        if(radius >= 0){
            area = 0.5 * Math.PI * Math.pow(radius,2);
        }else{
            area = -0.1;
        }
        return area;
    }
}
