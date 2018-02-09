import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {IMultiSelectOption, IMultiSelectSettings, IMultiSelectTexts} from "angular-2-dropdown-multiselect";
import { DatepickerOptions,NgDatepickerModule,NgDatepickerComponent } from 'ng2-datepicker';
declare let $;

@Component({
  selector: 'app-searchcomponenttournament',
  templateUrl: './searchcomponenttournament.component.html',
  styleUrls: ['./searchcomponenttournament.component.css']
})
export class SearchcomponenttournamentComponent implements OnInit {
  dateFrom : Date;
  dateTo: Date;
  countrySearch:Object;
  textSearch:string;

  countries = [
    {id: 1, name: "Austria"},
    {id: 2, name: "Japan"},
    {id: 3, name: "Poland"},
    {id: 4, name: "Czech Republic"}
    ];

  optionsDatepicker: DatepickerOptions={
    minYear: 2018,
    maxYear: 2030,
    displayFormat: 'MMM D[,] YYYY',
    barTitleFormat: 'MMMM YYYY',
    firstCalendarDay: 1,
    minDate: new Date(Date.now())
  };

  constructor() {
    this.dateFrom = new Date();
    this.dateTo = new Date(Date.UTC(2029,11,31));
    this.countrySearch = "";
  }

  ngOnInit() {
    $('.ddm a').on('click', function(){
      $('.ddt').html($(this).html() + '<span class="caret"></span>');
      console.log($(this).html().toString().substring(99));
    })
  }
}
