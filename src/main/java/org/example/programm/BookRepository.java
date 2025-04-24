package org.example.programm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT m FROM Book m " +
            "where concat(m.id, m.title, m.author, m.publisher, " +
            "m.issuedate, m.student, m.returndate) LIKE %?1%")
    List<Book> search(String keyword);
}
