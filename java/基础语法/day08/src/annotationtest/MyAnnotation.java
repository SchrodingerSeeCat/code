package annotationtest;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    String value() default "hello";
}

