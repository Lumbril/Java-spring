package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Instead of CrudRepository you can use PagingAndSortingRepository for pagination and sorting
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("select p from User p where p.login = :login")
    User findByLogin(@Param("login") String login);
}
