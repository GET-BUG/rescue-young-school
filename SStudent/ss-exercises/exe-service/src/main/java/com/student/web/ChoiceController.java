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

/**
 * 后台任务
 */
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


}
