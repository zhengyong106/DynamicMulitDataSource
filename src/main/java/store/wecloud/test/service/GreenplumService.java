package store.wecloud.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.wecloud.test.config.DS;
import store.wecloud.test.mapper.GreenPlumMapper;

import java.util.List;
import java.util.Map;

/**
 * @Auther: zy
 * @Date: 2018/8/21 10:04
 * @Description:
 */
@Service
public class GreenplumService {
    @Autowired
    private GreenPlumMapper greenPlumMapper;

    @DS("greenplumDataSource")
    public List<Map<String,Object>> getList(){
        return greenPlumMapper.getList();
    }
}
