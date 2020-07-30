package local.airbnb.buildairbnb.services;

import local.airbnb.buildairbnb.BuildairbnbApplication;
import local.airbnb.buildairbnb.exceptions.ResourceNotFoundException;
import local.airbnb.buildairbnb.models.Listing;
import local.airbnb.buildairbnb.repository.ListingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BuildairbnbApplication.class)
public class ListingServiceImplTest
{
    @Autowired
    private ListingService listingService;

    @Autowired
    private ListingRepository listingRepository;

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
//        List<Listing> myList = listingService.findAll();
//        for (Listing l : myList)
//        {
//            if(l.getUser().getUsername() == "admin")
//            {
//                assertEquals("admin", listingRepository.findByUser_UsernameIgnoringCase("admin"));
//            }
//        }
//
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

    @org.junit.Test
    public void f_save()
    {
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