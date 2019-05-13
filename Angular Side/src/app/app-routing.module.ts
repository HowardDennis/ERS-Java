import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { ChatComponent } from './components/chat/chat.component';
import { AddreimbursementComponent } from './components/addreimbursement/addreimbursement.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
  }, {
    path: '',
    component: LoginComponent
  }, {
    path: 'ers',
    component: ChatComponent
  }, {
    path: 'addReimbursement',
    component: AddreimbursementComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
