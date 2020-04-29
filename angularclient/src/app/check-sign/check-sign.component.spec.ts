import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckSignComponent } from './check-sign.component';

describe('CheckSignComponent', () => {
  let component: CheckSignComponent;
  let fixture: ComponentFixture<CheckSignComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckSignComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckSignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
