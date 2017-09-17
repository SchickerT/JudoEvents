package rest;



import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by marcelpautz on 14.09.17.
 */

@ApplicationPath("rs")
public class RestConfig extends Application{

    public RestConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("JudoEventsServer");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/judoEventsServer/rs");
        beanConfig.setResourcePackage("rest");
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);
    }

    @Override
    public Set<Class<?>> getClasses()
    {
        HashSet<Class<?>> set = new HashSet<>();

        set.add(CrossOriginResourceSharingFilter.class);
        set.add(RestConfig.class);
        set.add(ClubResource.class);
        set.add(EventResource.class);
        set.add(LocationResource.class);
        set.add(ParticipationResource.class);
        set.add(RepresentativeResource.class);


        set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return set;
    }
}
