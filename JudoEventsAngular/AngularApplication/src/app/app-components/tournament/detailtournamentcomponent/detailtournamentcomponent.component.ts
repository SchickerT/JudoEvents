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
  public logo: PickedFile;

  public id:number;

  private async getTournament(id:number){
    await this.tournamentService.getTournamentById(id);
    console.log("getById");
  }

  private async getTournamentPic(id:number){
    await this.tournamentService.updateTournamentPic(id);
  }

  constructor(private tournamentService: TournamentService,private router:Router, private route:ActivatedRoute ) {

  }

  async ngOnInit(): Promise<void> {
    console.log("initfirst");
    this.id = parseInt(this.route.snapshot.paramMap.get('id'));
    await this.getTournament(this.id);
    await this.getTournamentPic(this.id);
    console.log("getSent");
    this.tournament = this.tournamentService.tournament;
    this.tournamentPic = this.tournamentService.tournamentPic;
    console.log(this.tournamentPic);
  }

  public checkLoading():boolean{
    if( !this.tournament==null || typeof this.tournament !='undefined'){
      return true;
    }
    else
      return false;
  }

}
