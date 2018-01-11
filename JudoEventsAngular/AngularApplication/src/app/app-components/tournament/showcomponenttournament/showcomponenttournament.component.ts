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
  styleUrls: ['./showcomponenttournament.component.css'],
  providers:[TournamentService]
})
export class ShowcomponenttournamentComponent implements OnInit {

  @Output()
  showDetailComp= new EventEmitter();

  @Output()
  sendIdEvent = new EventEmitter();

  public tournaments: Event[];
  tmpTourn: Event[];
  events: Event[];
  errorMessage: string;
  nameSearch: string ="";
  countrySearch: string="";

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
  }
  public showDetails(id:number){
    console.log(id);
    this.showDetailComp.emit(true);
    this.sendIdEvent.emit(id);

  }

  public searchCountryChange(){
    this.tournaments=this.tmpTourn.filter(c => c.name.toLowerCase().includes(this.nameSearch.toLowerCase())).filter(e=>e.location.country.toLowerCase().includes(this.countrySearch.toLowerCase()));
  }


}
