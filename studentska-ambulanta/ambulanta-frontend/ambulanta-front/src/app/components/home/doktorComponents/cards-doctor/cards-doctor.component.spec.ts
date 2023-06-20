import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardsDoctorComponent } from './cards-doctor.component';

describe('CardsDoctorComponent', () => {
  let component: CardsDoctorComponent;
  let fixture: ComponentFixture<CardsDoctorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardsDoctorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardsDoctorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
