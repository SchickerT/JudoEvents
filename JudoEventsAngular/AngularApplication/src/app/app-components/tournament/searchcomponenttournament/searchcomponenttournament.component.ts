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
  bsRangeValue: any = [null, null];
  countrySearch:Object;

  mindate:Date=new Date(Date.now());
  maxdate:Date=new Date(2025,12,31);

  countries = [
    {id: 1, name: "Albania"},
    {id: 2, name: "Andorra"},
    {id: 3, name: "Armenia"},
    {id: 4, name: "Austria"},
    {id: 5, name: "Azerbaijan"},
    {id: 6, name: "Belarus"},
    {id: 7, name: "Belgium"},
    {id: 8, name: "Bosnia and Herzegovina"},
    {id: 9, name: "Bulgaria"},
    {id: 10, name: "Croatia"},
    {id: 11, name: "Cyprus"},
    {id: 12, name: "Czech Republic"},
    {id: 13, name: "Denmark"},
    {id: 14, name: "Estonia"},
    {id: 15, name: "Finland"},
    {id: 16, name: "France"},
    {id: 17, name: "Georgia"},
    {id: 18, name: "Germany"},
    {id: 19, name: "Greece"},
    {id: 20, name: "Hungary"},
    {id: 21, name: "Iceland"},
    {id: 22, name: "Ireland"},
    {id: 23, name: "Italy"},
    {id: 24, name: "Kazakhstan"},
    {id: 25, name: "Kosovo"},
    {id: 26, name: "Latvia"},
    {id: 27, name: "Liechtenstein"},
    {id: 28, name: "Lithunia"},
    {id: 29, name: "Luxembourg"},
    {id: 30, name: "Macedonia"},
    {id: 31, name: "Malta"},
    {id: 32, name: "Moldova"},
    {id: 33, name: "Monaco"},
    {id: 34, name: "Montenegro"},
    {id: 35, name: "Netherlands"},
    {id: 36, name: "Norway"},
    {id: 37, name: "Poland"},
    {id: 38, name: "Portugal"},
    {id: 39, name: "Romania"},
    {id: 40, name: "Russia"},
    {id: 41, name: "San Marino"},
    {id: 42, name: "Serbia"},
    {id: 43, name: "Slovakia"},
    {id: 44, name: "Slovenia"},
    {id: 45, name: "Spain"},
    {id: 46, name: "Sweden"},
    {id: 47, name: "Switzerland"},
    {id: 48, name: "Turkey"},
    {id: 49, name: "Ukraine"},
    {id: 50, name: "United Kingdom"}
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
    this.countrySearch = "";
  }

  ngOnInit() {
    $('.ddm a').on('click', function(){
      $('.ddt').html($(this).html() + '<span class="caret"></span>');
      console.log($(this).html().toString().substring(99));
    })
  }
}
