import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import { DatepickerOptions,NgDatepickerComponent } from 'ng2-datepicker';

@Component({
  selector: 'app-tournament',
  templateUrl: './tournament.component.html',
  styleUrls: ['./tournament.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class TournamentComponent implements OnInit {
  dateFrom: Date;
  dateTo: Date;
  options: DatepickerOptions={
    minYear: 2017,
    maxYear: 2030,
    displayFormat: 'MMM D[,] YYYY',
    barTitleFormat: 'MMMM YYYY',
    firstCalendarDay: 1
  };

  constructor() {
    this.dateFrom = new Date();
    this.dateTo = new Date();
  }

  ngOnInit() {

  }

}
