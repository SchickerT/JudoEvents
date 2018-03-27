import { Component, EventEmitter, Input, OnInit } from '@angular/core';
import {FormGroup, ValidationErrors} from '@angular/forms';
import {DatepickerOptions} from "ng2-datepicker";
import * as frLocale from 'date-fns/locale/fr';
import { PickedFile } from '../../../libs/file-picker/picked-file';
import { FilePickerError } from '../../../libs/file-picker/file-picker-error';
import { MouseEvent } from '@agm/core';
import { BsDatepickerConfig, BsLocaleService } from 'ngx-bootstrap/datepicker';
import {FormValidationHelper} from "../../../libs/helper/form-validation-helper";
import {TournamentDao} from "../../../core/dao/tournament.dao";
declare let $;
@Component({
  selector: 'app-tournament-data',
  templateUrl: './tournament-data.component.html',
  styleUrls: ['./tournament-data.component.css']
})
export class TournamentDataComponent implements OnInit {
  @Input()
  public stepFormGroup: FormGroup;

  mindate:Date=new Date(Date.now());
  maxdate:Date=new Date(2025,12,31);

  public logo: PickedFile;
  public isDrag: boolean = false;
  public picString: string;

  public iconRep: PickedFile;
  public isDragTwo:boolean = false;

  lat: number = 0;
  lng: number = 0;
  zoom: number = 16;

  constructor(private tournamentDao: TournamentDao) {
  }

  ngOnInit() {

  }

  markers: marker[] = [
    {
      lat: null,
      lng: null,
      label: '',
      draggable: true
    }
  ]

  private countries = [
    {id: 1, name: "Albania", cc:"flag-icon-al"},
    {id: 2, name: "Andorra", cc:"flag-icon-ad"},
    {id: 3, name: "Armenia", cc:"flag-icon-am"},
    {id: 4, name: "Austria", cc:"flag-icon-at"},
    {id: 5, name: "Azerbaijan", cc:"flag-icon-az"},
    {id: 6, name: "Belarus", cc:"flag-icon-by"},
    {id: 7, name: "Belgium", cc:"flag-icon-be"},
    {id: 8, name: "Bosnia and Herzegovina", cc:"flag-icon-ba"},
    {id: 9, name: "Bulgaria", cc:"flag-icon-bg"},
    {id: 10, name: "Croatia", cc:"flag-icon-hr"},
    {id: 11, name: "Cyprus", cc:"flag-icon-cy"},
    {id: 12, name: "Czech Republic", cc:"flag-icon-cz"},
    {id: 13, name: "Denmark", cc:"flag-icon-dk"},
    {id: 14, name: "Estonia", cc:"flag-icon-ee"},
    {id: 15, name: "Finland", cc:"flag-icon-fi"},
    {id: 16, name: "France", cc:"flag-icon-fr"},
    {id: 17, name: "Georgia", cc:"flag-icon-ge"},
    {id: 18, name: "Germany", cc:"flag-icon-de"},
    {id: 19, name: "Greece", cc:"flag-icon-gr"},
    {id: 20, name: "Hungary", cc:"flag-icon-hu"},
    {id: 21, name: "Iceland", cc:"flag-icon-is"},
    {id: 22, name: "Ireland", cc:"flag-icon-ie"},
    {id: 23, name: "Italy", cc:"flag-icon-it"},
    {id: 24, name: "Kazakhstan", cc:"flag-icon-kz"},
    {id: 25, name: "Kosovo", cc:""},
    {id: 26, name: "Latvia", cc:"flag-icon-lv"},
    {id: 27, name: "Liechtenstein", cc:"flag-icon-li"},
    {id: 28, name: "Lithunia", cc:"flag-icon-lt"},
    {id: 29, name: "Luxembourg", cc:"flag-icon-lu"},
    {id: 30, name: "Macedonia", cc:"flag-icon-mk"},
    {id: 31, name: "Malta", cc:"flag-icon-mt"},
    {id: 32, name: "Moldova", cc:"flag-icon-md"},
    {id: 33, name: "Monaco", cc:"flag-icon-mc"},
    {id: 34, name: "Montenegro", cc:"flag-icon-me"},
    {id: 35, name: "Netherlands", cc:"flag-icon-nl"},
    {id: 36, name: "Norway", cc:"flag-icon-no"},
    {id: 37, name: "Poland", cc:"flag-icon-pl"},
    {id: 38, name: "Portugal", cc:"flag-icon-pt"},
    {id: 39, name: "Romania", cc:"flag-icon-ro"},
    {id: 40, name: "Russia", cc:"flag-icon-ru"},
    {id: 41, name: "San Marino", cc:"flag-icon-sm"},
    {id: 42, name: "Serbia", cc:"flag-icon-rs"},
    {id: 43, name: "Slovakia", cc:"flag-icon-sk"},
    {id: 44, name: "Slovenia", cc:"flag-icon-sl"},
    {id: 45, name: "Spain", cc:"flag-icon-es"},
    {id: 46, name: "Sweden", cc:"flag-icon-se"},
    {id: 47, name: "Switzerland", cc:"flag-icon-ch"},
    {id: 48, name: "Turkey", cc:"flag-icon-tr"},
    {id: 49, name: "Ukraine", cc:"flag-icon-ua"},
    {id: 50, name: "United Kingdom", cc:"flag-icon-gb"}
  ];

