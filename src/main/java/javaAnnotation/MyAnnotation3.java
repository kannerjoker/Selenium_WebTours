package javaAnnotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})    //可以在类、方法、变量前添加注解
@Retention(value = RetentionPolicy.RUNTIME)     //可以被保留到运行期
@Documented         //注解可以被输出到api文档
@Inherited          //注解可以被子类继承
public @interface MyAnnotation3 {
}
