package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }



    @Override
    public void run(String... args) throws Exception {


            Publisher pub = new Publisher();
            pub.setName("SKJ Publishing");
            pub.setAddressLine1("508 SunnyKiwi Dr");
            pub.setCity("Toronto");
            pub.setState("FL");
            pub.setZip("12345");

            publisherRepository.save(pub);
            System.out.println("Started in bootstrap");
            System.out.println("Publisher count: " + publisherRepository.count());

            Author eric = new Author("Eric", "Evans");
            Book ddd = new Book("Domain Driven Design", "123123");
            eric.getBooks().add(ddd);
            ddd.getAuthors().add(eric);

            ddd.setPubisher(pub);
            pub.getBooks().add(ddd);

            authorRepository.save(eric);
            bookRepository.save(ddd);
            publisherRepository.save(pub);

            Author rod = new Author("Rod", "Johnson");
            Book noEJB = new Book("J2EE Development without EJB", "3939459459");
            rod.getBooks().add(noEJB);
            noEJB.getAuthors().add(rod);

            noEJB.setPubisher(pub);
            pub.getBooks().add(noEJB);

            authorRepository.save(rod);
            bookRepository.save(noEJB);
            publisherRepository.save(pub);


            System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher number of books: " + pub.getBooks().size());






    }
}
