package ie.gmit.open;
/*

easy to understand class
 */
import java.util.List;

public abstract class Subscriber { //You cant create an instance of this. Closed for modification.
    protected Long subscriberId;

    protected String address;

    protected Long phoneNumber;



    public Long getSubscriberId() {
        return subscriberId;
    }


    public void setSubscriberId(Long subscriberId) {

        this.subscriberId = subscriberId;
    }


    public String getAddress()
    {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public Long getPhoneNumber() {

        return phoneNumber;
    }


    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //Name of the method calculate Bill. Open for change.
    public abstract double calculateBill(); //extension




}

