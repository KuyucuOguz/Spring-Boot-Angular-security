

package com.demo.springsecurityangular.rest;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents book class which has properties; id:int , dateOfPublish: LocalDate, author:String, name:String
 * It also creates table named book_table if it does not exist.
 * @version
 *      1.1 04 JULY 2022 @author: 
 *      Oğuz Kuyucu
 */
@Entity
@Table(name = "book_table")
public class Book {
    @Id
    private int id;
    private LocalDate dateOfPublish;
    private String author;
    private String name;
    
    public Book() {

    }

    public Book(LocalDate dateOfPublish, String author, String name) {
        this.dateOfPublish = dateOfPublish;
        this.author = author;
        this.name = name;
    }

    public Book(int id, LocalDate dateOfPublish, String author, String name){
        this.id = id;
        this.dateOfPublish = dateOfPublish;
        this.author = author;
        this.name = name;
    }
    
    public int getId(){
        return id;
    }
    public LocalDate getDateOfPublish(){
        return dateOfPublish;
    }

    public String getAuthor(){
        return author;
    }

    public String getName(){
        return name;
    }

    public void setId(int newId){
        id = newId;
    }

    public void setAuthor(String newAuthor){
        author = newAuthor;
    }

    public void setPublishmentDate(LocalDate newPublishmentDate){
        dateOfPublish = newPublishmentDate;
    }

    public void setName(String newName){
        name = newName;
    }

}
