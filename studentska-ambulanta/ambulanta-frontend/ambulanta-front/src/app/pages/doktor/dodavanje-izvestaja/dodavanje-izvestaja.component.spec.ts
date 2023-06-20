import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DodavanjeIzvestajaComponent } from './dodavanje-izvestaja.component';

describe('DodavanjeIzvestajaComponent', () => {
  let component: DodavanjeIzvestajaComponent;
  let fixture: ComponentFixture<DodavanjeIzvestajaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DodavanjeIzvestajaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DodavanjeIzvestajaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
