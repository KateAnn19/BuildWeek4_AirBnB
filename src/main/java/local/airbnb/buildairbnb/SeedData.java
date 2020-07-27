package local.airbnb.buildairbnb;

import local.airbnb.buildairbnb.models.*;
import local.airbnb.buildairbnb.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SeedData puts both known and random data into the database. It implements CommandLineRunner.
 * <p>
 * CoomandLineRunner: Spring Boot automatically runs the run method once and only once
 * after the application context has been loaded.
 */
@Transactional
@Component //comment this out
public class SeedData implements CommandLineRunner
{
    /**
     * Connects the Role Service to this process
     */
    @Autowired
    ListingService listService;

    /**
     * Connects the user service to this process
     */
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;



    /**
     * Generates test, seed data for our application
     * First a set of known data is seeded into our database.
     * Second a random set of data using Java Faker is seeded into our database.
     * Note this process does not remove data from the database. So if data exists in the database
     * prior to running this process, that data remains in the database.
     *
     * @param args The parameter is required by the parent interface but is not used in this process.
     */
    @Transactional
    @Override
    public void run(String[] args) throws
            Exception
    {
        userService.deleteAll();
        listService.deleteAll();

        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);
        r3 = roleService.save(r3);

        // admin, data, user
        User u1 = new User("admin", "password", "admin@lambdaschool.local");
        u1.getRoles().add(new UserRoles(u1, r1));
        u1.getUseremails().add(new Useremail(u1, "admin@email.local"));
        u1.getUseremails().add(new Useremail(u1, "admin@mymail.local"));

        Listing l1 = new Listing(
            "house",
            "whole house",
            3,
            3,
            true,
            "los angeles",
            3,
            3,
            10,
            20304,
            2,
            3,
            true,
            true,
            30,
            "0",
            u1);
        u1.getList().add(l1);

        userService.save(u1);

        // data, user
        User u2 = new User("cinnamon", "1234567", "cinnamon@lambdaschool.local");
        u2.getRoles().add(new UserRoles(u2, r3));
        u2.getUseremails().add(new Useremail(u2, "cinnamon@mymail.local"));
        u2.getUseremails().add(new Useremail(u2, "hops@mymail.local"));
        u2.getUseremails().add(new Useremail(u2, "bunny@email.local"));


                Listing l2 = new Listing("house", "single room", 3,
                    3,
                    true,
                    "los angeles",
                    3,
                    3,
                    10,
                    20304,
                    2,
                    3,
                    true,
                    true,
                    30,"0",
                    u2);

        u2.getList().add(l2);

        userService.save(u2);

        // user
        User u3 = new User("barnbarn", "ILuvM4th!", "barnbarn@lambdaschool.local");
        u3.getRoles().add(new UserRoles(u3, r2));
        u3.getUseremails().add(new Useremail(u3, "barnbarn@email.local"));

                Listing l3 = new Listing("apartment", "whole house", 3,
                    3,
                    true,
                    "los angeles",
                    3,
                    3,
                    10,
                    20304,
                    2,
                    3,
                    true,
                    true,
                    30,"0",
                    u3);
        u3.getList().add(l3);
        userService.save(u3);

        User u4 = new User("puttat", "password", "puttat@school.lambda");
        u4.getRoles().add(new UserRoles(u4, r2));

                Listing l4 = new Listing("apartment", "single room",
                    3,
                    3,
                    true,
                    "los angeles",
                    3,
                    3,
                    10,
                    20304,
                    2,
                    3,
                    true,
                    true,
                    30,"0",
                    u4);
                Listing l5 = new Listing("loft", "single room", 3,
                    3,
                    true,
                    "los angeles",
                    3,
                    3,
                    10,
                    20304,
                    2,
                    3,
                    true,
                    true,
                    30,"0",
                    u4);
        u4.getList().add(l4);
        u4.getList().add(l5);
        userService.save(u4);

        User u5 = new User("misskitty", "password", "misskitty@school.lambda");
        u5.getRoles().add(new UserRoles(u5, r2));
                Listing l6 = new Listing("house", "single room",
                    3,
                    3,
                    true,
                    "los angeles",
                    3,
                    3,
                    10,
                    20304,
                    2,
                    3,
                    false,
                    false,
                    30,"0",
                    u5);
        u5.getList().add(l6);
        userService.save(u5);

        /************
         * Seed Listing
         ************/
//        String propertytype, String roomtype, int accomodates, int bathrooms, boolean cleanfee,
//        String city, int latitude, int longitude, int reviewscoresrating, long zipcode, int bedrooms,
//        int beds, boolean dryer, boolean parking, long descriptionlen, User user



    }
}