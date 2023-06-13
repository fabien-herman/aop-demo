package com.example.aopdemo;

import com.example.aopdemo.us.flows.DummyFlow;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AopDemoApplication {

    public static void main(String[] args)
    {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder()
                .sources(AopDemoApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.NONE)
                .run(args);

        DummyFlow flow = ctx.getBean(DummyFlow.BEAN_NAME, DummyFlow.class);

        flow.run().forEach(System.out::println);
    }
}
