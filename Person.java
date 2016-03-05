package pl.wind.humpback.app.scopesample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Scope("dialog")
public class Person {

    @Autowired
    private Address address;

    public Person() {
        System.out.println("################ Person constructor");
    }

    public String descibe() {
        return getAddress() + " - " + getAddress().getCity();
    }

    /**
     * @return the address
     */
    protected Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    protected void setAddress(Address address) {
        this.address = address;
    }

}
