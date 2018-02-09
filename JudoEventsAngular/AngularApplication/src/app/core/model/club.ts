import { Location } from './location';
import {Representative} from "./representative";

export class Club {
  public id:number;
  public name:string;
  public discription:string;
  public email:string;
  public password:string;
  public clubPicture:string;

  public representative:Representative;
  public location:Location;

  constructor(id:number,
              name:string,
              discription?:string,
              email?: string,
              password?: string,
              picture?: string,
              representative?: Representative,
              location?: Location){
    this.id=id;
    this.name = name;
    this.discription = discription;
    this.email = email;
    this.password = password;
    this.clubPicture = picture;
    this.representative = representative;
    this.location = location;
  }
}
