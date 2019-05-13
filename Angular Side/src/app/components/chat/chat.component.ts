import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  hope;

  constructor(private router: Router, private httpClient: HttpClient) { }

  ngOnInit() {
    if (sessionStorage.getItem('user') === null) {
      this.router.navigateByUrl('login');
    } else {
      this.hope = JSON.parse(sessionStorage.getItem('user'));
    }
  }

  logout() {
    sessionStorage.clear();
    this.router.navigateByUrl('login');
  }

  addReimbursement() {
    this.router.navigateByUrl('addReimbursement');
  }

  deny(reimb) {
    reimb.reimb_status = 'Denied';
    this.deleteRow(reimb);
  }

  approve(reimb) {
    reimb.reimb_status = 'Approved';
    this.deleteRow(reimb);
  }

  deleteRow(reimb) {

    this.httpClient.put('http://localhost:8080/ERS_App/reimburse/' + reimb.reimb_id,
      reimb.reimb_status, { observe: 'response' }).subscribe(response => {
      }, err => {
      });

    const index: number = this.hope.assignedReimbursements.indexOf(reimb);
    if (index !== -1) {
      this.hope.assignedReimbursements.splice(index, 1);
    }
    sessionStorage.setItem('user', JSON.stringify(this.hope));
  }
}
