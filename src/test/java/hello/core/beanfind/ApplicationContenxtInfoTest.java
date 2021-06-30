package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Description;

public class ApplicationContenxtInfoTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @Description("모든 빈 출력하기")
    void findAllBean() {
        String [] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = applicationContext.getBean(beanDefinitionName);
            System.out.println("name= " + beanDefinitionName + "object =" + bean);
        }

    }

    @Test
    @Description("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String [] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);

            // ROLE_APPLICATION 애플리케이션 실행시 만든 빈
            // ROLE_INFRASTRUCTURE 스프링이 내부적으로 만든 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = applicationContext.getBean(beanDefinitionName);
                System.out.println("name= " + beanDefinitionName + "object =" + bean);
            }

        }

    }
}
