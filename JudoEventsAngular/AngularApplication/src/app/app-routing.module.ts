import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import {MainpageComponent} from "./app-components/mainpage/mainpage.component";
import {TournamentComponent} from "./app-components/tournament/tournament.component";
import {TrainingscampComponent} from "./app-components/trainingscamp/trainingscamp.component";
import {LandmapComponent} from "./app-components/landmap/landmap.component";
import {CreatetournamentComponent} from "./app-components/createtournament/createtournament.component";

const routes: Routes=[
  {
    path:'',
    component:MainpageComponent
  },
  {
    path:'tournament',
    component:TournamentComponent
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
    component:CreatetournamentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
