package dk.kea.paginationbackenddat23c.repository;

import dk.kea.paginationbackenddat23c.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
