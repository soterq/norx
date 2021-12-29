package com.example.norx.spender;

public class MyAccountServiceImpl implements MyAccountService{
    MyAccountRepository myAccountRepository;
    @Override
    public MyAccount getMyAccount(Long accountId) {
        return myAccountRepository.findById(accountId).get();
    }
}
