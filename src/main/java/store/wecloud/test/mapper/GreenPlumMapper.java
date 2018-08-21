package store.wecloud.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Auther: zy
 * @Date: 2018/8/20 19:28
 * @Description:
 */
@Mapper
@Component
public interface GreenPlumMapper {
    @Select("select * from DIC_DIM_VALUE_DEF_20080")
    List<Map<String,Object>> getList();
}
