/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.extraexample;

import com.codingnomads.springdata.example.mybatis.extraexample.mappers.ChapterMapper;
import com.codingnomads.springdata.example.mybatis.extraexample.mappers.ImageMapper;
import com.codingnomads.springdata.example.mybatis.extraexample.mappers.LessonMapper;
import com.codingnomads.springdata.example.mybatis.extraexample.mappers.SectionMapper;
import com.codingnomads.springdata.example.mybatis.extraexample.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyBatisExampleApplication implements CommandLineRunner {

    /* Before running this app, be sure to:

       * create a new empty schema in the mysql database named "mybatis"

       * execute the SQL found "database_structure.sql" on the mybatis schema

       * update the "spring.datasource.url" property in your application.properties file to
         jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

    */

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    LessonMapper lessonMapper;

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    SectionMapper sectionMapper;

    public static void main(String[] args) {
        SpringApplication.run(MyBatisExampleApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {

        imageMapper.insertNewImage("Picture of Dorian Gray");

        System.out.println(imageMapper.getImageByName("Picture of Dorian Gray"));

        imageMapper.updateImageByName("Picture of Dorian Gray", "'Photograph' by Nickelback");

        imageMapper.deleteImageByName("'Photograph' by Nickelback");

        lessonMapper.insertNewLesson("How to Make Friends and Influence People","Lorem ipsum dolor sit amet", (long)47);

        System.out.println(lessonMapper.getLessonByChapterId((long)47));

        imageMapper.insertNewImage("Picture of Dorian Gray");

        lessonMapper.addImageToLesson((long)47, "Picture of Dorian Gray");

        lessonMapper.deleteImageFromLesson((long)47, "Picture of Dorian Gray");

        chapterMapper.insertNewChapter("How I Learned to Stop Worrying and Love The Bomb", (long)3);

        System.out.println(chapterMapper.getByChapterId((long)3));

        chapterMapper.deleteChapterById((long)1);

        sectionMapper.insertNewSection("Section 1: Getting Through It");

        System.out.println(sectionMapper.getSectionById((long)1));

        sectionMapper.deleteSectionById((long)1);

    }
}
