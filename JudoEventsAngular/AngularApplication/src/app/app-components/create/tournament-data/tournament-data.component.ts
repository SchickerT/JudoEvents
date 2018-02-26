import { Component, EventEmitter, Input, OnInit } from '@angular/core';
import {FormGroup, ValidationErrors} from '@angular/forms';
import {DatepickerOptions} from "ng2-datepicker";
import * as frLocale from 'date-fns/locale/fr';
import { PickedFile } from '../../../libs/file-picker/picked-file';
import { FilePickerError } from '../../../libs/file-picker/file-picker-error';
import { MouseEvent } from '@agm/core';
import { BsDatepickerConfig, BsLocaleService } from 'ngx-bootstrap/datepicker';
import {FormValidationHelper} from "../../../libs/helper/form-validation-helper";
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
  dateFrom : Date;
  dateTo: Date;

  public logo: PickedFile;
  public isDrag: boolean = false;

  public iconRep: PickedFile;
  public isDragTwo:boolean = false;

  lat: number = 51.673858;
  lng: number = 7.815982;
  zoom: number = 8;

  constructor() {
    this.dateFrom = new Date();
    this.dateTo = new Date(Date.UTC(2029,11,31));
  }

  ngOnInit() {

  }

  markers: marker[] = [
    {
      lat: 51.673858,
      lng: 7.815982,
      label: 'A',
      draggable: true
    }
  ]

  public filePicked(file: PickedFile | FilePickerError): void {

    if (file instanceof PickedFile) {
      this.logo = file;
      this.stepFormGroup.value.logo = this.logo.dataURL;
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
      this.stepFormGroup.value.icon = this.iconRep.dataURL;
    } else if (file === FilePickerError.FileTooBig) {
      console.log('too big');
    } else if (file === FilePickerError.InvalidFileType) {
      console.log('invalid file type');
    } else if (file === FilePickerError.UndefinedInput) {
      console.log('undefined input');
    }
  }

  optionsDatepicker: DatepickerOptions={
    minYear: 2018,
    maxYear: 2030,
    displayFormat: 'MMM D[,] YYYY',
    barTitleFormat: 'MMMM YYYY',
    firstCalendarDay: 1,
    minDate: new Date(Date.now())
  };

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
    charCounterMax: 1000,
    quickInsert:false,
    heightMin: 250,
    heightMax: 490,
    enter: $.FroalaEditor.ENTER_BR,
    tooltips:true,
    fontSize:'30',
    placeholderText: 'Bitte Firmenbeschreibung eingeben.......',
    quickInsertTags:'',
    inlineMode:true,
    toolbarButtons: ['undo', 'redo' , '|', 'bold', 'italic', 'underline' , '|', 'formatUL', 'formatOL','clearFormatting',  '|','superscript', 'outdent', 'indent']
    //toolbarButtonsXS: ['bold', 'italic', 'underline', 'paragraphFormat','alert'],
    //toolbarButtonsSM: ['bold', 'italic', 'underline', 'paragraphFormat','alert'],
    //toolbarButtonsMD: ['bold', 'italic', 'underline', 'paragraphFormat','alert'],
  };
}
interface marker {
  lat: number;
  lng: number;
  label?: string;
  draggable: boolean;
}


