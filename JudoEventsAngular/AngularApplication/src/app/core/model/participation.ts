import {Club} from "./club";
import {Event} from "./event";

export class Participation{
  public id:number;
  public numberOfStarters:number;
  public starters:String;
  public clubId:number;
  public eventId:number;

  public club:Club;
  public event:Event;
}
