import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PregledStudentaZaUverenjeComponent } from './pregled-studenta-za-uverenje.component';

describe('PregledStudentaZaUverenjeComponent', () => {
  let component: PregledStudentaZaUverenjeComponent;
  let fixture: ComponentFixture<PregledStudentaZaUverenjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PregledStudentaZaUverenjeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PregledStudentaZaUverenjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
