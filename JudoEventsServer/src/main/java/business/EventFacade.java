package business;

import entity.Event;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Stateless
public class EventFacade {
    @PersistenceContext
    private EntityManager em;

    public Event findById(long id) {return em.find(Event.class,id);}

    public List<Event> findAll(){ return em.createNamedQuery("Event.findAll",Event.class).getResultList();}

    public Event save(Event event){ return this.em.merge(event);}

    public void delete(long id){
        Event reference = this.em.getReference(Event.class,id);
        this.em.remove(reference);
    }
}
