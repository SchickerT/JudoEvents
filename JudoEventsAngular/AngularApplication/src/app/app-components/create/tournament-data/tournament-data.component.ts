import { Component, EventEmitter, Input, OnInit } from '@angular/core';
import {FormGroup, ValidationErrors} from '@angular/forms';
import {DatepickerOptions} from "ng2-datepicker";
import * as frLocale from 'date-fns/locale/fr';
import { PickedFile } from '../../../libs/file-picker/picked-file';
import { FilePickerError } from '../../../libs/file-picker/file-picker-error';

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

  constructor() {
    this.dateFrom = new Date();
    this.dateTo = new Date(Date.UTC(2029,11,31));
  }

  ngOnInit() {
  }

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

  optionsDatepicker: DatepickerOptions={
    minYear: 2018,
    maxYear: 2030,
    displayFormat: 'MMM D[,] YYYY',
    barTitleFormat: 'MMMM YYYY',
    firstCalendarDay: 1,
    minDate: new Date(Date.now())
  };
}
