import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {TournamentDao} from "../../core/dao/tournament.dao";
import {Event} from "../../core/model/event";
import {Representative} from "../../core/model/representative";
import {Location} from "../../core/model/location";

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
        date: [''],
        typeOfEvent: [''],
        tournamentName: ['', Validators.required],
        description: [''],
        entryFee: [''],
        rewards: [''],
        ageAndWeight: [''],
        eventPicture: [''],
        zipCode: [''],
        city: [''],
        street: [''],
        streetNumber:[''],
        federalState:[''],
        country: [''],
        longitude: [''],
        latitude: [''],
        countryCode: [''],
        firstName: [''],
        lastName:[''],
        email: [''],
        phoneNumber: [''],
        representativePicture: ['']
      })
    });
  }

  ngOnInit() {
  }

  private getTournamentFromForm():Event{
    return new Event(
      this.eventFormGroup.value.tournamentData.tournamentName,
      new Date(this.eventFormGroup.value.tournamentData.date[0]),
      new Date(this.eventFormGroup.value.tournamentData.date[1]),
      this.eventFormGroup.value.tournamentData.description,
      this.eventFormGroup.value.tournamentData.entryFee,
      this.eventFormGroup.value.tournamentData.rewards,
      this.eventFormGroup.value.tournamentData.ageAndWeight,
      this.eventFormGroup.value.tournamentData.eventPicture,
      this.getLocationFromForm(),
      this.getRepresentativeFromForm()
    );
  }

  private getRepresentativeFromForm():Representative{
      return new Representative(
        this.eventFormGroup.value.tournamentData.firstName,
        this.eventFormGroup.value.tournamentData.lastName,
        this.eventFormGroup.value.tournamentData.email,
        this.eventFormGroup.value.tournamentData.phoneNumber,
        this.eventFormGroup.value.tournamentData.representativePicture
      );
  }

  private getLocationFromForm():Location{
    return new Location(
      this.eventFormGroup.value.tournamentData.zipCode,
      this.eventFormGroup.value.tournamentData.city,
      this.eventFormGroup.value.tournamentData.street+' '+this.eventFormGroup.value.tournamentData.streetNumber,
      this.eventFormGroup.value.tournamentData.federalState,
      this.eventFormGroup.value.tournamentData.country,
      this.eventFormGroup.value.tournamentData.longitude,
      this.eventFormGroup.value.tournamentData.latitude,
      this.eventFormGroup.value.tournamentData.countryCode
    );
  }

  public async submitForm(): Promise<void> {

    let event: Event = this.getTournamentFromForm();
    console.log(event);

    await this.tournamentDao.createTournament(event);
  }
}
