package dk.kea.paginationbackenddat23c.config;

import dk.kea.paginationbackenddat23c.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DataSetup implements CommandLineRunner {
    BookRepository bookRepository;

    public DataSetup(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

  /*
    Not actually used, since data are setup via the data.sql script
    This demonstrates how the script originally was made from a prompt to ChatGPT

   */

    @Override
    public void run(String... args) throws Exception {
        // Add xx books with meaningful titles for people aged 20-40
        // bookRepository.save(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling"));
        // bookRepository.save(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling"));
        // ....

        System.out.println("Books added to database: " + bookRepository.count());

        // This is how i made the data.sql script
        // List<Book> books = bookRepository.findAll();
        // String sql = books.stream().map(book -> "INSERT INTO book (title, author) VALUES ('"+book.getTitle()+"', '"+book.getAuthor()+"');").reduce("", (a, b) -> a + "\n" + b);
        // System.out.println(sql);
    }

}
