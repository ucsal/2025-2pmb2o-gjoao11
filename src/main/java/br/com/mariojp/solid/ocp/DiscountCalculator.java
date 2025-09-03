package br.com.mariojp.solid.ocp;

import java.util.EnumMap;
import java.util.Map;

public class DiscountCalculator {
    private Map<CustomerType, DiscountPolicy> policies = new EnumMap<>(CustomerType.class);

    public DiscountCalculator() {
        policies.put(CustomerType.REGULAR, new RegularDiscountPolicy());
        policies.put(CustomerType.PREMIUM, new PremiumDiscountPolicy());
        policies.put(CustomerType.PARTNER, new PartnerDiscountPolicy());
    }

    public double apply(double amount, CustomerType type) {
        DiscountPolicy policy = policies.get(type);
        return policy.apply(amount);
    }
}
