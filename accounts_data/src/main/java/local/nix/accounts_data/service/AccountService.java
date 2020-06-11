package local.nix.accounts_data.service;

import local.nix.accounts_data.entity.Account;

public interface AccountService extends AbstractService<Account>{

    Account findAccountByCode(String code);
    Account findAccountByPhoneNumber(String phoneNumber);
}
