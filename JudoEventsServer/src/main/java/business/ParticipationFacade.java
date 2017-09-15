package business;

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

    public Participation findById(long id) {return em.find(Participation.class,id);}

    public List<Participation> findAll(){ return em.createNamedQuery("Participation.findAll",Participation.class).getResultList();}

    public Participation save(Participation participation){ return this.em.merge(participation);}

    public void delete(long id){
        Participation reference = this.em.getReference(Participation.class,id);
        this.em.remove(reference);
    }
}
