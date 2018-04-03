import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HintIconComponent } from './hint-icon.component';

describe('HintIconComponent', () => {
  let component: HintIconComponent;
  let fixture: ComponentFixture<HintIconComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HintIconComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HintIconComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
