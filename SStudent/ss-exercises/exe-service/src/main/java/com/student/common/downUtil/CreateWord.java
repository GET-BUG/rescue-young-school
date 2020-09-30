package com.student.common.downUtil;

import com.student.pojo.Choice;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import sun.nio.cs.UTF_32;

import java.io.*;
import java.util.List;
import java.util.Map;

public class CreateWord {

    //生成选择题word
    public static void createChoice(Map choices, String templateName, String filePath, String fileName){
        try {
            //创建配置实例
            Configuration configuration = new Configuration();
            //设置编码
            configuration.setDefaultEncoding("UTF-8");
            //ftl模板路径
            configuration.setClassForTemplateLoading(CreateWord.class,"/templates");
            //获取模板
            Template template = configuration.getTemplate(templateName);
            //输出文件
            File outFile = new File(filePath + File.separator + fileName);
            //如果文件夹不存在则创建文件夹
            if (!outFile.getParentFile().exists()){
                outFile.getParentFile().mkdirs();
            }
            //模板和数据结合,获取输出流
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
            //输出
            template.process(choices,writer);
            //关闭流
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
