package local.airbnb.buildairbnb.repository;


import local.airbnb.buildairbnb.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository
        extends CrudRepository<Book, Long>
{
}
