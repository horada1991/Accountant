package org.adam.service;

import org.adam.model.SavingsCategory;
import org.springframework.stereotype.Service;

@Service
public interface SavingsCategoryService {
    public void addNewCategory(SavingsCategory savingsCategory);
    public void modifyPercentage(SavingsCategory savingsCategory, float percentage);
}
