package com.student.service;

import com.student.pojo.Choice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class serviceTest {

    @Resource
    private ChoiceService choiceService;

    @Test
    public void demoTest(){
        List<Choice> choices = choiceService.getChoices();
        
    }
}
