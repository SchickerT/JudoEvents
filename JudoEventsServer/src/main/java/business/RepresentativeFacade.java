package business;

import entity.Representative;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Stateless
public class RepresentativeFacade {
    @PersistenceContext
    private EntityManager em;

    public Representative findById(long id) {return em.find(Representative.class,id);}

    public List<Representative> findAll(){ return em.createNamedQuery("Representative.findAll",Representative.class).getResultList();}

    public Representative save(Representative representative){ return this.em.merge(representative);}

    public void delete(long id){
        Representative reference = this.em.getReference(Representative.class,id);
        this.em.remove(reference);
    }
}
