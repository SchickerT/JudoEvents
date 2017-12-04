import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import { HttpModule } from '@angular/http';

import {Event} from "../../../core/model/event";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class TournamentService {
  url = "http://localhost:8080/JudoEventsServer/rs/event/tournaments";

  constructor(private http:HttpClient) { }

  getTournamentsWithObservable(): Observable<Event[]> {
    return this.http.get<Event[]>(this.url);
  }
}
