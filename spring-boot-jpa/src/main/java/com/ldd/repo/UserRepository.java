package com.ldd.repo;

import com.ldd.pojo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author ldd
 * @Date 2023/12/11
 */
public interface UserRepository extends CrudRepository<User,Long> {

}
