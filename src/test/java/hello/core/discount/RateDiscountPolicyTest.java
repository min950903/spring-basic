package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되아야 한다.")
    void vip_rate_true() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //then
        int discountPrice = discountPolicy.discount(member, 10000);

        // when
        assertThat(discountPrice).isEqualTo(1000);

    }

    @Test
    @DisplayName("VIP가 아니며 할인이 적용되지 않아야 한다.")
    void vip_rate_false() {
        // given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        //then
        int discountPrice = discountPolicy.discount(member, 10000);

        // when
        assertThat(discountPrice).isEqualTo(0);

    }
}