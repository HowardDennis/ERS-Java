import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddreimbursementComponent } from './addreimbursement.component';

describe('AddreimbursementComponent', () => {
  let component: AddreimbursementComponent;
  let fixture: ComponentFixture<AddreimbursementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddreimbursementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddreimbursementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
