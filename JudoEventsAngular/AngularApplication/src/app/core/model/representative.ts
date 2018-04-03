export class Representative{
  public id:number;
  public firstName:string;
  public lastName:string;
  public email:string;
  public phoneNumber:string;
  public representativePicture:string;

  constructor(firstName?:string,
              lastName?:string,
              email?:string,
              phoneNumber?:string,
              picture?:string,
              id?:number){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.representativePicture = picture;

  }
}
