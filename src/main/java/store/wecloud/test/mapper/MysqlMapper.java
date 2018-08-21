package store.wecloud.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Auther: zy
 * @Date: 2018/8/20 16:54
 * @Description:
 */
@Mapper
@Component
public interface MysqlMapper {
    @Select("select * from APP_DETAIL_TASK_PROCESS")
    List<Map<String,Object>> getList();
}
