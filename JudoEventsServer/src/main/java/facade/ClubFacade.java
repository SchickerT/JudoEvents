package facade;

import entity.Club;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Stateless
public class ClubFacade {
    @PersistenceContext
    private EntityManager em;

    public void create(Club club){em.persist(club);}

    public Club findById(long id) {return em.find(Club.class,id);}

    public Club update(Club club){ return this.em.merge(club);}

    public void delete(long id){
        Club entity = this.em.find(Club.class,id);
        if(entity!=null)
        this.em.remove(entity);
    }

    public List<Club> findAll() {
        return findAll(null, null);
    }

    public List<Club> findAll(Integer startPosition, Integer maxResult) {
        TypedQuery<Club> findAllQuery = em
                .createNamedQuery("Club.findAll", Club.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
}
