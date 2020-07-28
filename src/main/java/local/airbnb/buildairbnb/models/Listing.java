package local.airbnb.buildairbnb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "listing")
@JsonIgnoreProperties(value = {"hasvalueforaccomodates", "hasvalueforbathrooms", "hasvalueforlatitude", "hasvalueforlongitude", "hasvalueforreviewscore", "hasvalueforzipcode", "hasvalueforbedrooms", "hasvalueforbeds", "hasvaluefortv"}, ignoreUnknown = true)
public class Listing extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long listingid;


//         "room_type": "string",
    private String roomtype;
//         "accomodates": 0,
    private int accomodates;
//         "bathrooms": 0,
    private int bathrooms;

//         "city": "string",
    private String city;
//         "latitude": 0,
    private int latitude;
//         "longitude": 0,
    private int longitude;
//         "review_scores_rating": 0,
    private int reviewscoresrating;
    //         "bedrooms": 0,
    private int bedrooms;
    //         "beds": 0,
    private int beds;
    private int tv;
    private String streetaddress;
    //         "zipcode": 0,
    private long zipcode;

    private String price = "click for price"; //double

    @Transient
    public boolean hasvalueforaccomodates = false;

    @Transient
    public boolean hasvalueforbathrooms = false;

    @Transient
    public boolean hasvalueforlatitude = false;

    @Transient
    public boolean hasvalueforlongitude = false;

    @Transient
    public boolean hasvalueforreviewscore = false;


    @Transient
    public boolean hasvalueforzipcode = false;

    @Transient
    public boolean hasvalueforbedrooms = false;

    @Transient
    public boolean hasvalueforbeds = false;

    @Transient
    public boolean hasvaluefortv = false;


    @ManyToOne
    @JoinColumn(name = "userid", nullable = false) //this adds a foreign key to telephone // zooid is the field in zoo
    @JsonIgnoreProperties(value = "list", allowSetters = true) //fields inside user
    private User user; //single user it relates to

//    @OneToOne
//    @JoinColumn(name = "listingid", nullable = false) //this adds a foreign key to telephone // zooid is the field in zoo
//    @JsonIgnoreProperties(value = "list", allowSetters = true) //fields inside user
//    private OptimalPrice price; //single user it relates to

    public Listing()
    {
    }

    public Listing(
        String roomtype,
        int accomodates,
        int bathrooms,
        String city,
        int latitude,
        int longitude,
        int reviewscoresrating,
        int bedrooms,
        int beds,
        int tv,
        String streetaddress,
        long zipcode,
        String price,
        User user)
    {
        this.listingid = listingid;
        this.roomtype = roomtype;
        this.accomodates = accomodates;
        this.bathrooms = bathrooms;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.reviewscoresrating = reviewscoresrating;
        this.bedrooms = bedrooms;
        this.beds = beds;
        this.tv = tv;
        this.streetaddress = streetaddress;
        this.zipcode = zipcode;
        this.price = price;
        this.user = user;
    }

    public long getListingid()
    {
        return listingid;
    }

    public void setListingid(long listingid)
    {
        this.listingid = listingid;
    }

    public String getRoomtype()
    {
        return roomtype;
    }

    public void setRoomtype(String roomtype)
    {
        this.roomtype = roomtype;
    }

    public int getAccomodates()
    {
        return accomodates;
    }

    public void setAccomodates(int accomodates)
    {
        hasvalueforaccomodates = true;
        this.accomodates = accomodates;
    }

    public int getBathrooms()
    {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms)
    {
        hasvalueforbathrooms = true;
        this.bathrooms = bathrooms;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public int getLatitude()
    {
        return latitude;
    }

    public void setLatitude(int latitude)
    {
        hasvalueforlatitude = true;
        this.latitude = latitude;
    }

    public int getLongitude()
    {
        return longitude;
    }

    public void setLongitude(int longitude)
    {
        hasvalueforlongitude = true;
        this.longitude = longitude;
    }

    public int getReviewscoresrating()
    {
        return reviewscoresrating;
    }

    public void setReviewscoresrating(int reviewscoresrating)
    {
        hasvalueforreviewscore = true;
        this.reviewscoresrating = reviewscoresrating;
    }

    public int getBedrooms()
    {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms)
    {
        hasvalueforbedrooms = true;
        this.bedrooms = bedrooms;
    }

    public int getBeds()
    {
        return beds;
    }

    public void setBeds(int beds)
    {
        hasvalueforbeds = true;
        this.beds = beds;
    }

    public int getTv()
    {

        return tv;
    }

    public void setTv(int tv)
    {
        hasvaluefortv=true;
        this.tv = tv;
    }

    public String getStreetaddress()
    {
        return streetaddress;
    }

    public void setStreetaddress(String streetaddress)
    {
        this.streetaddress = streetaddress;
    }

    public long getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(long zipcode)
    {
        hasvalueforzipcode = true;
        this.zipcode = zipcode;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

}
