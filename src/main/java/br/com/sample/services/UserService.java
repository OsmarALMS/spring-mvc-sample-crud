package br.com.sample.services;

import java.util.List;

import br.com.sample.model.User;

public interface UserService {
    List<User> getAll();
    User get(long id);
    void add(User user);
    User edit(User user);
    void delete(User user);
    long count();
    User getByName(String name);
    void addList (List<User> users);
}
