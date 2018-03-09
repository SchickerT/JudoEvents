import {Component, Input, OnInit} from '@angular/core';
import {TournamentService} from "../tournament.service";
import {Event} from "../../../core/model/event";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {PickedFile} from "../../../libs/file-picker/picked-file";

@Component({
  selector: 'app-detailtournamentcomponent',
  templateUrl: './detailtournamentcomponent.component.html',
  styleUrls: ['./detailtournamentcomponent.component.css'],
  providers: [TournamentService]
})
export class DetailtournamentcomponentComponent implements OnInit {
  public tournament: Event;
  public tournamentPic:string;
  public clubPic:string;
  public repPic:string;

  public id:number;

  private async getTournament(id:number){
    await this.tournamentService.getTournamentById(id);
    console.log("getById");
  }

  private async getTournamentPic(id:number){
    await this.tournamentService.updateTournamentPic(id);
  }

  private async getClubPic(id:number){
    await this.tournamentService.updateClubPic(id);
  }

  private async getRepresentativePic(id:number){
    await this.tournamentService.updateRepresentativePic(id);
  }

  constructor(private tournamentService: TournamentService,private router:Router, private route:ActivatedRoute ) {

  }

  async ngOnInit(): Promise<void> {
    console.log("initfirst");
    this.id = parseInt(this.route.snapshot.paramMap.get('id'));
    await this.getTournament(this.id);
    await this.getTournamentPic(this.id);
    await this.getClubPic(this.id);
    await this.getRepresentativePic(this.id);
    console.log("getSent");

    this.tournament = this.tournamentService.tournament;
    this.tournamentPic = this.tournamentService.tournamentPic;
    this.clubPic = this.tournamentService.clubPic;
    this.repPic = this.tournamentService.representativePic;
  }

  public checkLoading():boolean{
    if( !this.tournament==null || typeof this.tournament !='undefined'){
      return true;
    }
    else
      return false;
  }

}
