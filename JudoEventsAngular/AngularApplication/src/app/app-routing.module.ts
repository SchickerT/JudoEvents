import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import {MainpageComponent} from "./app-components/mainpage/mainpage.component";
import {TournamentComponent} from "./app-components/tournament/tournament.component";
import {TrainingscampComponent} from "./app-components/trainingscamp/trainingscamp.component";
import {LandmapComponent} from "./app-components/landmap/landmap.component";
import {CreateComponent} from "./app-components/create/create.component";
import {DetailtournamentcomponentComponent} from "./app-components/tournament/detailtournamentcomponent/detailtournamentcomponent.component";
import {ShowcomponenttournamentComponent} from "./app-components/tournament/showcomponenttournament/showcomponenttournament.component";

const routes: Routes=[
  {
    path:'',
    component:MainpageComponent
  },
  {
    path:'searchtourn',
    component:TournamentComponent
  },
  {
    path:'searchtourn/tournaments',
    component:ShowcomponenttournamentComponent
  },
  {
    path:'searchtourn/tournaments/tournament/:id',
    component:DetailtournamentcomponentComponent
  },
  {
    path:'trainingscamp',
    component:TrainingscampComponent
  },
  {
    path:'map',
    component:LandmapComponent
  },
  {
    path:'create',
    component:CreateComponent
  },
  {
    path: '**', redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
