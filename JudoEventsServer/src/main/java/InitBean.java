import business.*;
import entity.Participation;
import entity.Representative;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Created by marcelpautz on 20.07.17.
 */
@Startup
@Singleton
public class InitBean {

    @Inject
    private ClubFacade clubFacade;

    @Inject
    private EventFacade eventFacade;

    @Inject
    private LocationFacade locationFacade;

    @Inject
    private ParticipationFacade participationFacade;

    @Inject
    private RepresentativeFacade representativeFacade;

    @PostConstruct
    private void init(){

    }
}
