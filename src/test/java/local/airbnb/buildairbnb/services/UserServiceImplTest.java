package local.airbnb.buildairbnb.services;

import local.airbnb.buildairbnb.BuildairbnbApplication;
import local.airbnb.buildairbnb.exceptions.ResourceNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BuildairbnbApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceImplTest
{
    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void A_findUserById()
    {
        assertEquals("admin", userService.findUserById(4)
            .getUsername());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void BA_findUserByIdNotFound()
    {
        assertEquals("admin", userService.findUserById(10)
            .getUsername());
    }

    @Test
    public void B_findByUsernameIgnoringCase()
    {
    }

    @Test
    public void C_findByNameContaining()
    {
    }

    @Test
    public void D_findAll()
    {
        assertEquals(5, userService.findAll()
            .size());
    }

    @Test
    public void Z_delete()
    {
        userService.delete(4);
        assertEquals(4, userService.findAll()
            .size());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void ZA_notFoundDelete()
    {
        userService.delete(100);
        assertEquals(4, userService.findAll()
            .size());
    }

    @Test
    public void E_findByName()
    {
        assertEquals("puttat", userService.findByName("puttat")
            .getUsername());
    }

    @Test
    public void F_save()
    {
    }

    @Test
    public void G_update()
    {
    }

    @Test
    public void deleteAll()
    {
    }
}