package pl.wind.humpback.app.scopesample;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Scope("dialog")
public class Address {

    private String city;

    public Address() {
        System.out.println("################ Address constructor");
    }

    /**
     * @return the city
     */
    protected String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    protected void setCity(String city) {
        this.city = city;
    }
}
