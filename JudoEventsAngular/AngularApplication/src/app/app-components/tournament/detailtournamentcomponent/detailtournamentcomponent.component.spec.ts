import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailtournamentcomponentComponent } from './detailtournamentcomponent.component';

describe('DetailtournamentcomponentComponent', () => {
  let component: DetailtournamentcomponentComponent;
  let fixture: ComponentFixture<DetailtournamentcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailtournamentcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailtournamentcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
