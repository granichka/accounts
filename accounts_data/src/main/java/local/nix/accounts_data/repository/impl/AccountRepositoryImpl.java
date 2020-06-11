package local.nix.accounts_data.repository.impl;

import local.nix.accounts_data.entity.Account;
import local.nix.accounts_data.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {

    List<Account> accounts = new ArrayList<Account>();


    @Override
    public Account findAccountByCode(String code) {
        return accounts
                .stream()
                .filter(account -> account.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Account findAccountByPhoneNumber(String phoneNumber) {
        return accounts
                .stream()
                .filter(account -> account.getPhoneNumber().equals(phoneNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Account account) {
            accounts.add(account);
    }

    @Override
    public Account findById(Long id) {
        return accounts
                .stream()
                .filter(account -> account.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public void update(Account account) {
        accounts.forEach(currentAccount -> {
            if (account.getId().equals(currentAccount.getId())) {
                currentAccount.setPhoneNumber(account.getPhoneNumber());
            }
        });
    }

    @Override
    public void remove(Long id) {
        accounts.removeIf(account -> account.getId().equals(id));
    }
}
