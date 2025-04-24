package org.example.programm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home(Model model) {
        try {
            model.addAttribute("message", "Добро пожаловать в Библиотеку!");
            return "index";
        } catch (Exception e) {
            return "error";
        }
    }
    @GetMapping("/book/")
    public String book(Model model, @Param("keyword") String keyword) {
        try {
            List<Book> booklist = bookService.getAllBooks(keyword);
            model.addAttribute("bookList", booklist);
            model.addAttribute("keyword", keyword);
            return "book";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        try {
            bookService.deleteBook(id);
            return "redirect:/book/";
        } catch (DataIntegrityViolationException e) {
            return "data_error";
        } catch (Exception e) {
            return "error";
        }
    }

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

    @PostMapping("/book/save")
    public String save(@ModelAttribute("book") Book book) {
        try {
            bookService.saveBook(book);
            return "redirect:/book/";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/book/edit/{id}")
    public ModelAndView editBook(@PathVariable Integer id) {
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
