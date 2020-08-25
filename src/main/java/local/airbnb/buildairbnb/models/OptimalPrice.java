package local.airbnb.buildairbnb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
//pojo

@JsonIgnoreProperties(ignoreUnknown = true)
public class OptimalPrice
{
    ///@ElementCollection
    //@CollectionTable(name = "optimalprice")
    //@Column(name ="price")
    private String Prices;

    //@OneToOne
    //@OneToOne
//    @JoinColumn(name = "listingid", nullable = false) //this adds a foreign key to telephone // zooid is the field in zoo
//    @JsonIgnoreProperties(value = "price", allowSetters = true) //fields inside user
//    private Listing list; //single user it relates to

    public OptimalPrice()
    {
    }


    public OptimalPrice(String prices)
    {
        Prices = prices;
    }

    public String getPrices()
    {
        return Prices;
    }

    public void setPrices(String prices)
    {
        Prices = prices;
    }
}
