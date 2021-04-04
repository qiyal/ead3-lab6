package spring.lab6.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.lab6.demo.config.SpringAppConfig;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        LibraryManagementSystem libraryManagementSystem = ctx.getBean("libraryManagementSystem", LibraryManagementSystem.class);
        libraryManagementSystem.run();
    }
}
