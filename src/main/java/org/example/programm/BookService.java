package org.example.programm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/*
 * Класс, отвечающий за логику нашей программы (функции поиска,сохранения и удаления)
 */
@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    /*
     * Метод, отвечающий за
     * @param keyword Ключевое слово для поиска
     * @return возвращает список книг если ключевое слово пустое
     */
    public List<Book> getAllBooks(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    /*
     * Метод получения книги по его ID
     * @param id ID книги из класса Books
     * @return возвращаем книгу по ID
     */
    public Book getBook(Integer id) {
        return repo.findById(id).get();
    }

    /*
     * Метод удаления книги по его ID
     * @param id ID книги из класса Books
     */
    public void deleteBook(Integer id) {
        repo.deleteById(id);
    }

    /*
     * Метод сохранения книги в базе данных, используя репозиторй
     * @param book Экземпляр класса Books для сохранения
     */
    public void saveBook(@ModelAttribute("book") Book book) {
        repo.save(book);
    }
}
