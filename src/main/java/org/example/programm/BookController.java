package org.example.programm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Класс контроллер
 *
 * @version 1.0
 */
@Controller
public class BookController {
    /**
     * Импорт класса BooksService
     */
    @Autowired
    private BookService bookService;

    /**
     * Метод для приветственной страниц, сюда можно потом будет добавить переход на доп страницы
     * @since 1.0
     * @param model класс, отвечающий за передачу данных в Spring MVC из контроллера в шаблон
     * @return возвращает шаблон
     */
    @GetMapping("/")
    public String home(Model model) {
        try {
            model.addAttribute("message", "Добро пожаловать в Библиотеку!");
            return "index";
        } catch (Exception e) {
            return "error";
        }
    }

    /**
     * Метод главное страницы
     * @since 1.0
     * @param model класс, отвечающий за передачу данных в Spring MVC из контроллера в шаблон
     * @param keyword ключевое слово для поиска
     * @return возвращает шаблон
     */
    @GetMapping("/book/")
    public String book(Model model, @RequestParam(value = "keyword", required = false) String keyword) {
        try {
            List<Book> booklist = bookService.getAllBooks(keyword);
            model.addAttribute("bookList", booklist);
            model.addAttribute("keyword", keyword);
            return "book";
        } catch (Exception e) {
            return "error";
        }
    }

    /**
     * Метод удаления книги
     * @since 1.0
     * @param id возвращает ID для удаления книги
     * @return редирект на главную
     */
    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        try {
            bookService.deleteBook(id);
            return "redirect:/book/";
        } catch (Exception e) {
            return "error";
        }
    }

    /**
     * Метод добавления книги
     * @since 1.0
     * @param model Модель для формирования списка
     * @return возвращает шаблон редактирования книги
     */
    @RequestMapping("/book/new")
    public String newbook(Model model) {
        try {
            Book book = new Book();
            model.addAttribute("book", new Book());
            return "newbook";
        } catch (Exception e) {
            return "error";
        }
    }

    /**
     * Метод сохранения книги
     * @since 1.0
     * @param book содержит в себе данные для передачи в БД
     * @return редирект на главную
     */
    @PostMapping("/book/save")
    public String save(@ModelAttribute("book") Book book) {
        try {
            bookService.saveBook(book);
            return "redirect:/book/";
        } catch (Exception e) {
            return "error";
        }
    }

    /**
     * Метод редактирования книги
     * @since 1.0
     * @param id возвращает ID для редактирования книги
     * @return возвращает список параметров книги для дальнейшего редактирования
     */
    @GetMapping("/book/edit/{id}")
    public ModelAndView editBook(@PathVariable("id") Integer id) {
        try {
            ModelAndView mav = new ModelAndView("editbook");
            Book book = bookService.getBook(id);
            mav.addObject("book", book);
            return mav;
        } catch (Exception e) {
            return new ModelAndView("error");
        }
    }
}
