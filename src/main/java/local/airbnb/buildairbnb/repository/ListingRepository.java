package local.airbnb.buildairbnb.repository;

import local.airbnb.buildairbnb.models.Listing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ListingRepository extends CrudRepository<Listing, Long>
{
    List<Listing> findByUser_UsernameIgnoringCase(String name);
}
