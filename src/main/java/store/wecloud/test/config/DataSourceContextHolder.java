package store.wecloud.test.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther: zy
 * @Date: 2018/8/20 20:38
 * @Description:
 */
public class DataSourceContextHolder {
    public static final Logger logger = LoggerFactory.getLogger(DataSourceContextHolder.class);

    public static final String DEFAULT_DS = "mysqlDataSource";

    private static final ThreadLocal<String> contextHolder = new ThreadLocal();

    // 设置数据源名
    public static void setDB(String dbType) {
        logger.info("切换到{}数据源", dbType);
        contextHolder.set(dbType);
    }

    // 获取数据源名
    public static String getDB() {
        return (contextHolder.get());
    }

    // 清除数据源名
    public static void clearDB() {
        contextHolder.remove();
    }
}