package store.wecloud.test.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import store.wecloud.test.config.DS;
import store.wecloud.test.service.GreenplumService;
import store.wecloud.test.service.MsqlService;

import java.util.List;
import java.util.Map;

/**
 * @Auther: zy
 * @Date: 2018/8/20 16:45
 * @Description:
 */
@Controller
public class IndexController {
    @Autowired
    private MsqlService msqlService;

    @Autowired
    private GreenplumService greenplumService;

    @RequestMapping("/mysql")
    public @ResponseBody
    String mysql(){
        List<Map<String, Object>> list = msqlService.getList();
        Gson json = new Gson();
        return json.toJson(list);
    }

    @RequestMapping("/greenplum")
    public @ResponseBody
    String greenplum(){
        List<Map<String, Object>> list = greenplumService.getList();
        Gson json = new Gson();
        return json.toJson(list);
    }
}
