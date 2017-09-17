package facade;

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

    public void create(Location location){em.persist(location);}

    public Location findById(long id) {return em.find(Location.class,id);}

    public List<Location> findAll(){ return em.createNamedQuery("Location.findAll",Location.class).getResultList();}

    public Location update(Location location){ return this.em.merge(location);}

    public void delete(long id){
        Location entity = this.em.find(Location.class,id);
        if(entity!=null)
            this.em.remove(entity);
    }
}
