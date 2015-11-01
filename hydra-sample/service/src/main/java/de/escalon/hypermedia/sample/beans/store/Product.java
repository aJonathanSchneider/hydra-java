package de.escalon.hypermedia.sample.beans.store;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dietrich on 17.02.2015.
 */
public class Product extends ResourceSupport {
    public final String name;

    public final String productID;

    public List<Product> accessories = new ArrayList<Product>();

    public Offer getOffers() {
        return offer;
    }

    private Offer offer;

    @JsonCreator
    public Product(@JsonProperty("name") String name, @JsonProperty("productID") String productID) {
        this.name = name;
        this.productID = productID;
    }

    public void addOffer(Offer offer) {
        this.offer = offer;
    }

    public boolean hasExtra(String accessoryId) {
        boolean ret = false;
        for (Product accessory : accessories) {
            if (accessory.productID.equals(accessoryId)) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    public void addAccessory(Product product) {
        this.accessories.add(product);
    }
}
