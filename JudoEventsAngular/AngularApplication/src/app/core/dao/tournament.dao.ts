import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {AppConfig} from "../app-config/app-config.service";
import {Event} from "../model/event";
import 'rxjs/add/operator/toPromise';

@Injectable()
export class TournamentDao{
  public long:number;
  public lat:number;

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

  getLongAndLatByAdress(plz: string,city: string,street:string,streeNr:string,country:string):Promise<void>{
    return this.http.get<any>('https://maps.googleapis.com/maps/api/geocode/json?address='+plz+',+'+city+',+'+street+',+'+streeNr+',+'+country+'&key=AIzaSyCkia2CQo1IicDSnBR9n5-k28K6Bu76Y-Y')
      .map((data:any)=>{
        this.long = data.results[0].geometry.location.lng;
        this.lat = data.results[0].geometry.location.lat;
        console.log(this.long);
      }).toPromise();
  }

}
