import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import { DatepickerOptions } from 'ng2-datepicker';
import {IMultiSelectOption,IMultiSelectSettings,IMultiSelectTexts} from "angular-2-dropdown-multiselect";

@Component({
  selector: 'app-tournament',
  templateUrl: './tournament.component.html',
  styleUrls: ['./tournament.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class TournamentComponent implements OnInit {

  isLoading: boolean = false;
  searchLoaded: boolean =true;
  public showDetail: boolean = false;
  public eventId:number;
  dateFrom: Date;
  dateTo: Date;

// Default selection
  optionsModelWeight: number[] = [];
  optionsModelAge: number[]=[];
  optionsModelCountry: number[]=[];


//Weightclasses
// Settings configuration
  weightSetting: IMultiSelectSettings = {
    showCheckAll:true,
    showUncheckAll:true,
    enableSearch: false,
    checkedStyle: 'fontawesome',
    buttonClasses: 'btn  btn-lg',
    dynamicTitleMaxItems: 4,
    displayAllSelectedText: true
  };
// Text configuration
  weightText: IMultiSelectTexts = {
    checkAll: 'Select all',
    uncheckAll: 'Unselect all',
    checked: 'Weightclass Selected',
    checkedPlural: 'Weightclasses Selected',
    searchPlaceholder: 'Find',
    searchEmptyResult: 'No Country Found...',
    searchNoRenderText: 'Type in search box to see results...',
    defaultTitle: 'Choose your Weightcategories...',
    allSelected: 'All Weights Selected',
  };
// Labels / Parents
  weightOption: IMultiSelectOption[] = [
    { id: 1, name: 'Womens Weight Categories', isLabel: true },
    { id: 2, name: '-48 kg', parentId: 1 },
    { id: 3, name: '-52 kg', parentId: 1 },
    { id: 4, name: '-57 kg', parentId: 1 },
    { id: 5, name: '-63 kg', parentId: 1 },
    { id: 6, name: '-70 kg', parentId: 1 },
    { id: 7, name: '-78 kg', parentId: 1 },
    { id: 8, name: '+78 kg', parentId: 1 },
    { id: 9, name: 'Mens Weight Categories', isLabel: true },
    { id: 10, name: '-60 kg', parentId: 9 },
    { id: 11, name: '-66 kg', parentId: 9 },
    { id: 12, name: '-73 kg', parentId: 9 },
    { id: 13, name: '-81 kg', parentId: 9 },
    { id: 14, name: '-90 kg', parentId: 9 },
    { id: 15, name: '-100 kg', parentId: 9 },
    { id: 16, name: '+100 kg', parentId: 9 }
  ];


  //Ages
  ageSetting: IMultiSelectSettings = {
    showCheckAll:true,
    showUncheckAll:true,
    enableSearch: false,
    checkedStyle: 'fontawesome',
    buttonClasses: 'btn  btn-lg',
    dynamicTitleMaxItems: 4,
    displayAllSelectedText: true
  };
  ageText: IMultiSelectTexts = {
    checkAll: 'Select all',
    uncheckAll: 'Unselect all',
    checked: 'Ageclass Selected',
    checkedPlural: 'Ageclasses Selected',
    searchPlaceholder: 'Find',
    searchEmptyResult: 'Nothing found...',
    searchNoRenderText: 'Type in search box to see results...',
    defaultTitle: 'Choose your Agecategories...',
    allSelected: 'All Ages Selected',
  };
  ageOption: IMultiSelectOption[] = [
    { id: 1, name: 'Age Categories Overall', isLabel: true },
    { id: 2, name: 'Seniors', parentId: 1 },
    { id: 3, name: 'Under 23', parentId: 1 },
    { id: 4, name: 'Juniors', parentId: 1 },
    { id: 5, name: 'Cadets', parentId: 1 },
    { id: 6, name: 'Under 17', parentId: 1 },
    { id: 7, name: 'Under 16', parentId: 1 },
    { id: 8, name: 'Under 15', parentId: 1 },
    { id: 9, name: 'Under 14', parentId: 1 },
    { id: 10, name: 'Under 13', parentId: 1 },
    { id: 11, name: 'Under 12', parentId: 1 },
    { id: 12, name: 'Under 11', parentId: 1 },
    { id: 13, name: 'Under 10', parentId: 1 },
    { id: 14, name: 'Under 9', parentId: 1 },
    { id: 15, name: 'Under 8', parentId: 1 }
  ];

  countrySetting: IMultiSelectSettings = {
    showCheckAll:false,
    showUncheckAll:false,
    enableSearch: true,
    checkedStyle: 'fontawesome',
    buttonClasses: 'btn  btn-lg',
    dynamicTitleMaxItems: 1,
    displayAllSelectedText: true,
    selectionLimit:1
  };
  countryText: IMultiSelectTexts = {
    checkAll: 'Select all',
    uncheckAll: 'Unselect all',
    checked: 'Countries Selected',
    checkedPlural: 'Country Selected',
    searchPlaceholder: 'Find country',
    searchEmptyResult: 'No country found...',
    searchNoRenderText: 'Type in search box to see results...',
    defaultTitle: 'Choose your Country...',
    allSelected: 'All Countries Selected',
  };
  countryOption: IMultiSelectOption[] = [
    { id: 1, name: 'European Countries', isLabel: true },
    { id: 2, name: 'Austria', parentId: 1 },
    { id: 3, name: 'Denmark', parentId: 1 },
    { id: 4, name: 'Germany', parentId: 1 },
    { id: 5, name: 'Hungary', parentId: 1 },
    { id: 6, name: 'Russia', parentId: 1 },
    { id: 7, name: 'Sweden', parentId: 1 }
  ];



  optionsDatepicker: DatepickerOptions={
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


  onChange(){
    console.log(this.optionsModelAge);
    console.log(this.optionsModelWeight);
  }

  public blafunc(){
    this.isLoading=true;
    setTimeout(()=>{
      this.searchLoaded=true;
      this.isLoading=false;
    },5000)
  }

  public setIdEvent(event){
    this.eventId = event;
    this.showDetail=event;
    console.log(this.eventId);
    console.log(this.eventId);
    console.log(this.eventId);
  }

}
