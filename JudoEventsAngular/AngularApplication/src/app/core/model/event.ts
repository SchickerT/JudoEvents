import {Location} from "./location";
import {Club} from "./club";
import {Representative} from "./representative";

export class Event{
  public id:number;
  public startDate:Date;
  public endDate:Date;
  public name:string;
  public discription:string;
  public entryFee:number;
  public rewards:string;
  public ageAndWeight:string;
  public eventPicture:string;
  public location: Location;
  public club: Club;
  public representative: Representative;



  constructor(id: number,
              name: string,
              startDate: Date,
              endDate: Date,
              discription?: string,
              entryFee?: number,
              rewards?: string,
              ageAndWeight?: string,
              picture?: string,
              location?: Location,
              club?: Club,
              representative?: Representative) {

    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.name = name;
    this.discription = discription;
    this.entryFee = entryFee;
    this.rewards = rewards;
    this.ageAndWeight = ageAndWeight;
    this.eventPicture = picture;
    this.location = location;
    this.club = club;
    this.representative = representative;
  }
}
