package local.nix.accounts_data.repository;

import local.nix.accounts_data.entity.Account;

public interface AccountRepository extends AbstractRepository<Account>{

    Account findAccountByCode(String code);
    Account findAccountByPhoneNumber(String phoneNumber);
}
