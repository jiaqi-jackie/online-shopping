package onlineShop2.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "salesOrder")
public class SalesOrder implements Serializable {

    private static final long serialVersionUID = -6571020025726257848L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private onlineShop2.entity.ShippingAddress shippingAddress;

    @ManyToOne
    private BillingAddress billingAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public onlineShop2.entity.ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(onlineShop2.entity.ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }
}
