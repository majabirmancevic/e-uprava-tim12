import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TerminiZakazivanjeComponent } from './termini-zakazivanje.component';

describe('TerminiZakazivanjeComponent', () => {
  let component: TerminiZakazivanjeComponent;
  let fixture: ComponentFixture<TerminiZakazivanjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TerminiZakazivanjeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TerminiZakazivanjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
