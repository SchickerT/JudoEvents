import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowcomponenttournamentComponent } from './showcomponenttournament.component';

describe('ShowcomponenttournamentComponent', () => {
  let component: ShowcomponenttournamentComponent;
  let fixture: ComponentFixture<ShowcomponenttournamentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowcomponenttournamentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowcomponenttournamentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
