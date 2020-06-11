package local.nix.accounts_data.service;

import local.nix.accounts_data.AbstractData;

import java.util.List;

public interface AbstractService<T extends AbstractData<T>> {
    void saveOrUpdate(T t);
    T findById(Long id);
    List<T> findAll();
    void remove(Long id);
}
