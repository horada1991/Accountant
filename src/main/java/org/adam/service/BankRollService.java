package org.adam.service;

import org.adam.model.BankRoll;
import org.adam.repositories.BankRollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface BankRollService {

    public void save(BankRoll bankRoll);
    public BankRoll findOne(Integer id);
}
