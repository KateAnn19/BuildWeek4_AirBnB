package local.airbnb.buildairbnb.controllers;

import local.airbnb.buildairbnb.BuildairbnbApplication;
import local.airbnb.buildairbnb.services.ListingService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)

@SpringBootTest(classes = BuildairbnbApplication.class)

@WithMockUser(username = "admin", roles={"ADMIN", "DATA"})
public class ListingControllerTest
{
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private ListingService listingService;

    @Before
    public void setUp() throws Exception
    { /*****
     * The following is needed due to security being in place!
     */
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .apply(SecurityMockMvcConfigurers.springSecurity())
            .build();

        /*****
         * Note that since we are only testing bookstore data, you only need to mock up bookstore data.
         * You do NOT need to mock up user data. You can. It is not wrong, just extra work.
         */

        /************
         * Seed Users and Listings
         ************/

    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void listAllUserlistings()
    {
    }

    @Test
    public void getListingById()
    {
    }

    @Test
    public void addNewUserListing()
    {
    }

    @Test
    public void addNewListing()
    {
    }

    @Test
    public void updateListing()
    {
    }

    @Test
    public void deleteUserListingById()
    {
    }
}