export class Representative{
  public id:number;
  public firstName:string;
  public lastName:string;
  public email:string;
  public phoneNumber:string;
  public representativePicture:string;

  constructor(id:number,
              firstName:string,
              lastName:string,
              email:string,
              phoneNumber:string,
              picture:string){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.representativePicture = picture;

  }
}
