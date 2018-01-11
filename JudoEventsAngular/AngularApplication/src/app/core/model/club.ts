import { Location } from './location';
import {Representative} from "./representative";

export class Club {
  public id:number;
  public name:string;
  public discription:string;
  public email:string;
  public password:string;
  public pictureUrl:string;

  public representative:Representative;
  public location:Location;

  constructor(id:number,
              name:string,
              discription?:string,
              email?: string,
              password?: string,
              pictureUrl?: string,
              representative?: Representative,
              location?: Location){
    this.id=id;
    this.name = name;
    this.discription = discription;
    this.email = email;
    this.password = password;
    this.pictureUrl = pictureUrl;
    this.representative = representative;
    this.location = location;
  }
}
