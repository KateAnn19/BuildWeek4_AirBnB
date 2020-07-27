package local.airbnb.buildairbnb.controllers;

import local.airbnb.buildairbnb.models.Listing;
import local.airbnb.buildairbnb.models.OptimalPrice;
import local.airbnb.buildairbnb.models.User;
import local.airbnb.buildairbnb.models.Useremail;
import local.airbnb.buildairbnb.services.ListingService;
import local.airbnb.buildairbnb.services.UserService;
import local.airbnb.buildairbnb.services.UseremailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
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
//request from DS

        RestTemplate restTemplate = new RestTemplate();

        System.out.println("THIS IS THE LIST " + newListing);

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);


        System.out.println("Reached this spot");

        String reqUrl = "https://testapifortesting.herokuapp.com/predict";

        System.out.println("made the request");
        ParameterizedTypeReference<OptimalPrice> responseType = new ParameterizedTypeReference<>() {
        };

        HttpEntity<Listing> requestEntity = new HttpEntity<>(newListing);

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

        //listingService.savePrice(list, stringPrice);
        newListing.setPrice(stringPrice);

        //request from DS
        listingService.saveByAuth(u, newListing, stringPrice);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PatchMapping(value = "/listing/{listingid}", consumes = {"application/json"}) public ResponseEntity<?>
    updateListing(Authentication authentication, @RequestBody
            Listing updateListing,
        @PathVariable
            long listingid)
    {
        User u = userService.findByName(authentication.getName());

      //ds endpoint


        //ds endpoint
        listingService.update(u, updateListing,
            listingid);
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
