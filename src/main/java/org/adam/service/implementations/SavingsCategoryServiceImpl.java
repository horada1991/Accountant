package org.adam.service.implementations;

import org.adam.model.SavingsCategory;
import org.adam.repositories.SavingsCategoryRepository;
import org.adam.service.SavingsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SavingsCategoryServiceImpl implements SavingsCategoryService {
    @Autowired
    private SavingsCategoryRepository repository;

    @Override
    public void addNewCategory(SavingsCategory savingsCategory) {
        repository.save(savingsCategory);
    }

    @Override
    public void modifyPercentage(SavingsCategory savingsCategory, float percentage) {
        savingsCategory.setPercentage(percentage);

        repository.save(savingsCategory);
    }
}
