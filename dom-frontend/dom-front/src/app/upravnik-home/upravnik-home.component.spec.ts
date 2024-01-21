import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpravnikHomeComponent } from './upravnik-home.component';

describe('UpravnikHomeComponent', () => {
  let component: UpravnikHomeComponent;
  let fixture: ComponentFixture<UpravnikHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpravnikHomeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UpravnikHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
