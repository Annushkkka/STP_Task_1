package org.example.programm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    // Методы для класса Book
    //Вывод мастеров
    public List<Book> getAllBooks(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }
    //Получение информации по мастеру
    public Book getBook(Integer id) {
        return repo.findById(id).get();
    }
    //Удаление мастера
    public void deleteBook(Integer id) {
        repo.deleteById(id);
    }
    //Сохранение мастера
    public void saveBook(@ModelAttribute("book") Book book) {
        repo.save(book);
    }
}
