package store.wecloud.test.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zy
 * @Date: 2018/8/20 19:52
 * @Description:
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "mysqlDataSource")
        @ConfigurationProperties(prefix = "mysql.datasource") // application.properteis中对应属性的前缀
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "greenplumDataSource")
    @ConfigurationProperties(prefix = "greenplum.datasource") // application.properteis中对应属性的前缀
    public DataSource greenplumDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        // 创建动态数据源
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(greenplumDataSource());
        // 配置多数据源
        Map<Object, Object> dataSourceMap = new HashMap(5);
        dataSourceMap.put("mysqlDataSource", mysqlDataSource());
        dataSourceMap.put("greenplumDataSource", greenplumDataSource());
        // 添加多数据源
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

}