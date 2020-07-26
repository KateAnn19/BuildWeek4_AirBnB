package local.airbnb.buildairbnb.repository;

import local.airbnb.buildairbnb.models.Listing;
import org.springframework.data.repository.CrudRepository;

public interface ListingRepository extends CrudRepository<Listing, Long>
{
}
