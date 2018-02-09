import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-tournament-data',
  templateUrl: './tournament-data.component.html',
  styleUrls: ['./tournament-data.component.css']
})
export class TournamentDataComponent implements OnInit {

  @Input()
  public stepFormGroup: FormGroup;

  constructor() { }

  ngOnInit() {
  }

}
