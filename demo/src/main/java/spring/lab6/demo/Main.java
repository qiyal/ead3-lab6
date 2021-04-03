package spring.lab6.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.lab6.demo.config.SpringAppConfig;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        LibraryManagementSystem libraryManagementSystem = ctx.getBean("libraryManagementSystem", LibraryManagementSystem.class);
    }
}
