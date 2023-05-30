import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PregledIzvestajaComponent } from './pregled-izvestaja.component';

describe('PregledIzvestajaComponent', () => {
  let component: PregledIzvestajaComponent;
  let fixture: ComponentFixture<PregledIzvestajaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PregledIzvestajaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PregledIzvestajaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
