package RestAPI;

import dao.BusinessDAO;
import entity.Business;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class BusinessAPI {

    private BusinessDAO businessDAO = new BusinessDAO();

    @GET
    @Path(value="/getAllBusinesses")
    @Produces(value={"application/json"})
    public List<Business> getAllBusinesses() {
        List<Business> businesses = new ArrayList<>(businessDAO.findAll());
        return businesses;
    }
}