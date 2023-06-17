import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DoktorHomeComponent } from './doktor-home.component';

describe('DoktorHomeComponent', () => {
  let component: DoktorHomeComponent;
  let fixture: ComponentFixture<DoktorHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DoktorHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DoktorHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
