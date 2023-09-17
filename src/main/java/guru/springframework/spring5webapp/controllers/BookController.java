package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository; //Injecting in an instance of the book repository

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }
    //At runtime, when spring gets a request to the URL /books, it's going to execute the getBooks() method
    // and will provide that method w/ a model object. Our code says for that model,
    // we are going to add the attribute called "books" and we're going to execute bookRepository.findAll().
    // This model will get returned back to our view layer, and it's going to have
    // an attribute "books", and a list of books, and we will be able to utilize that value inside our view layer
    // to apply the necessary view to return back to the client.
}
