package com.demo.springsecurityangular.rest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Data access layer of program
 * @version
 *      1.1 04 JULY 2022 @author: 
 *      Oğuz Kuyucu
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    
}
