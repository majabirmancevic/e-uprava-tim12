import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RangListaSobaComponent } from './rang-lista-soba.component';

describe('RangListaSobaComponent', () => {
  let component: RangListaSobaComponent;
  let fixture: ComponentFixture<RangListaSobaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RangListaSobaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RangListaSobaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
