package store.wecloud.test.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther: zy
 * @Date: 2018/8/21 09:43
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DS {
    String value() default "mysqlDataSource";
}