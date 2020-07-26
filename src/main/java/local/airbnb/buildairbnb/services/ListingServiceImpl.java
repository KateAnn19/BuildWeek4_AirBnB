package local.airbnb.buildairbnb.services;

import local.airbnb.buildairbnb.models.Listing;
import local.airbnb.buildairbnb.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "listService")
public class ListingServiceImpl implements ListingService
{
    @Autowired
    ListingRepository listingRepo;

    @Transactional
    @Override
    public void delete(long id){
        listingRepo.deleteById(id);
    }

    @Transactional
    @Override
    public Listing save(Listing list){
        return null;
    }

    @Transactional
    @Override
    public Listing update(Listing list,
        long id){
        return null;
    }

    @Override
    public void deleteAll()
    {
        listingRepo.deleteAll();
    }
}
