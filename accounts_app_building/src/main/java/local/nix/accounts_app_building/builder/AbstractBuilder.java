package local.nix.accounts_app_building.builder;

import local.nix.accounts_app_building.util.BundleUtil;

import java.util.Map;

public interface AbstractBuilder {

    default Map<String, String> getKeyValueMapByBundleProperties() {
        return BundleUtil.getBundleProperties();
    }

    void buildDataList();
}
