package bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // beans.xml is in root lvl
        //FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");

        // beans.xml is in resources lvl
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        context.registerShutdownHook();

        Person person = context.getBean(Person.class);
        System.out.println(person.getName());
        System.out.println(person.getPersonInfo());
    }
}
