package ch.fhnw.webec.booklist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.fhnw.webec.booklist.model.Book;
import ch.fhnw.webec.booklist.service.BookService;

@Controller
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    @ResponseBody()
    public String index() {
        Book book = bookService.findAll().get(0);
        Book book2 = bookService.findAll().get(1);

        // language=HTML
        return String.format(
                """
                        <h1>%s</h1>
                        <p>%s</p>
                        <p></p>
                        <h1>%s</h1>
                        <p>%s<p>
                         """, book.getTitle(), book.getDescription(), book2.getTitle(), book2.getDescription());
    }
}
