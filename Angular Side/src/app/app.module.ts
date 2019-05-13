import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { ChatComponent } from './components/chat/chat.component';
import { FormsModule } from '@angular/forms';
import { TrimPipePipe } from './pipes/trim-pipe.pipe';
import { HttpClientModule } from '@angular/common/http';
import { AddreimbursementComponent } from './components/addreimbursement/addreimbursement.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ChatComponent,
    TrimPipePipe,
    AddreimbursementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
