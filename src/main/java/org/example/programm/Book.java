package org.example.programm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/*
 * Books - класс-сущность
 * */
@Entity
@Data
@Table(name = "book")
public class Book {
    /*
     * Переменные
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "author", nullable = false, length = 200)
    private String author;

    @Column(name = "publisher", length = 200)
    private String publisher;

    @Column(name = "issuedate")
    private java.sql.Date issuedate;

    @Column(name = "student", length = 200)
    private String student;

    @Column(name = "returndate")
    private java.sql.Date returndate;
}
