export class Location{
  public id:number;
  public zipCode:string;
  public city:string;
  public street:string;
  public federalState:string;
  public country:string;
  public longitude: number;
  public latitude: number;
  public countryCode: string;

  constructor(id:number,
              zipCode:string,
              city:string,
              street:string,
              federalState:string,
              country:string,
              long:number,
              lat:number,
              cc:string){
      this.id = id;
      this.zipCode = zipCode;
      this.city = city;
      this.street = street;
      this.federalState = federalState;
      this.country = country;
      this.longitude = long;
      this.latitude = lat;
      this.countryCode = cc;
  }
}
