import { Component, OnInit } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/mergeMap';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {TournamentService} from "./tournament.service";
import {Event} from "../../../core/model/event";

@Component({
  selector: 'app-showcomponenttournament',
  templateUrl: './showcomponenttournament.component.html',
  styleUrls: ['./showcomponenttournament.component.css'],
  providers:[TournamentService]
})
export class ShowcomponenttournamentComponent implements OnInit {

  public tournaments: Event[];
  events: Event[];
  errorMessage: string;


  constructor(private tournamentService: TournamentService) {
  }

  private getTournaments(){
    this.tournamentService.getTournamentsWithObservable().subscribe(
      (tourn)=>{
        this.tournaments = tourn
      }
    );

  }

  ngOnInit() : void {
    this.getTournaments();
  }



}
