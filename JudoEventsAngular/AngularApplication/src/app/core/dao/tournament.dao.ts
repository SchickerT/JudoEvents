import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {AppConfig} from "../app-config/app-config.service";
import {Event} from "../model/event";
import 'rxjs/add/operator/toPromise';

@Injectable()
export class TournamentDao{
  public constructor(private http:HttpClient,
                     private appConfig:AppConfig ){

  }

  public fetchAllTournaments(): Promise<Event[]>{
    return this.http.get<Event[]>(this.appConfig.serverURL+'/tournaments')
      .toPromise();
  }

  public async createTournament(tournament: Event):Promise<void>{
    let json: any = tournament;

    await this.http.post<void>(this.appConfig.serverURL+'/event',tournament)
      .toPromise();
  }

  private concatWithDelimiter(stringArray: string[], delimiter: string) {
    return stringArray.map(e => e.replace(delimiter, '\\' + delimiter)).join(delimiter);
  }
}
