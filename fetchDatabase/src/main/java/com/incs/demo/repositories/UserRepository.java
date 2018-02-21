package com.incs.demo.repositories;

import com.incs.demo.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface UserRepository extends PagingAndSortingRepository<Users, Long> {
       Page<Users> findUsersByUserEmailEndingWith(String s,Pageable pageable);
    }
