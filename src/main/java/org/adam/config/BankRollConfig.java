package org.adam.config;

import org.adam.model.BankRoll;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class BankRollConfig {

    @Bean
    @Scope(value = "prototype")
    BankRoll bankRollWithZeroFields(){
        BankRoll bankRoll = new BankRoll();
        bankRoll.setActualMoney(0f);
        bankRoll.setSavings(0f);
        bankRoll.setSavingsPercentage(0f);
        return bankRoll;
    }
}