  public filePicked(file: PickedFile | FilePickerError): void {

    if (file instanceof PickedFile) {
      this.logo = file;
      this.stepFormGroup.controls["eventPicture"].setValue(this.logo.dataURL);
    } else if (file === FilePickerError.FileTooBig) {
      console.log('too big');
    } else if (file === FilePickerError.InvalidFileType) {
      console.log('invalid file type');
    } else if (file === FilePickerError.UndefinedInput) {
      console.log('undefined input');
    }
  }

  public iconPicked(file: PickedFile | FilePickerError): void {

    if (file instanceof PickedFile) {
      this.iconRep = file;
      this.stepFormGroup.controls["representativePicture"].setValue(this.iconRep.dataURL);
    } else if (file === FilePickerError.FileTooBig) {
      console.log('too big');
    } else if (file === FilePickerError.InvalidFileType) {
      console.log('invalid file type');
    } else if (file === FilePickerError.UndefinedInput) {
      console.log('undefined input');
    }
  }


  clickedMarker(label: string, index: number) {
    console.log(`clicked the marker: ${label || index}`)
  }

  markerDragEnd(m: marker, $event: MouseEvent) {
    console.log('dragEnd', m, $event);
  }

  mapClicked($event: MouseEvent) {
    this.markers[0].lat=$event.coords.lat;
    this.markers[0].lng=$event.coords.lng;
    this.markers[0].draggable=true;
    this.stepFormGroup.controls['latitude'].setValue(this.markers[0].lat);
    this.stepFormGroup.controls['longitude'].setValue(this.markers[0].lng);
  }

  public isRequired(formName: string):boolean{
    return FormValidationHelper.isRequired(formName,this.stepFormGroup);
  }


  public hasErrors(formName:string):ValidationErrors{
    return FormValidationHelper.hasError(formName,this.stepFormGroup);
  }

  public isHoovered(formName:string):boolean{
    return FormValidationHelper.isHoovered(formName,this.stepFormGroup);
  }

  public storeFroala():void{
    var html =   $('#editor').froalaEditor('html.get');
    //console.log(html.toString());
    this.stepFormGroup.controls['description'].setValue(html.toString());
  }




  public options: Object = {
    charCounterCount: true,
    charCounterMax: 3500,
    quickInsert:false,
    heightMin: 250,
    heightMax: 490,
    enter: $.FroalaEditor.ENTER_BR,
    tooltips:true,
    fontSize:'30',
    placeholderText: 'Please enter a short description down here.......',
    quickInsertTags:'',
    inlineMode:true,
    toolbarButtons: ['undo', 'redo' , '|', 'bold', 'italic', 'underline' , '|', 'formatUL', 'formatOL','clearFormatting',  '|','superscript', 'outdent', 'indent']
    //toolbarButtonsXS: ['bold', 'italic', 'underline', 'paragraphFormat','alert'],
    //toolbarButtonsSM: ['bold', 'italic', 'underline', 'paragraphFormat','alert'],
    //toolbarButtonsMD: ['bold', 'italic', 'underline', 'paragraphFormat','alert'],
  };

  async setNewCountry(count:any):Promise<void>{
    console.log(count);
    this.stepFormGroup.controls['country'].setValue(count);
    await this.tournamentDao.getLongAndLatByAdress(this.stepFormGroup.controls['city'].value,this.stepFormGroup.controls['zipCode'].value,this.stepFormGroup.controls['street'].value,this.stepFormGroup.controls['streetNumber'].value,this.stepFormGroup.controls['country'].value);
    console.log(this.tournamentDao.lat);
    this.markers[0].lat=this.tournamentDao.lat;
    this.markers[0].lng=this.tournamentDao.long;
    this.markers[0].draggable=true;
    this.stepFormGroup.controls['latitude'].setValue(this.markers[0].lat);
    this.stepFormGroup.controls['longitude'].setValue(this.markers[0].lng);
    this.lat = this.tournamentDao.lat;
    this.lng = this.tournamentDao.long;
    for (let country of this.countries) {
      if(country.name == count){
        this.stepFormGroup.controls["countryCode"].setValue(country.cc)
        console.log(country.cc);
        break;
      }
    }
  }

  private fieldArray: Array<any> = [];
  private newAttribute: any = {};
  private result:Array<any>=[];
  private tmpArr:Array<any>=[];
  private line:Array<any>=[];

  addFieldValue() {
    this.fieldArray.push(this.newAttribute)
    this.newAttribute = {};
  }

  deleteFieldValue(index) {
    this.fieldArray.splice(index, 1);
  }

  public createResultArray():string{
    this.fieldArray.push(this.newAttribute);
    console.log(this.fieldArray);
    for(var i in this.fieldArray) {
      console.log(this.fieldArray[i]);
      this.line = this.fieldArray[i];
      for (var attr in this.line) {
        this.tmpArr.push(encodeURIComponent(this.line[attr]));
      }
      this.result.push(this.tmpArr.join(";"));
      this.line = [];
      this.tmpArr = [];
    }

    console.log(this.result.join("/"));
    return this.result.join("/");
  }


}
interface marker {
  lat: number;
  lng: number;
  label?: string;
  draggable: boolean;
}


