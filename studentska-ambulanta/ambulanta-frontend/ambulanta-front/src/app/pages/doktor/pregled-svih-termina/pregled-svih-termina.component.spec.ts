import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PregledSvihTerminaComponent } from './pregled-svih-termina.component';

describe('PregledSvihTerminaComponent', () => {
  let component: PregledSvihTerminaComponent;
  let fixture: ComponentFixture<PregledSvihTerminaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PregledSvihTerminaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PregledSvihTerminaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
