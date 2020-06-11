package local.nix.accounts_app_building;

import local.nix.accounts_app_building.builder.DataBuilder;
import local.nix.accounts_data.service.AccountService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataBuilderTest {

    @Test
    public void buildTest() {
        DataBuilder dataBuilder = new DataBuilder();
        AccountService accountService = dataBuilder.getAccountService();
        dataBuilder.buildDataList();

        assertTrue(accountService.findAll().size() == 3);
    }
}
