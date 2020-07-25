package local.airbnb.buildairbnb.services;


import local.airbnb.buildairbnb.models.Author;

import java.util.List;

public interface AuthorService
{
    List<Author> findAll();

    Author findAuthorById(long id);

    void delete(long id);

    Author save(Author role);

    Author update(Author role,
                  long id);

    void deleteAll();
}