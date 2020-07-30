package local.airbnb.buildairbnb.services;

import local.airbnb.buildairbnb.BuildairbnbApplication;
import local.airbnb.buildairbnb.exceptions.ResourceNotFoundException;
import local.airbnb.buildairbnb.models.Listing;
import local.airbnb.buildairbnb.models.User;
import local.airbnb.buildairbnb.repository.ListingRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BuildairbnbApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ListingServiceImplTest
{
    @Autowired
    private ListingService listingService;

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private UserService userService;

    @org.junit.Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
        List<Listing> myList = listingService.findAll();

        //print out test data
        for(Listing l : myList)
        {
            System.out.println(l.getListingid());
        }

    }

    @org.junit.After
    public void tearDown() throws Exception
    {
    }

    @org.junit.Test
    public void d_delete()
    {
        listingService.delete(9);
        assertEquals(5, listingService.findAll().size());

    }

//    @org.junit.Test
//    public void b_findByUser_UsernameIgnoringCase()
//    {
//
////        List<Listing> myList = listingService.findAll();
////        for (Listing l : myList)
////        {
////            if(l.getUser().getUsername() == "admin")
////            {
////                myList.add(l);
////            }
////        }
////        //System.out.println(myList.get(0).getUser().getUsername() + listingService.findListingById(6).getUser().getUsername());
////        assertEquals(1, myList.size());
//        assertEquals("[local.airbnb.buildairbnb.models.Listing@2fc698a9]", listingService.findByUser_UsernameIgnoringCase("admin").toString());
//
//    }

    @org.junit.Test
    public void c_findListingById()
    {
        assertEquals("boulder", listingService.findListingById(5).getCity());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void c_notFindListingById()
    {
        assertEquals("anchorage", listingService.findListingById(8888).getCity());
    }

    @org.junit.Test
    public void a_findAll()
    {
        assertEquals(6, listingService.findAll().size());
    }

    @org.junit.Test
    public void e_saveByAuth()
    {


    }
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
    //    "price"

    @org.junit.Test
    public void f_save()
    {
        List<User> listUser = userService.findAll();
        User u = listUser.get(0);
        System.out.println("HERE" + u.getRoles());

        Listing newListing = new Listing(
            "single room", 1, 1, "st. louis", 0, 0, 2, 1, 1, 1,
            "123 somewhere drive, st. louis, Missouri 80024", 74012, "click for price", listUser.get(0));

       // User u = listUser.get(0);
        System.out.println("HERE" + u.getRoles());

        u.getList().add(newListing);

        User addUser = userService.save(u);


        User foundUser = userService.findUserById(addUser.getUserid());

        assertNotNull(addUser);
        assertEquals(addUser.getPrimaryemail(), foundUser.getPrimaryemail());


    }

    @org.junit.Test
    public void g_savePrice()
    {
    }

    @org.junit.Test
    public void h_update()
    {
    }

    @org.junit.Test
    public void i_deleteAll()
    {
    }
}