import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponent } from './app-components/navbar/navbar.component';
import {MainpageComponent} from "./app-components/mainpage/mainpage.component";
import { FooterComponent } from './app-components/footer/footer.component';
import {AppRoutingModule} from "./app-routing.module";
import { TournamentComponent } from './app-components/tournament/tournament.component';
import { TrainingscampComponent } from './app-components/trainingscamp/trainingscamp.component';
import { LandmapComponent } from './app-components/landmap/landmap.component';
import { CreateComponent } from './app-components/create/create.component';
import { NgDatepickerModule } from 'ng2-datepicker';
import {MultiselectDropdownModule} from "angular-2-dropdown-multiselect";
import { SearchcomponenttournamentComponent } from './app-components/tournament/searchcomponenttournament/searchcomponenttournament.component';
import { ShowcomponenttournamentComponent } from './app-components/tournament/showcomponenttournament/showcomponenttournament.component';
import {HttpClientModule} from "@angular/common/http";
import {HttpModule} from "@angular/http";
import {DetailtournamentcomponentComponent} from "./app-components/tournament/detailtournamentcomponent/detailtournamentcomponent.component";
import { TournamentDataComponent } from './app-components/create/tournament-data/tournament-data.component';
import {CoreModule} from "./core/core.module";
import {TournamentDao} from "./core/dao/tournament.dao";
import {AppConfig} from "./core/app-config/app-config.service";


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    MainpageComponent,
    FooterComponent,
    TournamentComponent,
    TrainingscampComponent,
    LandmapComponent,
    CreateComponent,
    SearchcomponenttournamentComponent,
    ShowcomponenttournamentComponent,
    DetailtournamentcomponentComponent,
    TournamentDataComponent

  ],
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule,
    MultiselectDropdownModule,
    NgDatepickerModule,
    HttpClientModule
  ],
  providers: [TournamentDao,AppConfig],
  bootstrap: [AppComponent]
})
export class AppModule { }
