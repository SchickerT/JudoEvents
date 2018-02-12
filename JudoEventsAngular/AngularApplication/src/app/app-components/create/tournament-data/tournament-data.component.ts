import { Component, EventEmitter, Input, OnInit } from '@angular/core';
import {FormGroup, ValidationErrors} from '@angular/forms';
import {DatepickerOptions} from "ng2-datepicker";
import * as frLocale from 'date-fns/locale/fr';
import { PickedFile } from '../../../libs/file-picker/picked-file';
import { FilePickerError } from '../../../libs/file-picker/file-picker-error';
import { MouseEvent } from '@agm/core';

@Component({
  selector: 'app-tournament-data',
  templateUrl: './tournament-data.component.html',
  styleUrls: ['./tournament-data.component.css']
})
export class TournamentDataComponent implements OnInit {

  @Input()
  public stepFormGroup: FormGroup;

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
}
interface marker {
  lat: number;
  lng: number;
  label?: string;
  draggable: boolean;
}
