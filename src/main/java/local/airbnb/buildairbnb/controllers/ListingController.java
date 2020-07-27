package local.airbnb.buildairbnb.controllers;

import local.airbnb.buildairbnb.models.Listing;
import local.airbnb.buildairbnb.models.User;
import local.airbnb.buildairbnb.models.Useremail;
import local.airbnb.buildairbnb.services.ListingService;
import local.airbnb.buildairbnb.services.UserService;
import local.airbnb.buildairbnb.services.UseremailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/listings")
public class ListingController
{
    @Autowired
    ListingService listingService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/listings", produces = "application/json")
    public ResponseEntity<?> listAllUserlistings()
    {
        List<Listing> allListings = listingService.findAll();
        return new ResponseEntity<>(allListings, HttpStatus.OK);
    }

    @GetMapping(value = "/listing/{listingId}",
        produces = "application/json")
    public ResponseEntity<?> getListingById(@PathVariable Long listingId)
    {
        Listing li = listingService.findListingById(listingId);
        return new ResponseEntity<>(li, HttpStatus.OK);
    }

    @PostMapping(value = "/user/{userid}")
    public ResponseEntity<?> addNewUserListing(@PathVariable long userid, @RequestBody Listing newListing) throws URISyntaxException
    {
        Listing newUserListing = listingService.save(userid, newListing);
        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserTodoURI = ServletUriComponentsBuilder.fromCurrentServletMapping()
            .path("/listings/listing/{listingid}")
            .buildAndExpand(newUserListing.getListingid())
            .toUri();
        responseHeaders.setLocation(newUserTodoURI);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PostMapping(value = "/listing/create")
    public ResponseEntity<?> addNewListing(Authentication authentication, @RequestBody Listing newListing) throws URISyntaxException
    {
        User u = userService.findByName(authentication.getName());

        listingService.saveByAuth(u, newListing);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PatchMapping(value = "/listing/{listingid}", consumes = {"application/json"}) public ResponseEntity<?>
    updateListing(Authentication authentication, @RequestBody
            Listing updateListing,
        @PathVariable
            long listingid)
    {
        User u = userService.findByName(authentication.getName());

        listingService.update(u, updateListing,
            listingid);


//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI newListingURI = ServletUriComponentsBuilder.fromCurrentServletMapping()
//            .path("/listings/listing/{listingid}")
//            .buildAndExpand(listingid)
//            .toUri();
//        responseHeaders.setLocation(newListingURI);
//
//        return new ResponseEntity<>(null, responseHeaders, HttpStatus.OK);


       return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{listingid}")
    public ResponseEntity<?> deleteUserListingById(Authentication authentication, @PathVariable long listingid)
    {
        User u = userService.findByName(authentication.getName());


        listingService.delete(u, listingid);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
