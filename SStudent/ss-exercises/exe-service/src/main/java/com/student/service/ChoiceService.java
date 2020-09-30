package com.student.service;

import com.student.pojo.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
public class ChoiceService {
    @Resource
    private MongoTemplate mongoTemplate;

    //获取题目
    public List<Choice> getChoices(){
        Query query = new Query();
        //总题目数量
        int count = (int) mongoTemplate.count(query, Choice.class);
        //设置偏移量
        Random random = new Random();
        int nextInt = random.nextInt((count - 19));
        query.skip(nextInt).limit(20);
        List<Choice> choices = mongoTemplate.find(query, Choice.class);
        return choices;
    }

    //添加题目
    public Choice saveChoice(Choice choice){
        Choice insert = mongoTemplate.insert(choice);
        return insert;
    }
}
