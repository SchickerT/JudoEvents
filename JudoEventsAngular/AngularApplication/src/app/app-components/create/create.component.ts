import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {TournamentDao} from "../../core/dao/tournament.dao";
import {AppConfig} from "../../core/app-config/app-config.service";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  public tournamentFromGroup: FormGroup;

  constructor(private router: Router,
              private tournamentDao: TournamentDao,
              private appConfig: AppConfig,
              private fb:FormBuilder) {

    this.tournamentFromGroup = fb.group({
      generalData: fb.group({
        startDate: [''],
        endDate: [''],
        typeOfEvent: [''],
        name: [''],
        discription: [''],
        entryFee: [''],
        rewards: [''],
        ageAndWeight: [''],
        eventPicture: [''],
        zipCode: [''],
        city: [''],
        street: [''],
        federalState:[''],
        country: [''],
        longitude: [''],
        latitude: [''],
        countryCode: [''],
        firstName: [''],
        lastName:[''],
        email: [''],
        phoneNumber: [''],
        rerpresentativePicture: ['']
      })
    });
  }

  ngOnInit() {
  }

}
