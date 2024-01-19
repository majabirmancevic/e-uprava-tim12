import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RangListaComponent } from './rang-lista.component';

describe('RangListaComponent', () => {
  let component: RangListaComponent;
  let fixture: ComponentFixture<RangListaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RangListaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RangListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
