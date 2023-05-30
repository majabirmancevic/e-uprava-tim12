import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ObavljeniPreglediComponent } from './obavljeni-pregledi.component';

describe('ObavljeniPreglediComponent', () => {
  let component: ObavljeniPreglediComponent;
  let fixture: ComponentFixture<ObavljeniPreglediComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ObavljeniPreglediComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ObavljeniPreglediComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
