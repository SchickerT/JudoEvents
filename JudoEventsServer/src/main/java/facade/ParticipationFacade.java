package facade;

import entity.Participation;

import javax.ejb.Stateless;
import javax.mail.Part;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Stateless
public class ParticipationFacade {
    @PersistenceContext
    private EntityManager em;

    public void create(Participation participation) {
        em.persist(participation);
    }

    public Participation findById(long id) {
        return em.find(Participation.class, id);
    }

    public List<Participation> findAll() {
        return em.createNamedQuery("Participation.findAll", Participation.class).getResultList();
    }

    public Participation update(Participation participation) {
        return this.em.merge(participation);
    }

    public void delete(long id) {
        Participation entity = this.em.find(Participation.class, id);
        if (entity != null)
            this.em.remove(entity);
    }
}
