package com.graciolli.stm;

import org.springframework.boot.SpringApplication;

public class TestSimpleTaskManagerApplication {

    public static void main(String[] args) {
        SpringApplication.from(SimpleTaskManagerApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
