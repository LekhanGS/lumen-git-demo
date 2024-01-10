package com.example.jpademo.services;

import com.example.jpademo.viewmodels.CustomerAccountCreateViewModel;
import com.example.jpademo.viewmodels.CustomerAccountViewModel;

import java.util.List;

public interface CustomerAccountService {
    List<CustomerAccountViewModel> getAll();
    CustomerAccountViewModel getById(int id);
    List<CustomerAccountViewModel> getByCustomerId(int customerId);
    CustomerAccountViewModel create(CustomerAccountCreateViewModel viewModel);
    void deleteById(int id);
}
