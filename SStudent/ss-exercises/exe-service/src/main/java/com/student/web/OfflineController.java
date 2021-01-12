package com.student.web;

import com.student.common.downUtil.CreateWord;
import com.student.pojo.Choice;
import com.student.service.ChoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 离线任务
 */
@Controller
@RequestMapping("/Offline")
public class OfflineController {

    @Resource
    private ChoiceService choiceService;

    /**
     * 下载word选择题
     */
    @GetMapping("getTestPaper")
    @ResponseBody
    public void getTestPaper(){
        try {
            //封装数据
            List<Choice> choices = choiceService.getChoices();
            Map<Object, Object> map = new HashMap<>();
            map.put("Choices",choices);
            //设置模板名称
            String templateName="download/demo.ftl";
            //文件输出路径
            String filePath="D:\\此电脑\\桌面\\TestPaper";
            //输出文件名
            String l = String.valueOf(System.currentTimeMillis()/1000);
            String fileName = l + ".doc";
            CreateWord.createChoice(map,templateName,filePath,fileName);
        } catch (Exception e) {
            System.out.println("文件下载失败");
            e.printStackTrace();
        }
    }
}
