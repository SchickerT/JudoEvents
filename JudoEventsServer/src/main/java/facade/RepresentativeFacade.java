package facade;

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

    public void create(Representative representative){em.persist(representative);}

    public Representative findById(long id) {return em.find(Representative.class,id);}

    public List<Representative> findAll(){ return em.createNamedQuery("Representative.findAll",Representative.class).getResultList();}

    public Representative update(Representative representative){ return this.em.merge(representative);}

    public void delete(long id){
        Representative entity = this.em.find(Representative.class,id);
        if(entity!=null)
            this.em.remove(entity);
    }
}
