package org.adam.service.implementations;

import org.adam.model.BankRoll;
import org.adam.model.Detail;
import org.adam.model.SavingsCategory;
import org.adam.repositories.BankRollRepository;
import org.adam.service.BankRollService;
import org.adam.service.SavingsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankRollServiceImpl implements BankRollService {
    @Autowired
    private BankRollRepository repository;

    @Autowired
    private SavingsCategoryService savingsCategoryService;

    @Override
    public void save(BankRoll bankRoll) {
        repository.save(bankRoll);
    }

    @Override
    public BankRoll findOne(Integer id) {
        return repository.findOne(id);
    }

    @Override
    public void addAmountToActualMoney(BankRoll bankRoll, Float amount) {
        bankRoll.setActualMoney(bankRoll.getActualMoney() + amount);
        repository.save(bankRoll);
    }

    @Override
    public void handleIncome(BankRoll bankRoll, Float income) {
        float sumOfSavings = 0;
        for (SavingsCategory savingsCategory: bankRoll.getSavingsCategories()){
            Float toSavings =(float) Math.round(income * savingsCategory.getPercentage());
            savingsCategoryService.addAmountToSavings(savingsCategory, toSavings);
            sumOfSavings += toSavings;
        }
        addAmountToActualMoney(bankRoll, income - sumOfSavings);
    }

    @Override
    public void handleExpense(BankRoll bankRoll, Float expense, String reason) {
        Detail detail = new Detail();
        detail.setAmount(expense);
        detail.setType("expense");
        detail.setReason(reason);
        bankRoll.addOneObjectToExpenseDetails(detail);
        addAmountToActualMoney(bankRoll, -1 * expense);
    }
}
