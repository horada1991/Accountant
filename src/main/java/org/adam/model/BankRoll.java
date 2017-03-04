package org.adam.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class BankRoll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private float actualMoney;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SavingsCategory> savingsCategories = new HashSet<>();

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

    public Set<Detail> getDetails() {
        return details;
    }

    public void setDetails(Set<Detail> details) {
        this.details = details;
    }

    public void addOneObjectToExpenseDetails(Detail detail){
        this.details.add(detail);
    }

    public Set<SavingsCategory> getSavingsCategories() {
        return savingsCategories;
    }

    public void setSavingsCategories(Set<SavingsCategory> savingsCategories) {
        this.savingsCategories = savingsCategories;
    }

    public void saveNewSavingsCategory(SavingsCategory savingsCategory) {
        for (SavingsCategory category: this.savingsCategories){
            if (Objects.equals(category.getName(), savingsCategory.getName())) return;
        }
        this.savingsCategories.add(savingsCategory);
    }
}
