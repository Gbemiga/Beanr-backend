package entity;


import javax.persistence.*;
import java.util.Date;


@NamedQueries( {
		@NamedQuery(name = "Review.findAll", query = "select r from Review r"),
		@NamedQuery(name = "Review.findByBusiness", query = "select r from Review r where r.business=:business"),
		@NamedQuery(name = "Review.findByUser", query = "select r from Review r where r.customer=:customer"),
})

@Entity
public class Review {

	//every entity requires an id, and we can make it auto generated
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

    @ManyToOne
	private Customer customer;

    @ManyToOne
	private Business business;

    private String comment;
	private Date date;

	public Review(){

	}

    public Review(Customer customer, Business business, String comment, Date date) {
        this.customer = customer;
        this.business = business;
        this.comment = comment;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", customer=" + customer +
                ", business=" + business +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
