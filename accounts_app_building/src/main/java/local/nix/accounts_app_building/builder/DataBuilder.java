package local.nix.accounts_app_building.builder;

import local.nix.accounts_data.entity.Account;
import local.nix.accounts_data.generator.CodeGenerator;
import local.nix.accounts_data.service.AccountService;
import local.nix.accounts_data.service.impl.AccountServiceImpl;

import java.math.BigDecimal;
import java.util.*;

public class DataBuilder implements AbstractBuilder {

    private final AccountService accountService = new AccountServiceImpl();

    CodeGenerator generator = new CodeGenerator() {
        @Override
        public String generateCode() {
            return UUID.randomUUID().toString();
        }
    };


    @Override
    public void buildDataList() {

        for (Map.Entry<String, String> entry : getKeyValueMapByBundleProperties().entrySet()) {


                Account account = new Account(generator.generateCode());
                String[] accountProperties = entry.getValue().split("#");
                account.setPhoneNumber(accountProperties[0]);
                account.setAmount(new BigDecimal(accountProperties[1]));
                accountService.saveOrUpdate(account);

        }


        accountService.findAll().forEach(account -> {
            System.out.println("account " + account.getId() + ":" + " " + account.getCode() + " " + account.getPhoneNumber() + " " + account.getAmount());
        });
    }

    public AccountService getAccountService() {
        return accountService;
    }

}
