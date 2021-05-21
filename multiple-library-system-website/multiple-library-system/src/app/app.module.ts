import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BooksComponent } from './books/books.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './login/login.component';
import { BorrowComponent } from './borrow/borrow.component';
import { MembershipComponent } from './membership/membership.component';  

@NgModule({
  declarations: [
    AppComponent,
    BooksComponent,
    HomeComponent,
    NavbarComponent,
    LoginComponent,
    BorrowComponent,
    MembershipComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
