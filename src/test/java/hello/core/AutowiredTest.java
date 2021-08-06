package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.order.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredTest {

    @Test
    void autowiredTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

//        ac.getBean(OrderServiceImpl.class)

    }
}
