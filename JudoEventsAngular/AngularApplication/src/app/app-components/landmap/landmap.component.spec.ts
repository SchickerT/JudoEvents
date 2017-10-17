import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LandmapComponent } from './landmap.component';

describe('LandmapComponent', () => {
  let component: LandmapComponent;
  let fixture: ComponentFixture<LandmapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LandmapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LandmapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
