package local.airbnb.buildairbnb.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;
import local.airbnb.buildairbnb.models.Listing;
import local.airbnb.buildairbnb.models.OptimalPrice;
import local.airbnb.buildairbnb.repository.ListingRepository;
import local.airbnb.buildairbnb.repository.OptimalPriceRepository;
import local.airbnb.buildairbnb.services.ListingService;
//import local.airbnb.buildairbnb.services.OptimalPriceService;
import local.airbnb.buildairbnb.services.OptimalPriceService;
import local.airbnb.buildairbnb.services.UserService;
import org.codehaus.jackson.map.DeserializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.schema.Entry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/req")
public class ReqController
{
    @Autowired
    private ListingService listingService;

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private OptimalPriceService optimalpriceService;

    @Autowired
    private OptimalPriceRepository optimalPriceRepository;

//    @Autowired
//    private OptimalPriceService optimalPriceService;

    @GetMapping(value = "/test", produces = {"application/json"})
    public ResponseEntity<?> newReq()
    {
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters()
            .add(converter);

        String reqUrl = "https://testapifortesting.herokuapp.com/";

        ParameterizedTypeReference<List<Listing>> responseType = new ParameterizedTypeReference<>()
        {
        };

        ResponseEntity<List<Listing>> responseEntity = restTemplate.exchange(reqUrl,
            HttpMethod.GET,
            null,
            responseType);
        List<Listing> myList = responseEntity.getBody();

        return new ResponseEntity<>(myList,
            HttpStatus.OK);
    }


    //testing
    @PostMapping(value = "/new", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<?> newCustomReq(@RequestBody Listing list)
    {
        RestTemplate restTemplate = new RestTemplate();


        System.out.println("THIS IS THE LIST " + list);

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters().add(converter);


        System.out.println("Reached this spot");

        String reqUrl = "https://testapifortesting.herokuapp.com/predict";

        System.out.println("made the request");
        ParameterizedTypeReference<OptimalPrice> responseType = new ParameterizedTypeReference<>() {
        };

        HttpEntity<Listing> requestEntity = new HttpEntity<>(list);

        ResponseEntity<OptimalPrice> responseEntity = restTemplate.exchange(reqUrl, HttpMethod.POST, requestEntity, responseType);


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

        listingService.savePrice(list, stringPrice);

        return new ResponseEntity<>(price, HttpStatus.OK);
    }
}
