package business;

import entity.Location;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Stateless
public class LocationFacade {
    @PersistenceContext
    private EntityManager em;

    public Location findById(long id) {return em.find(Location.class,id);}

    public List<Location> findAll(){ return em.createNamedQuery("Location.findAll",Location.class).getResultList();}

    public Location save(Location location){ return this.em.merge(location);}

    public void delete(long id){
        Location reference = this.em.getReference(Location.class,id);
        this.em.remove(reference);
    }
}
