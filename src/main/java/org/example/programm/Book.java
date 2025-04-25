package org.example.programm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Books - класс-сущность
 *
 * @version 1.0
 * */
@Entity
@Data
@Table(name = "book")
public class Book {
    /**
     * Уникальный идентификатор
     *
     * @since 1.0
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Уникальный идентификатор книги
     *
     * @since 1.0
     * */
    @Column(name = "title", nullable = false, length = 200)
    private String title;

    /**
     * Автор книги
     *
     * @since 1.0
     * */
    @Column(name = "author", nullable = false, length = 200)
    private String author;

    /**
     * Издательство
     *
     * @since 1.0
     * */
    @Column(name = "publisher", length = 200)
    private String publisher;

    /**
     * Дата выдачи книги студенту
     *
     * @since 1.0
     * */
    @Column(name = "issuedate")
    private java.sql.Date issuedate;

    /**
     * ФИО студента
     *
     * @since 1.0
     * */
    @Column(name = "student", length = 200)
    private String student;

    /**
     * Дата возврата книги студентом
     *
     * @since 1.0
     * */
    @Column(name = "returndate")
    private java.sql.Date returndate;
}
