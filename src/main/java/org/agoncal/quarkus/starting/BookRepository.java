package org.agoncal.quarkus.starting;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name="books.genre", defaultValue = "Sci-Fi")
    private String genre;

    public List<Book> getAllBooks(){
        return List.of(
                new Book(1,"Test1", "Auth1", 2010, genre),
                new Book(2, "Book2", "Auth2", 2011, genre) );
    }

    public Optional<Book> getBook(Integer id){
        return getAllBooks().stream()
                .filter(book -> book.id == id)
                .findFirst();
    }
}
