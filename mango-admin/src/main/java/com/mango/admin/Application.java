package com.mango.admin;

import org.apache.catalina.core.ApplicationContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.mango.admin.dao")//mybatis扫描
public class Application
{

    public static void main( String[] args )
    {
        SpringApplication.run(Application.class,args);
    }
}
