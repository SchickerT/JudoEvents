import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainingscampComponent } from './trainingscamp.component';

describe('TrainingscampComponent', () => {
  let component: TrainingscampComponent;
  let fixture: ComponentFixture<TrainingscampComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrainingscampComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainingscampComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
