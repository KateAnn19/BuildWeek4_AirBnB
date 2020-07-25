package local.airbnb.buildairbnb.repository;


import local.airbnb.buildairbnb.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository
        extends CrudRepository<Author, Long>
{
}
