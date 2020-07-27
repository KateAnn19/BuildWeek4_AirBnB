package local.airbnb.buildairbnb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
//@Entity(name="optimalprice")
public class OptimalPrice
{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long optiomalpriceid;

    //@ElementCollection
    //@CollectionTable(name = "optimalprice")
    //@Column(name ="price")
    private String Prices;

    //@OneToOne
   // @OneToOne
   // @JoinColumn(name = "listingid", nullable = false) //this adds a foreign key to telephone // zooid is the field in zoo
    //@JsonIgnoreProperties(value = "price", allowSetters = true) //fields inside user
    //private Listing list; //single user it relates to

//    public OptimalPrice()
//    {
//    }
//
//    public long getOptiomalpriceid()
//    {
//        return optiomalpriceid;
//    }
//
//    public void setOptiomalpriceid(long optiomalpriceid)
//    {
//        this.optiomalpriceid = optiomalpriceid;
//    }
//
//    public float getPrices()
//    {
//        return Prices;
//    }
//
//    public void setPrices(float prices)
//    {
//        Prices = prices;
//    }


    public String getPrices()
    {
        return Prices;
    }

    public void setPrices(String prices)
    {
        Prices = prices;
    }

    @Override
    public String toString()
    {
        return "OptimalPrice{" +
            "Prices='" + Prices + '\'' +
            '}';
    }
}
