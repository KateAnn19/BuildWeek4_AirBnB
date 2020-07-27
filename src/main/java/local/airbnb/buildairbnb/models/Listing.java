package local.airbnb.buildairbnb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "listing")
@JsonIgnoreProperties(value = "hasvalueforaccomodates, hasvalueforbathrooms, hasvalueforlatitude" +
    "hasvalueforlongitude, hasvalueforreviewscore, hasvalueforzipcode, hasvalueforbedrooms, hasvalueforbeds, hasvaluefordescriptionlen", ignoreUnknown = true)
public class Listing extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long listingid;

//        "property_type": "string",
    private String propertytype;
//         "room_type": "string",
    private String roomtype;
//         "accomodates": 0,
    private int accomodates;
//         "bathrooms": 0,
    private int bathrooms;
//         "clean_fee": true,
    private boolean cleanfee = false;
//         "city": "string",
    private String city;
//         "latitude": 0,
    private int latitude;
//         "longitude": 0,
    private int longitude;
//         "review_scores_rating": 0,
    private int reviewscoresrating;
//         "zipcode": 0,
    private long zipcode;
//         "bedrooms": 0,
    private int bedrooms;
//         "beds": 0,
    private int beds;
//         "Dryer": true,
    private boolean dryer = false;
//         "Parking": true,
    private boolean parking = false;
//         "Description_Len": 0
    private long descriptionlen;

    private String price = "click for price";

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
    public boolean hasvaluefordescriptionlen = false;


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
        String propertytype,
        String roomtype,
        int accomodates,
        int bathrooms,
        boolean cleanfee,
        String city,
        int latitude,
        int longitude,
        int reviewscoresrating,
        long zipcode,
        int bedrooms,
        int beds,
        boolean dryer,
        boolean parking,
        long descriptionlen,
        String price,
        User user)
    {
        this.propertytype = propertytype;
        this.roomtype = roomtype;
        this.accomodates = accomodates;
        this.bathrooms = bathrooms;
        this.cleanfee = cleanfee;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.reviewscoresrating = reviewscoresrating;
        this.zipcode = zipcode;
        this.bedrooms = bedrooms;
        this.beds = beds;
        this.dryer = dryer;
        this.parking = parking;
        this.descriptionlen = descriptionlen;
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

    public String getPropertytype()
    {
        return propertytype;
    }

    public void setPropertytype(String propertytype)
    {
        this.propertytype = propertytype;
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

    public boolean isCleanfee()
    {
        return cleanfee;
    }

    public void setCleanfee(boolean cleanfee)
    {
        this.cleanfee = cleanfee;
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

    public long getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(long zipcode)
    {
        hasvalueforzipcode = true;
        this.zipcode = zipcode;
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

    public boolean isDryer()
    {
        return dryer;
    }

    public void setDryer(boolean dryer)
    {
        this.dryer = dryer;
    }

    public boolean isParking()
    {
        return parking;
    }

    public void setParking(boolean parking)
    {
        this.parking = parking;
    }

    public long getdescriptionlen()
    {
        return descriptionlen;
    }

    public void setdescriptionlen(long descriptionlen)
    {
        hasvaluefordescriptionlen = true;
        this.descriptionlen = descriptionlen;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }


    @Override
    public String toString()
    {
        return "Listing{" +
            "listingid=" + listingid +
            ", propertytype='" + propertytype + '\'' +
            ", roomtype='" + roomtype + '\'' +
            ", accomodates=" + accomodates +
            ", bathrooms=" + bathrooms +
            ", cleanfee=" + cleanfee +
            ", city='" + city + '\'' +
            ", latitude=" + latitude +
            ", longitude=" + longitude +
            ", reviewscoresrating=" + reviewscoresrating +
            ", zipcode=" + zipcode +
            ", bedrooms=" + bedrooms +
            ", beds=" + beds +
            ", dryer=" + dryer +
            ", parking=" + parking +
            ", descriptionlen=" + descriptionlen +
            ", user=" + user +
            '}';
    }
}
