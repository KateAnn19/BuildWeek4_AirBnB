package local.airbnb.buildairbnb.services;

import local.airbnb.buildairbnb.exceptions.ResourceNotFoundException;
import local.airbnb.buildairbnb.models.Listing;
import local.airbnb.buildairbnb.models.OptimalPrice;
import local.airbnb.buildairbnb.models.User;
import local.airbnb.buildairbnb.repository.ListingRepository;
import local.airbnb.buildairbnb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Service(value = "listService")
public class ListingServiceImpl implements ListingService
{
    @Autowired
    ListingRepository listingRepo;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService userService;


    @Transactional
    @Override
    public void delete(long id)
    {

        if (listingRepo.findById(id).isPresent())
        {

            listingRepo.deleteById(id);
        } else
        {
            throw new ResourceNotFoundException("Listing with id " + id + " Not Found!");
        }
    }


    @Override
    public List<Listing> findByUser_UsernameIgnoringCase(String name){
        return listingRepo.findByUser_UsernameIgnoringCase(name);
    }


    @Override
    public Listing findListingById(long id)
    {
        return listingRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Listing with id " + id + " Not Found!"));
    }

    @Override
    public List<Listing> findAll()
    {
        List<Listing> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        listingRepo.findAll()
            .iterator()
            .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public Listing saveByAuth(User user, Listing list, String str)
    {
        Listing newListing = new Listing();
        User dbuser = userRepository.findById(user.getUserid())
            .orElseThrow(() -> new ResourceNotFoundException("User id " + user.getUserid() + " not found"));
        newListing.setUser(dbuser);


        if (list.getListingid() != 0)
        {
            listingRepo.findById(list.getListingid())
                .orElseThrow(() -> new ResourceNotFoundException("Listing id " + list.getListingid() + " not found!"));
        }


        newListing.setRoomtype(list.getRoomtype());
        newListing.setAccomodates(list.getAccomodates());
        newListing.setBathrooms(list.getBathrooms());
        newListing.setCity(list.getCity());
        newListing.setLatitude(list.getLatitude());
        newListing.setLongitude(list.getLongitude());
        newListing.setReviewscoresrating(list.getReviewscoresrating());
        newListing.setBedrooms(list.getBedrooms());
        newListing.setBeds(list.getBeds());
        newListing.setTv(list.getTv());
        newListing.setStreetaddress(list.getStreetaddress());
        newListing.setZipcode(list.getZipcode());

        newListing.setPrice(str);
        newListing.setUser(user);

        return listingRepo.save(newListing);
    }

    @Transactional
    @Override
    public Listing save(long userid, Listing list){

        User currentUser = userService.findUserById(userid);
        Listing newListing = new Listing();

        if (list.getListingid() != 0)
        {
            listingRepo.findById(list.getListingid())
                .orElseThrow(() -> new ResourceNotFoundException("Listing id " + list.getListingid() + " not found!"));
        }



        newListing.setRoomtype(list.getRoomtype());
        newListing.setAccomodates(list.getAccomodates());
        newListing.setBathrooms(list.getBathrooms());
        newListing.setCity(list.getCity());
        newListing.setLatitude(list.getLatitude());
        newListing.setLongitude(list.getLongitude());
        newListing.setReviewscoresrating(list.getReviewscoresrating());
        newListing.setBedrooms(list.getBedrooms());
        newListing.setBeds(list.getBeds());
        newListing.setTv(list.getTv());
        newListing.setStreetaddress(list.getStreetaddress());
        newListing.setZipcode(list.getZipcode());
        newListing.setUser(currentUser);

        return listingRepo.save(newListing);
    }

    @Transactional
    @Override
    public Listing savePrice(Listing list, String str)
    {
        Listing currentListing = list;
         currentListing.setRoomtype(list.getRoomtype());
         currentListing.setAccomodates(list.getAccomodates());
         currentListing.setBathrooms(list.getBathrooms());
         currentListing.setCity(list.getCity());
         currentListing.setLatitude(list.getLatitude());
         currentListing.setLongitude(list.getLongitude());
         currentListing.setReviewscoresrating(list.getReviewscoresrating());
         currentListing.setBedrooms(list.getBedrooms());
         currentListing.setBeds(list.getBeds());
         currentListing.setTv(list.getTv());
         currentListing.setStreetaddress(list.getStreetaddress());
         currentListing.setZipcode(list.getZipcode());
        currentListing.setPrice(str);
        currentListing.setUser(list.getUser());

        return listingRepo.save(currentListing);
    }




    @Transactional
    @Override
    public Listing update(User user, Listing list, long id){

        User currentUser = user;

            Listing currentListing = listingRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Listing id " + id + " not found!"));

        //    "roomtype": "string",
        //    "accommodates": 0,
        //    "bathrooms": 0,
        //    "city": "string",
        //    "latitude": 0,
        //    "longitude": 0,
        //    "reviewscoresrating": 0,
        //    "bedrooms": 0,
        //    "beds": 0,
        //    "tv": 0,
        //    "steetaddress": "string",
        //    "zipcode" : 0

            if (list.getRoomtype() != null)
            {
                currentListing.setRoomtype(list.getRoomtype());
            }

            if (list.hasvalueforaccomodates)
            {
            currentListing.setAccomodates(list.getAccomodates());
            }

            if (list.hasvalueforbathrooms) //number
            {
                currentListing.setBathrooms(list.getBathrooms());
            }


        if(list.getCity() != null)
        {
            currentListing.setCity(list.getCity());
        }


        if (list.hasvalueforlatitude) //number
        {
            currentListing.setLatitude(list.getLatitude());
        }
        if (list.hasvalueforlongitude) //number
        {
            currentListing.setLongitude(list.getLongitude());
        }
        if(list.hasvalueforreviewscore)
        {
            currentListing.setReviewscoresrating(list.getReviewscoresrating());
        }
        if(list.hasvalueforzipcode)
        {
            currentListing.setZipcode(list.getZipcode());
        }

        if(list.hasvalueforbedrooms)
        {
            currentListing.setBedrooms(list.getBedrooms());
        }

        if(list.hasvalueforbeds)
        {
            currentListing.setBeds(list.getBeds()); //number
        }


        if(list.hasvaluefortv)
        {
            currentListing.setTv(list.getTv()); //number
        }

        //ds endpoint

        RestTemplate restTemplate = new RestTemplate();

        System.out.println("THIS IS THE LIST " + currentListing);

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);


        System.out.println("Reached this spot");

        String reqUrl = "https://testapifortesting.herokuapp.com/predict";

        System.out.println("made the request");
        ParameterizedTypeReference<OptimalPrice> responseType = new ParameterizedTypeReference<>() {
        };

        HttpEntity<Listing> requestEntity = new HttpEntity<>(currentListing);

        ResponseEntity<OptimalPrice> responseEntity = restTemplate.exchange(reqUrl,
            HttpMethod.POST, requestEntity, responseType);


        OptimalPrice price = responseEntity.getBody();

        //optimalpriceService.save(list.getListingid(), price);

        String stringPrice = new String(responseEntity.getBody().getPrices());
        //Str = Str.replaceAll("[A-Z]+[:]+[a-z]+",);
        stringPrice = stringPrice.replaceAll("[a-zA-Z]", "");
        stringPrice = stringPrice.replaceAll("[}{:\"]", "");
        stringPrice = stringPrice.replaceAll("[\\s+]", "");
        System.out.println(stringPrice);
        //System.out.println(Str.substring(10,17));

        System.out.println("This is response entity " + responseEntity.getBody().getPrices());

        System.out.println(price);


        //ds endpoint

        //override price
        currentListing.setPrice(stringPrice);

        currentListing.setUser(currentUser);

        return listingRepo.save(currentListing);
    }


    @Override
    public void deleteAll()
    {
        listingRepo.deleteAll();
    }
}
