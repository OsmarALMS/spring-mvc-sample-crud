package br.com.sample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sample.model.User;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByIsDeletedFalse();
    User findByUserName(String userName);
}
