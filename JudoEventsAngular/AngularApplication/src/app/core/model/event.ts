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
  public pictureUrl:string;
  public clubId:number;
  public locationId:number;
  public representativeId:number;
  public countryCode: string;



  constructor(id: number,
              name: string,
              startDate: Date,
              endDate: Date,
              countryCode: string,
              discription?: string,
              entryFee?: number,
              rewards?: string,
              ageAndWeight?: string,
              pictureUrl?: string,
              clubId?: number,
              locationId?: number,
              representativeId?: number) {

    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.name = name;
    this.discription = discription;
    this.entryFee = entryFee;
    this.rewards = rewards;
    this.ageAndWeight = ageAndWeight;
    this.pictureUrl = pictureUrl;
    this.clubId = clubId;
    this.locationId = locationId;
    this.representativeId = representativeId;
    this.countryCode = countryCode;
  }
}
