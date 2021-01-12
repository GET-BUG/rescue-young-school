package com.student.web;

import com.student.pojo.Choice;
import com.student.service.ChoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 在线任务
 */
@Controller
@RequestMapping("/online")
public class OnlineController {
    @Resource
    private ChoiceService choiceService;

    /**
     * 在线考试
     * @return
     */
    @GetMapping("testPaper")
    @ResponseBody
    public ModelAndView TestPaper(){
        ModelAndView mv = new ModelAndView();
        List<Choice> choices = choiceService.getChoices();
        mv.setViewName("html/choice");
        mv.addObject("Choices",choices);
        return mv;
    }
}
