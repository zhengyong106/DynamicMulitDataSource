package store.wecloud.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Auther: zy
 * @Date: 2018/8/20 20:40
 * @Description:
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("数据源为{}", DataSourceContextHolder.getDB());
        return DataSourceContextHolder.getDB();
    }

}