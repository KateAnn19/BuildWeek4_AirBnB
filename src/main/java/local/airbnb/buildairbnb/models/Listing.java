package local.airbnb.buildairbnb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "listing")
public class Listing extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long listingid;

//     "property_type": "apartment",
//         "room_type": "string",
//         "accomodates": 1,
//         "bathrooms": 0,
//         "clean_fee": true,
//         "city": "string",
//         "latitude": 0,
//         "longitude": 0,
//         "review_scores_rating": 0,
//         "zipcode": 34882,
//         "bedrooms": 0,
//         "beds": 0,
//         "Dryer": true,
//         "Parking": true,
//         "Description_Len": 0

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
    private long descriptionLen;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false) //this adds a foreign key to telephone // zooid is the field in zoo
    @JsonIgnoreProperties(value = "listing", allowSetters = true) //fields inside user
    private User user; //single user it relates to

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
        long descriptionLen,
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
        this.descriptionLen = descriptionLen;
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
        this.accomodates = accomodates;
    }

    public int getBathrooms()
    {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms)
    {
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
        this.latitude = latitude;
    }

    public int getLongitude()
    {
        return longitude;
    }

    public void setLongitude(int longitude)
    {
        this.longitude = longitude;
    }

    public int getReviewscoresrating()
    {
        return reviewscoresrating;
    }

    public void setReviewscoresrating(int reviewscoresrating)
    {
        this.reviewscoresrating = reviewscoresrating;
    }

    public long getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(long zipcode)
    {
        this.zipcode = zipcode;
    }

    public int getBedrooms()
    {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms)
    {
        this.bedrooms = bedrooms;
    }

    public int getBeds()
    {
        return beds;
    }

    public void setBeds(int beds)
    {
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

    public long getDescriptionLen()
    {
        return descriptionLen;
    }

    public void setDescriptionLen(long descriptionLen)
    {
        this.descriptionLen = descriptionLen;
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
