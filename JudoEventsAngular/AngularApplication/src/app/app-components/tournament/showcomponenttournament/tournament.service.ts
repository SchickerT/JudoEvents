import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import { HttpModule } from '@angular/http';

import {Event} from "../../../core/model/event";

@Injectable()
export class TournamentService {
  url = "http://localhost:8080/JudoEventsServer/rs/event/tournaments";

  constructor(private http:Http) { }

  getTournamentsWithObservable(): Observable<Event[]> {
    return this.http.get(this.url)
      .map(this.extractData)
      .catch(this.handleErrorObservable);
  }
  private extractData(res: Response) {
    let body = res.json();
    return body;
  }
  private handleErrorObservable (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }

}
