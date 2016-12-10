package RestAPI;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CustomerDAO;
import entity.Customer;
import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api")
public class CustomerAPI {

    private CustomerDAO customerDAO = new CustomerDAO();

    @GET
    @Path(value="/getAllCustomers")
    @Produces(value={"application/json"})
    public List<Customer> getAllUsers() {
        EntityManager em = PersistenceUtil.createEM();
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = new ArrayList<>(customerDAO.findAll());
        return customers;
    }

    @POST
    @Path(value="/createCustomer")
    public String createCustomer(String customerJson) {

        System.out.println("Ive been hit");
        System.out.println(customerJson);
        System.out.println("After printing report");

        Map<String, String> map = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(customerJson, new TypeReference<HashMap<String, String>>() {
            });
            createCustomerMap(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DONE";
    }

    @POST
    @Path(value="/getCustomer")
    @Produces(value={"application/json"})
    public ArrayList<Customer> getCustomer(String customerJson){

        System.out.println("Ive been hit");
        System.out.println(customerJson);
        System.out.println("After printing report");

        ArrayList<Customer> loginCustomer= new ArrayList<Customer>();
        Map<String, String> map = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(customerJson, new TypeReference<HashMap<String, String>>() {
            });
            String username = (String) map.get("username");
            String password = (String) map.get("password");
            Customer customer = customerDAO.findUserByUsernameAndPassword(username, password);
            if(customer != null){
                System.out.println(customer.toString());
                loginCustomer.add(customer);
                return loginCustomer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginCustomer;
    }

    private void createCustomerMap(Map<String, String> map) {

        String username = (String) map.get("username");
        String email = (String) map.get("email");
        String password = (String) map.get("password");
        String gender = (String) map.get("gender");
        Customer newCustomer = new Customer();
        newCustomer.setEmail(email);
        newCustomer.setGender(gender);
        newCustomer.setUsername(username);
        newCustomer.setPassword(password);
        if (newCustomer != null) {
            customerDAO.createCustomer(newCustomer);
        }
    }
}