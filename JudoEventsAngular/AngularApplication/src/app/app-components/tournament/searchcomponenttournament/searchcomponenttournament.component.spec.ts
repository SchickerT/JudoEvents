import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchcomponenttournamentComponent } from './searchcomponenttournament.component';

describe('SearchcomponenttournamentComponent', () => {
  let component: SearchcomponenttournamentComponent;
  let fixture: ComponentFixture<SearchcomponenttournamentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchcomponenttournamentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchcomponenttournamentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
