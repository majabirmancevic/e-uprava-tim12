import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardsStudentComponent } from './cards-student.component';

describe('CardsStudentComponent', () => {
  let component: CardsStudentComponent;
  let fixture: ComponentFixture<CardsStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardsStudentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardsStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
