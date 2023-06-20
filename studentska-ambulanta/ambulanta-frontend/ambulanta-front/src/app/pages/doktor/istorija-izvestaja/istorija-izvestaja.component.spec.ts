import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IstorijaIzvestajaComponent } from './istorija-izvestaja.component';

describe('IstorijaIzvestajaComponent', () => {
  let component: IstorijaIzvestajaComponent;
  let fixture: ComponentFixture<IstorijaIzvestajaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IstorijaIzvestajaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IstorijaIzvestajaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
