import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import { HttpModule } from '@angular/http';

import {Event} from "../../core/model/event";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class TournamentService {
  url = "http://127.0.0.1:8080/JudoEventsServer/rs/event";
  public tournaments: Event[];
  public tournament : Event;

  public startDate: string = null;
  public endDate: string = null;
  public country: string = '-1';

  public tournamentPic:string;
  public representativePic:string;
  public clubPic:string;

  constructor(private http:HttpClient) {
    console.log("init");

  }



  getTournamentsWithObservable(): Promise<Event[]> {
    console.log("server");

    if(this.startDate==null&&this.country=='-1')
     return this.http.get<Event[]>(this.url + '/tournaments/-1/-1/-1')
       .toPromise();

    if(this.startDate!= null && this.country=='-1')
      return this.http.get<Event[]>(this.url + '/tournaments/'+this.startDate+'/'+this.endDate+'/-1')
      .toPromise();

    if(this.startDate==null&&this.country!='-1')
      return this.http.get<Event[]>(this.url + '/tournaments/-1/-1/'+this.country)
        .toPromise();

    return this.http.get<Event[]>(this.url + '/tournaments/'+this.startDate+'/'+this.endDate+'/'+this.country)
      .toPromise();
  }

  async updateTournaments(): Promise<void>{
    this.tournaments = await this.getTournamentsWithObservable();
  }

  async updateTournamentPic(id:number):Promise<void>{
    this.tournamentPic = await this.getTournamentPicWithId(id);
  }

  async updateRepresentativePic(id:number):Promise<void>{
    this.representativePic = await this.getRepresentativePicWithId(id);
  }

  async updateClubPic(id:number):Promise<void>{
    this.clubPic = await this.getClubPicWithId(id);
  }


  getTournamentPicWithId(id:number):Promise<string>{
    return this.http.get<any>(this.url+'/tournaments/tournament/'+id.toString())
      .map((data:any)=>{
        return data.pictureUrl;
      }).toPromise();

  }

  getRepresentativePicWithId(id:number):Promise<string>{
    return this.http.get<any>(this.url+'/tournaments/representative/'+id.toString())
      .map((data:any)=>{
        return data.pictureUrl;
      }).toPromise();
  }

  getClubPicWithId(id:number):Promise<string>{
    return this.http.get<any>(this.url+'/tournaments/club/'+id.toString())
      .map((data:any)=>{
        return data.pictureUrl;
      }).toPromise();
  }

  getTournamentWithIdObs(id: number): Promise<Event>{
    return this.http.get<Event>(this.url+'/'+id.toString()).toPromise();
  }
  async getTournamentById(id:number): Promise<void>{
    this.tournament = await this.getTournamentWithIdObs(id);
  }


}
