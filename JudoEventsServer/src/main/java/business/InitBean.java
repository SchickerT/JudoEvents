package business;

import entity.*;
import entity.enums.TypeOfEvent;
import facade.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

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

    public InitBean() {

    }

    @PostConstruct
    private void init() throws FileNotFoundException {
        File file = new File("/Users/marcelpautz/Documents/JudoEvents/JudoEventsServer/img/trainer.jpg");
        byte[] picInBytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            fileInputStream.read(picInBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Representative representativeOne = new Representative("Peter","Scharinger","peter.scharinger@ujz.at","06652213245");
        representativeOne.setRepresentativePicture(picInBytes);
        Club clubOne = new Club("UJZ Mühlviertel","Upper-Austrian Traditional Club","ujz@gmail.com","hallo123",representativeOne,new Location("4020","Linz","Landwiedstraße.5","Upperaustria","Austria",0.0,0.0,"flag-icon-at"));
        clubOne.setClubPicture(picInBytes);

        clubFacade.create(clubOne);

        /*clubFacade.create(new Club("Union Flachgau","Salzburg Traditional Club","http://lorempixel.com/400/400/sports/","flachgaujudo@gmail.com","hallo123",new Representative("Ludwig","Paischer","Ludwig.Paischer@flachgau.at","06761234567","http://lorempixel.com/200/250/people/"),new Location("5020","Salzburg","Volksstraße.8","Salzburg","Austria")));

        clubFacade.create(new Club("Samurai Wien","Vienna Traditional Club","http://lorempixel.com/400/400/sports/","samurai@gmail.com","hallo123",new Representative("Hilde","Drexler","hilde.drexler@samurai.at","06641513245","http://lorempixel.com/200/250/people/"),new Location("1010","Wien","Ringstraße.12","Vienna","Austria")));

        clubFacade.create(new Club("LZK Brno","Czech Traditional Club","http://lorempixel.com/400/400/sports/","czech@judo.com","hallo123",new Representative("Josip","Novak","josip.novak@lzk.at","0023452213245"),new Location("12000","Bron","Liskastra.122","Soutczech","Czech Republic",0.0,0.0,"flag-icon-cz")));

        clubFacade.create(new Club("Legia Warsauw","Polska Traditional Club","http://lorempixel.com/400/400/sports/","polska@gmail.com","hallo123",new Representative("Jaromir","Januz","jarumir.januz@legia.at","124452213245","http://lorempixel.com/200/250/people/"),new Location("52111","Warsauw","Poskaskada.155","Centralpoland","Poland")));

        clubFacade.create(new Club("All Nippon","Japanese Club","http://lorempixel.com/400/400/sports/","nippon@gmail.com","hallo123",new Representative("Nigiru","Abe","nigiru.abe@nippon.jp","124452213245","http://lorempixel.com/200/250/people/"),new Location("43122","Tokyo","Shibuya.155","Tokyo","Japan")));
        */


       eventFacade.create(new Event(LocalDate.of(2019, 1, 1),LocalDate.of(2019, 1, 11), TypeOfEvent.Turnament,"OTC Nymbuk 2016","Olympic Trainings Camp",35.50,"","U18 and above",clubFacade.findById(1).getLocation(),clubFacade.findById(1),clubFacade.findById(1).getRepresentative()));
//
//        eventFacade.create(new Event(LocalDate.of(2017, 1, 1),LocalDate.of(2017, 1, 11), TypeOfEvent.Trainingscamp,"OTC Nymbuk 2017","Olympic Trainings Camp",40.55,"","U18 and Above","http://lorempixel.com/400/300/sports/",clubFacade.findById(4).getLocation(),clubFacade.findById(4),clubFacade.findById(4).getRepresentative()));
//
//        eventFacade.create(new Event(LocalDate.of(2016, 12, 1),LocalDate.of(2016, 12, 10), TypeOfEvent.Trainingscamp,"OTC Mittersill 2016","Olympic Trainings Camp",45.55,"","U18 and Above","http://lorempixel.com/400/300/sports/",clubFacade.findById(2).getLocation(),clubFacade.findById(2),clubFacade.findById(2).getRepresentative()));
//
//        eventFacade.create(new Event(LocalDate.of(2017, 12, 1),LocalDate.of(2017, 12, 10), TypeOfEvent.Trainingscamp,"OTC Mittersill 2017","Olympic Trainings Camp",49.55,"","U18 and Above","http://lorempixel.com/400/300/sports/",clubFacade.findById(2).getLocation(),clubFacade.findById(2),clubFacade.findById(2).getRepresentative()));
//
//        eventFacade.create(new Event(LocalDate.of(2017, 4, 12),LocalDate.of(2017, 4, 17), TypeOfEvent.Trainingscamp,"TC Rohrbach","Trainings Camp Kids",100.00,"","U12 to U18","http://lorempixel.com/400/300/sports/",clubFacade.findById(1).getLocation(),clubFacade.findById(1),clubFacade.findById(1).getRepresentative()));
//
//        eventFacade.create(new Event(LocalDate.of(2018, 4, 12),LocalDate.of(2018, 4, 17), TypeOfEvent.Trainingscamp,"TC Rohrbach","Trainings Camp Kids",120.00,"","U12 to U18","http://lorempixel.com/400/300/sports/",clubFacade.findById(1).getLocation(),clubFacade.findById(1),clubFacade.findById(1).getRepresentative()));
//
//        eventFacade.create(new Event(LocalDate.of(2019, 4, 12),LocalDate.of(2019, 4, 17), TypeOfEvent.Trainingscamp,"TC Rohrbach","Trainings Camp Kids",100.00,"","U12 to U18","http://lorempixel.com/400/300/sports/",clubFacade.findById(1).getLocation(),clubFacade.findById(1),clubFacade.findById(1).getRepresentative()));




//        eventFacade.create(new Event(LocalDate.of(2017, 5, 1),LocalDate.of(2017, 5, 3), TypeOfEvent.Turnament,"Grand Prix Prag","Grand Prix Prag",35.50,"Medals and Trophys","M-60;M-66;M-73;M-81;M-90;M-100;M+100;","http://lorempixel.com/400/300/sports/",clubFacade.findById(4).getLocation(),clubFacade.findById(4),clubFacade.findById(4).getRepresentative(),"flag-icon-cz"));
//
//        eventFacade.create(new Event(LocalDate.of(2018, 5, 1),LocalDate.of(2018, 5, 3), TypeOfEvent.Turnament,"Grand Prix Prag","Grand Prix Prag",35.50,"Medals and Trophys","M-60;M-66;M-73;M-81;M-90;M-100;M+100;","http://lorempixel.com/400/300/sports/",clubFacade.findById(4).getLocation(),clubFacade.findById(4),clubFacade.findById(4).getRepresentative(),"flag-icon-cz"));
//
//        eventFacade.create(new Event(LocalDate.of(2017, 5, 1),LocalDate.of(2017, 5, 3), TypeOfEvent.Turnament,"Grand Prix Warsaw","Grand Prix Warsaw",35.50,"Medals and Trophys","W-48;W-52;W-57;W-63;W-70;W-78;W+78;","http://lorempixel.com/400/300/sports/",clubFacade.findById(5).getLocation(),clubFacade.findById(5),clubFacade.findById(5).getRepresentative(),"flag-icon-pl"));
//
//        eventFacade.create(new Event(LocalDate.of(2018, 5, 1),LocalDate.of(2018, 5, 3), TypeOfEvent.Turnament,"Grand Prix Warsaw","Grand Prix Warsaw",35.50,"Medals and Trophys","W-48;W-52;W-57;W-63;W-70;W-78;W+78;;","http://lorempixel.com/400/300/sports/",clubFacade.findById(5).getLocation(),clubFacade.findById(5),clubFacade.findById(5).getRepresentative(),"flag-icon-pl"));
//
//        eventFacade.create(new Event(LocalDate.of(2017, 2, 12),LocalDate.of(2017, 2, 13), TypeOfEvent.Turnament,"International Turnament Rohrbach","IT Rohrbach",10.50,"Medals","M-60;M-66;M-73;M-81;M-90;M-100;M+100;","http://lorempixel.com/400/300/sports/",clubFacade.findById(1).getLocation(),clubFacade.findById(1),clubFacade.findById(1).getRepresentative(),"flag-icon-at"));
//
//        eventFacade.create(new Event(LocalDate.of(2018, 2, 12),LocalDate.of(2018, 2, 13), TypeOfEvent.Turnament,"International Turnament Rohrbach","IT Rohrbach",10.50,"Medals","M-60;M-66;M-73;M-81;M-90;M-100;M+100;","http://lorempixel.com/400/300/sports/",clubFacade.findById(1).getLocation(),clubFacade.findById(1),clubFacade.findById(1).getRepresentative(),"flag-icon-at"));
//
//        eventFacade.create(new Event(LocalDate.of(2017, 10, 19),LocalDate.of(2017, 10, 20), TypeOfEvent.Turnament,"All Japanes Open","Japanese Open",10.50,"Medals","M-60;M-66;M-73;M-81;M-90;M-100;M+100;","http://lorempixel.com/400/300/sports/",clubFacade.findById(6).getLocation(),clubFacade.findById(6),clubFacade.findById(6).getRepresentative(),"flag-icon-jp"));
//
//        eventFacade.create(new Event(LocalDate.of(2018, 10, 20),LocalDate.of(2018, 10, 21), TypeOfEvent.Turnament,"All Japanes Open","Japanese Open",10.50,"Medals","M-60;M-66;M-73;M-81;M-90;M-100;M+100;","http://lorempixel.com/400/300/sports/",clubFacade.findById(6).getLocation(),clubFacade.findById(6),clubFacade.findById(6).getRepresentative(),"flag-icon-jp"));
//
//        eventFacade.create(new Event(LocalDate.of(2015, 5, 1),LocalDate.of(2015, 5, 3), TypeOfEvent.Turnament,"Grand Prix Prag","Grand Prix Prag",35.50,"Medals and Trophys","M-60;M-66;M-73;M-81;M-90;M-100;M+100;","http://lorempixel.com/400/300/sports/",clubFacade.findById(4).getLocation(),clubFacade.findById(4),clubFacade.findById(4).getRepresentative(),"flag-icon-cz"));
//
//        eventFacade.create(new Event(LocalDate.of(2016, 5, 1),LocalDate.of(2016, 5, 3), TypeOfEvent.Turnament,"Grand Prix Prag","Grand Prix Prag",35.50,"Medals and Trophys","M-60;M-66;M-73;M-81;M-90;M-100;M+100;","http://lorempixel.com/400/300/sports/",clubFacade.findById(4).getLocation(),clubFacade.findById(4),clubFacade.findById(4).getRepresentative(),"flag-icon-cz"));
//
//        eventFacade.create(new Event(LocalDate.of(2015, 5, 1),LocalDate.of(2015, 5, 3), TypeOfEvent.Turnament,"Grand Prix Warsaw","Grand Prix Warsaw",35.50,"Medals and Trophys","W-48;W-52;W-57;W-63;W-70;W-78;W+78;","http://lorempixel.com/400/300/sports/",clubFacade.findById(5).getLocation(),clubFacade.findById(5),clubFacade.findById(5).getRepresentative(),"flag-icon-pl"));
//
//        eventFacade.create(new Event(LocalDate.of(2016, 5, 1),LocalDate.of(2016, 5, 3), TypeOfEvent.Turnament,"Grand Prix Warsaw","Grand Prix Warsaw",35.50,"Medals and Trophys","W-48;W-52;W-57;W-63;W-70;W-78;W+78;;","http://lorempixel.com/400/300/sports/",clubFacade.findById(5).getLocation(),clubFacade.findById(5),clubFacade.findById(5).getRepresentative(),"flag-icon-pl"));
//
//        eventFacade.create(new Event(LocalDate.of(2015, 2, 12),LocalDate.of(2015, 2, 13), TypeOfEvent.Turnament,"International Turnament Rohrbach","IT Rohrbach",10.50,"Medals","M-60;M-66;M-73;M-81;M-90;M-100;M+100;","http://lorempixel.com/400/300/sports/",clubFacade.findById(1).getLocation(),clubFacade.findById(1),clubFacade.findById(1).getRepresentative(),"flag-icon-at"));
//
//        eventFacade.create(new Event(LocalDate.of(2016, 2, 12),LocalDate.of(2016, 2, 13), TypeOfEvent.Turnament,"International Turnament Rohrbach","IT Rohrbach",10.50,"Medals","M-60;M-66;M-73;M-81;M-90;M-100;M+100;","http://lorempixel.com/400/300/sports/",clubFacade.findById(1).getLocation(),clubFacade.findById(1),clubFacade.findById(1).getRepresentative(),"flag-icon-at"));
//
//        eventFacade.create(new Event(LocalDate.of(2015, 10, 19),LocalDate.of(2015, 10, 20), TypeOfEvent.Turnament,"All Japanes Open","Japanese Open",10.50,"Medals","M-60;M-66;M-73;M-81;M-90;M-100;M+100;","http://lorempixel.com/400/300/sports/",clubFacade.findById(6).getLocation(),clubFacade.findById(6),clubFacade.findById(6).getRepresentative(),"flag-icon-jp"));
//
//        eventFacade.create(new Event(LocalDate.of(2016, 10, 20),LocalDate.of(2016, 10, 21), TypeOfEvent.Turnament,"All Japanes Open","Japanese Open",10.50,"Medals","M-60;M-66;M-73;M-81;M-90;M-100;M+100;","http://lorempixel.com/400/300/sports/",clubFacade.findById(6).getLocation(),clubFacade.findById(6),clubFacade.findById(6).getRepresentative(),"flag-icon-jp"));





//        participationFacade.create(new Participation(3,"U21 +100 .Marcel Pautz;U18 -73 .Wojtek Karnik;U21 -73 .Christoph Hofer;",clubFacade.findById(1),eventFacade.findById(9)));
//
//        participationFacade.create(new Participation(3,"U21 -52 .Andrea Dall;U18 -70 .Rebecca Autengruber;U18 -52 .Pamela Neubauer",clubFacade.findById(1),eventFacade.findById(11)));

    }
}
