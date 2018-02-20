import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {TournamentDao} from "../../core/dao/tournament.dao";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  public eventFormGroup: FormGroup;

  constructor(private router: Router,
              private tournamentDao: TournamentDao,
              private fb:FormBuilder) {

    this.eventFormGroup = fb.group({
      tournamentData: fb.group({
        date: ['', Validators.required],
        typeOfEvent: [''],
        tournamentName: ['', Validators.required],
        discription: ['', Validators.required],
        entryFee: ['', Validators.required],
        rewards: ['', Validators.required],
        ageAndWeight: [''],
        eventPicture: [''],
        zipCode: ['', Validators.required],
        city: ['', Validators.required],
        street: ['', Validators.required],
        streetNumber:['', Validators.required],
        federalState:['', Validators.required],
        country: ['', Validators.required],
        longitude: ['', Validators.required],
        latitude: ['', Validators.required],
        countryCode: ['', Validators.required],
        firstName: ['', Validators.required],
        lastName:['', Validators.required],
        email: ['', Validators.required],
        phoneNumber: ['', Validators.required],
        rerpresentativePicture: ['']
      })
    });
  }

  ngOnInit() {
  }


}
