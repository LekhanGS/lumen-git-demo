package com.example.jpademo.services;

import com.example.jpademo.exceptions.RecordNotFoundException;
import com.example.jpademo.models.Customer;
import com.example.jpademo.models.CustomerAccount;
import com.example.jpademo.repositories.CustomerAccountRepository;
import com.example.jpademo.repositories.CustomerRepository;
import com.example.jpademo.viewmodels.CustomerAccountCreateViewModel;
import com.example.jpademo.viewmodels.CustomerAccountViewModel;
import com.example.jpademo.viewmodels.CustomerViewModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerAccountServiceImplementation implements CustomerAccountService {

    private final CustomerAccountRepository customerAccountRepository;
    private final CustomerRepository customerRepository;

    public CustomerAccountServiceImplementation(CustomerAccountRepository customerAccountRepository, CustomerRepository customerRepository) {
        this.customerAccountRepository = customerAccountRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public List<CustomerAccountViewModel> getAll() {
        return customerAccountRepository
                .findAll()
                .stream()
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerAccountViewModel getById(int id) {
        return toViewModel(getEntityById(id));
    }

    @Override
    public List<CustomerAccountViewModel> getByCustomerId(int customerId) {
        return customerAccountRepository
                .findAll()
                .stream()
                .filter(a -> a.getCustomerId() == customerId)
                .map(this::toViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerAccountViewModel create(CustomerAccountCreateViewModel viewModel) {
        return toViewModel(customerAccountRepository.saveAndFlush(toEntity(viewModel)));
    }

    @Override
    public void deleteById(int id) {
        customerAccountRepository.delete(getEntityById(id));
    }
    private CustomerAccountViewModel toViewModel(CustomerAccount entity) {
        CustomerAccountViewModel viewModel = new CustomerAccountViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        viewModel.setCustomer(toViewModel(entity.getCustomer()));
        return viewModel;
    }

    private CustomerViewModel toViewModel(Customer entity) {
        CustomerViewModel viewModel = new CustomerViewModel();
        BeanUtils.copyProperties(entity, viewModel);
        return viewModel;
    }

    private CustomerAccount toEntity(CustomerAccountCreateViewModel viewModel) {
        Customer customer = getParentEntityById(viewModel.getCustomerId());

        CustomerAccount entity = new CustomerAccount();
        BeanUtils.copyProperties(viewModel, entity);
        entity.setCustomer(customer);
        return entity;
    }

    private CustomerAccount getEntityById(int id) {
        return customerAccountRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Account with id: %d is not found", id)));
    }

    private Customer getParentEntityById(int customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Customer with id: %d is not found", customerId)));
    }


}
