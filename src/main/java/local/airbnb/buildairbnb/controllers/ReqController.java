package local.airbnb.buildairbnb.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import local.airbnb.buildairbnb.models.Listing;
import local.airbnb.buildairbnb.models.OptimalPrice;
import local.airbnb.buildairbnb.services.ListingService;
//import local.airbnb.buildairbnb.services.OptimalPriceService;
import local.airbnb.buildairbnb.services.UserService;
import org.codehaus.jackson.map.DeserializationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/req")
public class ReqController
{
    @Autowired
    private ListingService listingService;

    @Autowired
    private UserService userService;

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

        System.out.println(price);



        System.out.println("This is response entity " + responseEntity);
        System.out.println(price);

        return new ResponseEntity<>(price, HttpStatus.OK);
    }
}
