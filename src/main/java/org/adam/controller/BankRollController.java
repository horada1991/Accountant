package org.adam.controller;

import org.adam.model.BankRoll;
import org.adam.model.SavingsCategory;
import org.adam.model.User;
import org.adam.service.BankRollService;
import org.adam.service.SavingsCategoryService;
import org.adam.service.SecurityService;
import org.adam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/bankroll")
public class BankRollController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private SavingsCategoryService savingsCategoryService;

    @Autowired
    private BankRollService bankRollService;

    @RequestMapping(value = "/add-savings-category", method = RequestMethod.POST)
    public String addNewSavingsCategory(@RequestParam(value = "savingsCategoryName") String name,
                                        @RequestParam(value = "savingsPercentage") Float percentage)
    {
        User loggedInUser = userService.findByUsername(securityService.findLoggedInUsername());
        SavingsCategory savingsCategory = new SavingsCategory();
        savingsCategory.setName(name);
        savingsCategory.setPercentage(percentage / 100);
        savingsCategoryService.addNewCategory(savingsCategory);

        BankRoll bankRoll = bankRollService.findOne(loggedInUser.getBankRoll().getId());
        bankRoll.saveNewSavingsCategory(savingsCategory);
        bankRollService.save(bankRoll);

        return "redirect:/user-page";
    }
}
