package local.airbnb.buildairbnb.services;

import local.airbnb.buildairbnb.models.Listing;

public interface ListingService
{
    void delete(long id);

    Listing save(Listing list);

    Listing update(Listing list, long id);

    public void deleteAll();
}
