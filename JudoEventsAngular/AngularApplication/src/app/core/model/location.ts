export class Location{
  public id:number;
  public zipCode:string;
  public city:string;
  public street:string;
  public federalState:string;
  public country:string;

  constructor(id:number,
              zipCode:string,
              city:string,
              street:string,
              federalState:string,
              country:string){
      this.id = id;
      this.zipCode = zipCode;
      this.city = city;
      this.street = street;
      this.federalState = federalState;
      this.country = country;
  }
}
