import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {TournamentService} from "../tournament.service";
import {Event} from "../../../core/model/event";

@Component({
  selector: 'app-showcomponenttournament',
  templateUrl: './showcomponenttournament.component.html',
  styleUrls: ['./showcomponenttournament.component.css']
})
export class ShowcomponenttournamentComponent implements OnInit {

  public tournaments: Event[];
  tmpTourn: Event[];
  events: Event[];
  errorMessage: string;
  nameSearch: string ="";
  countrySearch: string="";
  public isLoading:boolean = true;

  constructor(private tournamentService: TournamentService) {
  }

  private async getTournaments(){
    await this.tournamentService.updateTournaments();
    console.log("get");

  }

  async ngOnInit() : Promise<void> {
    await this.getTournaments();
    this.tmpTourn = this.tournamentService.tournaments;
    this.tournaments = this.tournamentService.tournaments;
    console.log("initview");
    this.blafunc();
  }

  public searchCountryChange(){
    this.tournaments=this.tmpTourn.filter(c => c.name.toLowerCase().includes(this.nameSearch.toLowerCase())).filter(e=>e.location.country.toLowerCase().includes(this.countrySearch.toLowerCase()));
  }

  public blafunc(){
    this.isLoading=true;
    setTimeout(()=>{
      this.isLoading=false;
    },0)

  }

}
