import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SobaInfoComponent } from './soba-info.component';

describe('SobaInfoComponent', () => {
  let component: SobaInfoComponent;
  let fixture: ComponentFixture<SobaInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SobaInfoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SobaInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
