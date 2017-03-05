package org.adam.service.implementations;

import org.adam.model.BankRoll;
import org.adam.model.SavingsCategory;
import org.adam.repositories.BankRollRepository;
import org.adam.service.BankRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankRollServiceImpl implements BankRollService {
    @Autowired
    private BankRollRepository repository;

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
}
