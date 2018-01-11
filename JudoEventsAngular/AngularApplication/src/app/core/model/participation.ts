import {Club} from "./club";
import {Event} from "./event";

export class Participation{
  public id:number;
  public numberOfStarters:number;
  public starters:string;

  public club:Club;
  public event:Event;

  constructor(id:number,
              numberOfStarters:number,
              starters:string,
              club:Club,
              event:Event){
      this.id = id;
      this.numberOfStarters = numberOfStarters;
      this.starters = starters;
      this.club = club;
      this.event = event;
  }
}
