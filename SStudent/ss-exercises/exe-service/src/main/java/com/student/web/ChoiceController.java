package com.student.web;

import com.student.common.downUtil.CreateWord;
import com.student.pojo.Choice;
import com.student.service.ChoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/choice")
public class ChoiceController {
    @Resource
    private ChoiceService choiceService;

    //获取所有题目
    @GetMapping("getChoice")
    public List<Choice> getChoice(){
        List<Choice> choices = choiceService.getChoices();
        return choices;
    }
    //保存题目
    @PostMapping("saveChoice")
    public boolean saveChoice(Choice choice){
        Choice choice1 = choiceService.saveChoice(choice);
        if (choice1 != null && "".equals(choice1.getTitle())){
            return false;
        }
        return true;
    }

    /**
     * 在线题目列表
     * @return
     */
    @GetMapping("testPaper")
    @ResponseBody
    public ModelAndView TestPaper(){
        ModelAndView mv = new ModelAndView();
        List<Choice> choices = choiceService.getChoices();
        mv.setViewName("choice");
        mv.addObject("Choices",choices);
        return mv;
    }

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
            String templateName="demo.ftl";
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
