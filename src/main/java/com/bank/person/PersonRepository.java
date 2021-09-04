package com.bank.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);
    @Query("select p from Person p where p.name=:name")
    List<Person> selectByName(@Param("name") String name);
    List<Person> findByAge(Integer age);
    @Query("select p from Person p where p.age=:age")
    List<Person> selectByAge(@Param("age") Integer age);
}
