package javaAnnotation.testAnnotation;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCalculator {
    public static void main(String[] args){
        Calculator calculator = new Calculator();
        Class<Calculator> cal = Calculator.class;
        Check check = cal.getAnnotation(Check.class);

        String src = "D:\\IdeaProjects\\Selenium_WebTours\\src\\main\\javaAnnotation\\testAnnotation\\bug.txt";
        String errS = null;
        FileWriter fw = null;
        int count = 0;
        try {
            fw = new FileWriter(src,true);

            for (Method method : cal.getDeclaredMethods()) {
                //method.isAnnotationPresent(Class<? extends Annotation> annotationClass)判断当前方法名上的注解中是否包含指定注解
                /*通过字符串判断是否包含指定注解
                String str = String.valueOf(method.getAnnotation(Check.class));
                if(str != "null"){
                    System.out.println(str.split("\\.")[1].equals("Check()"));
                }
                */
                if(method.isAnnotationPresent(Check.class)){
                    try {
                        method.invoke(calculator);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
//                e.printStackTrace();
                        count++;
                        //method.getName() 获取方法名称
                        fw.write(method.getName() + "方法出现异常!\r\n");
                        //e.getCause().getClass().getSimpleName() 获取错误名称
                        fw.write("错误名称:" + e.getCause().getClass().getSimpleName() + "\r\n");
                        //e.getCause().getMessage() 获取出错原因
                        fw.write("出错的原因:" + e.getCause().getMessage() + "\r\n");
                        fw.write("--------------------------------" + "\r\n");
                    }
                }

            }
            fw.write("一共出现了" + count + "个bug!\r\n");
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
