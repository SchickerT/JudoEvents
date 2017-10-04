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

  public location:Location;
  public club:Club;
  public representative:Representative;
}
