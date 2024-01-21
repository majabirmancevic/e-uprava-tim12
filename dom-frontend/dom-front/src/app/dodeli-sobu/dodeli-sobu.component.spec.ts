import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DodeliSobuComponent } from './dodeli-sobu.component';

describe('DodeliSobuComponent', () => {
  let component: DodeliSobuComponent;
  let fixture: ComponentFixture<DodeliSobuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DodeliSobuComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DodeliSobuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
