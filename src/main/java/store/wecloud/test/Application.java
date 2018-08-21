package store.wecloud.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Auther: zy
 * @Date: 2018/8/20 16:44
 * @Description:
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan("store.wecloud.test.mapper")
public class Application {
    public static void main(String args[]){
        SpringApplication.run(Application.class, args);
    }
}
