package com.scorpios.chatroom;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Think
 * @Title: ServletInitializer
 * @ProjectName chatroom
 * @Description: TODO
 * @date 2019/3/1018:41
 */



public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ChatroomApplication.class);
    }

}

