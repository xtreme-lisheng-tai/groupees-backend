package com.groupees.repositories;

import com.groupees.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by dustin on 2016-08-08.
 */
public interface UserRepository extends MongoRepository<User, String> {
    public User findByFirstName(String firstName);
}
