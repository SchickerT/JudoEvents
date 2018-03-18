import { Component, OnInit } from '@angular/core';
import {TournamentDao} from "../../core/dao/tournament.dao";
import {Event} from "../../core/model/event";
import {TournamentService} from "../tournament/tournament.service";

@Component({
  selector: 'app-landmap',
  templateUrl: './landmap.component.html',
  styleUrls: ['./landmap.component.css']
})
export class LandmapComponent implements OnInit {
  public tournaments: Event[];

  lat: number = 49;
  lng: number = 14;
  zoom: number = 6;


  constructor(private tournamentService: TournamentService) { }

  async ngOnInit() :Promise<void>{
    this.tournamentService.startDate = '-1';
    this.tournamentService.endDate = '-1';
    this.tournamentService.country = '-1';
    await this.getTournaments();
    this.tournaments = this.tournamentService.tournaments;
    console.log(this.tournaments);
  }

  private async getTournaments(){
    await this.tournamentService.updateTournaments();
    console.log("get");

  }
}


