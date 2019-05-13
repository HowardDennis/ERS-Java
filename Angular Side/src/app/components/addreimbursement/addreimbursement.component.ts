import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addreimbursement',
  templateUrl: './addreimbursement.component.html',
  styleUrls: ['./addreimbursement.component.css']
})
export class AddreimbursementComponent implements OnInit {

  hope;

  constructor(private httpClient: HttpClient, private router: Router) { }

  ngOnInit() {
  }

  addTodo(amount: number, type: string, desc: string) {

    this.hope = JSON.parse(sessionStorage.getItem('user'));

    const subReimbursement = {
      reimb_amount: amount,
      reimb_type: type,
      reimb_description: desc,
      id: this.hope.id
    };

    this.httpClient.post('http://localhost:8080/ERS_App/reimburse/', subReimbursement, {
      observe: 'response'
    }).subscribe(response => {
      this.hope.myReimbursements.push(JSON.parse(response.body.toString()));
      sessionStorage.setItem('user', JSON.stringify(this.hope));
      this.router.navigateByUrl('ers');
    }, err => {
    });
  }

}
