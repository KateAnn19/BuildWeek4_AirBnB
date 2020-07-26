package local.airbnb.buildairbnb.services;

import local.airbnb.buildairbnb.exceptions.ResourceNotFoundException;
import local.airbnb.buildairbnb.models.Listing;
import local.airbnb.buildairbnb.models.User;
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
        Listing newListing = new Listing();


        if (list.getListingid() != 0)
        {
            listingRepo.findById(list.getListingid())
                .orElseThrow(() -> new ResourceNotFoundException("Listing id " + list.getListingid() + " not found!"));
        }

//        String propertytype,
//        String roomtype,
//        int accomodates,
//        int bathrooms,
//        boolean cleanfee,
//        String city,
//        int latitude,
//        int longitude,
//        int reviewscoresrating,
//        long zipcode,
//        int bedrooms,
//        int beds,
//        boolean dryer,
//        boolean parking,
//        long descriptionLen,
//        User user

        newListing.setPropertytype(list.getPropertytype());
        newListing.setRoomtype(list.getRoomtype());
        newListing.setAccomodates(list.getAccomodates());
        newListing.setBathrooms(list.getBathrooms());
        newListing.setCleanfee(list.isCleanfee());
        newListing.setCity(list.getCity());
        newListing.setLatitude(list.getLatitude());
        newListing.setLongitude(list.getLongitude());
        newListing.setReviewscoresrating(list.getReviewscoresrating());
        newListing.setZipcode(list.getZipcode());
        newListing.setBedrooms(list.getBedrooms());
        newListing.setBeds(list.getBeds());
        newListing.setDryer(list.isDryer());
        newListing.setParking(list.isParking());
        newListing.setDescriptionLen(list.getDescriptionLen());
        newListing.setUser(list.getUser());

        return listingRepo.save(newListing);
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
