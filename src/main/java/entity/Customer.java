package entity;


import javax.persistence.*;
import javax.xml.bind.annotation.*;


@NamedQueries( {
        @NamedQuery(name = "Customer.findAll", query = "select c from Customer c"),
        @NamedQuery(name = "Customer.findByUsername", query = "select c from Customer c where c.username=:username"),
        @NamedQuery(name = "Customer.findByUsernameAndPassword", query = "select c from Customer c where c.username=:username and c.password=:password"),
})

@XmlRootElement
@Entity
public class Customer {

	//every entity requires an id, and we can make it auto generated
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

	private String username;
	private String password;
	private String email;
	private String gender;

	public Customer(){

	}

	public Customer(String username, String password, String email, String gender) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
	}

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}