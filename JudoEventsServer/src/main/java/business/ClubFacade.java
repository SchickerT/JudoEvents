package business;

import entity.Club;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Stateless
public class ClubFacade {
    @PersistenceContext
    private EntityManager em;

    public Club findById(long id) {return em.find(Club.class,id);}

    public List<Club> findAll(){ return em.createNamedQuery("Club.findAll",Club.class).getResultList();}

    public Club save(Club club){ return this.em.merge(club);}

    public void delete(long id){
        Club reference = this.em.getReference(Club.class,id);
        this.em.remove(reference);
    }
}
