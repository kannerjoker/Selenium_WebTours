package javaAnnotation;

import javaAnnotation.ReflectAnno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

@ReflectAnno(className="Person",methodName="speak")
public class DemoReflect_Annotation {
    public static void main(String[] args) throws Exception{
        //注意泛型,以便创建对应注解实现类对象
        Class<DemoReflect_Annotation> cla = DemoReflect_Annotation.class;   //要么一开始指定好类型,要么后面强制类型转换
        ReflectAnno anno = cla.getAnnotation(ReflectAnno.class);
//        ReflectAnno anno = DemoReflect_Annotation.class.getAnnotation(ReflectAnno.class);
        //通过注解对象调用方法,获取属性
        String className = anno.className();
        String methodName = anno.methodName();
        //反射常规操作
        Class cls = Class.forName(className);
        Object obj = cls.getConstructor().newInstance();
        Method m1 = cls.getDeclaredMethod(methodName,String.class);
        m1.invoke(obj,"lisi");


    }
}
