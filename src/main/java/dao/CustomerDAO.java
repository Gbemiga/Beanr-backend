package dao;

import entity.Customer;
import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerDAO {

	public List<Customer> findAll(){
        EntityManager em = PersistenceUtil.createEM();
        List<Customer> users = (List<Customer>)
                em.createNamedQuery("Customer.findAll").getResultList();
        em.close();
       return users;
	}

	public void createCustomer(Customer customer){
		PersistenceUtil.persist(customer);
	}

    public Customer findUserByUsername(String username){
        EntityManager em = PersistenceUtil.createEM();
        List<Customer> customers = (List<Customer>)
                em.createNamedQuery("Customer.findByUsername").
                        setParameter("username", username).getResultList();
        em.close();

        if (customers.size() == 0)
            return null;
        else
            return customers.get(0);
    }

    public Customer findUserByUsernameAndPassword(String username, String password){
        EntityManager em = PersistenceUtil.createEM();
        List<Customer> customers = (List<Customer>)
                em.createNamedQuery("Customer.findByUsernameAndPassword").
                        setParameter("username", username).
                        setParameter("password", password).getResultList();
        em.close();

        if (customers.size() == 0)
            return null;
        else
            return customers.get(0);
    }

}