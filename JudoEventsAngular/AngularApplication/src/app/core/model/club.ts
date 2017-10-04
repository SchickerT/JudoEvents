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

}
