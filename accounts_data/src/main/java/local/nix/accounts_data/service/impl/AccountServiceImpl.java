package local.nix.accounts_data.service.impl;

import local.nix.accounts_data.entity.Account;
import local.nix.accounts_data.generator.CodeGenerator;
import local.nix.accounts_data.repository.AccountRepository;
import local.nix.accounts_data.repository.impl.AccountRepositoryImpl;
import local.nix.accounts_data.service.AccountService;

import java.util.List;


public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository = new AccountRepositoryImpl();

    @Override
    public Account findAccountByCode(String code) {
        return accountRepository.findAccountByCode(code);
    }

    @Override
    public Account findAccountByPhoneNumber(String phoneNumber) {
        return accountRepository.findAccountByPhoneNumber(phoneNumber);
    }

    @Override
    public void saveOrUpdate(Account account) {
        if (account.getId() == null) {
            long id = findAll().size();
            account.setId(++id);
            accountRepository.save(account);
        } else {
            accountRepository.update(account);
        }
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void remove(Long id) {
            accountRepository.remove(id);
    }
}
