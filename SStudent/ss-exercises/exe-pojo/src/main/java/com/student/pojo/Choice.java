package com.student.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 选择题
 */
@Data
@Document("Choice")
public class Choice {
    @Id
    private String id;
    //标题
    private String title;
    //选项
    private String aVal;
    private String bVal;
    private String cVal;
    private String dVal;
    //答案
    private String answer;
}
