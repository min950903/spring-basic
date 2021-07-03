package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.impl.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다.")
    void findBeanByTypeDuplicate() {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> { ac.getBean(MemberRepository.class); });
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 이름을 지정.")
    void findBeanByName() {
        MemberRepository memberRepository =  ac.getBean("memberRepository", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemoryMemberRepository.class);
    }

    @Test
    @DisplayName("해당 타입의 모든 빈을 조회")
    void findAllBean() {
        Map<String, MemberRepository> beans = ac.getBeansOfType(MemberRepository.class);
        for (String s : beans.keySet()) {
            System.out.println("key= " + s + "value = " + beans.get(s));
        }

        System.out.println(beans);
        assertThat(beans.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
