package javaAnnotation;

import javaAnnotation.PersonM;

import java.lang.annotation.RetentionPolicy;

/**
 * 注解的注意事项:
 * 默认注解类型:@Override,@Deprecated,@SuppressWarnings
 * 一、注解返回值为以下类型:
 * 1.基本数据类型
 * 2.String
 * 3.枚举
 * 4.注解
 * 5.以上类型的数组
 * 二、注解有返回值时，使用时需给属性赋值，格式：（属性1 = 值1，属性2 = 值2）
 * 1.定义返回值类型时，使用default指定默认值后，使用时可以不赋值
 * 2.当只有一个属性（注解的方法名）且为value时，使用时可以直接指定值，格式：（值），如@SuppressWarnings("all")
 * 3.数组赋值时,使用"{值1,值2,值3}",当数组中只有一个值时,"{ }"可以省略
 * 三、元注解：用于描述注解的注解
 * 1.@Target：描述注解能够作用的位置
    *ElementType.TYPE   表示可以作用于类上
    *ElementType.METHOD 表示可以作用于方法上
    *ElementType.FIELD  表示可以作用于成员变量上
 * 2.@Retention：描述注解被保留的阶段
    *RetentionPolicy.SOURCE
    *RetentionPolicy.CLASS
    *RetentionPolicy.RUNTIME    当前注解保存到".class"文件中,可以被JVM读取到(我们定义时,一般只作用到这个阶段,不去改变编译器)
 * 3.@Documented：描述注解是否被抽取到api文档
 * 4.@Inherited：描述注解是否被子类继承
 */
public @interface MyAnnotation1 {
    //返回值为非空基本类型/其数组
    String name() default "zhangsan";
    int age();
    //返回值为枚举/其数组
    PersonM enumPerson() default PersonM.p1;
    //返回值为注解/其数组
    MyAnnotation2 anno() default @MyAnnotation2;    //default 指定默认值
    String[] arr1() default {"a","b","c"};
    String[] arr2() default "a";
    String[] arr3();
}
