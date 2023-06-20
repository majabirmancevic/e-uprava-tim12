import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PregledUverenjaComponent } from './pregled-uverenja.component';

describe('PregledUverenjaComponent', () => {
  let component: PregledUverenjaComponent;
  let fixture: ComponentFixture<PregledUverenjaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PregledUverenjaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PregledUverenjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
