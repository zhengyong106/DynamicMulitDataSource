package store.wecloud.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.wecloud.test.config.DS;
import store.wecloud.test.mapper.MysqlMapper;

import java.util.List;
import java.util.Map;

/**
 * @Auther: zy
 * @Date: 2018/8/21 10:04
 * @Description:
 */
@Service
public class MsqlService {
    @Autowired
    private MysqlMapper mysqlMapper;

    @DS("mysqlDataSource")
    public List<Map<String,Object>> getList(){
        return mysqlMapper.getList();
    }
}
