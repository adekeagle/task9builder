package model;

import java.sql.Date;

public class TEST {
    public static void main(String[] args) {

        Article a = Article.builder()
                .id(1)
                .title("test")
                .content("testtest")
                .publishDate(new Date(11113))
                .and()
                .build();

        System.out.println(a.toString());

        Camel camel = Camel.builder()
                .id(2)
                .name("test")
                .age(20)
                .gender(Gender.FAMALE)
                .and()
                .weight(85.5F)
                .height(123.5F)
                .furColor("zielony")
                .build();

        System.out.println(camel.toString());
    }
}
