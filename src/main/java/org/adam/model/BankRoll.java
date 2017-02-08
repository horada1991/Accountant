package org.adam.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class BankRoll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private float actualMoney;
    private float savings;
    private float savingsPercentage;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Detail> details = new HashSet<>();

    public BankRoll() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(float actualMoney) {
        this.actualMoney = actualMoney;
    }

    public float getSavings() {
        return savings;
    }

    public void setSavings(float saving) {
        this.savings = saving;
    }

    public float getSavingsPercentage() {
        return savingsPercentage;
    }

    public void setSavingsPercentage(float savingPercentage) {
        this.savingsPercentage = savingPercentage;
    }

    public Set<Detail> getDetails() {
        return details;
    }

    public void setDetails(Set<Detail> details) {
        this.details = details;
    }

    public void addOneObjectToExpenseDetails(Detail detail){
        this.details.add(detail);
    }
}
