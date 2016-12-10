package dao;

import entity.Business;
import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class BusinessDAO {

	public List<Business> findAll(){
        EntityManager em = PersistenceUtil.createEM();
        List<Business> businesses = (List<Business>)
                em.createNamedQuery("Business.findAll").getResultList();
        em.close();
       return businesses;
	}


}