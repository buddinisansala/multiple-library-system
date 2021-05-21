import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BooksComponent } from './books/books.component';
import { BorrowComponent } from './borrow/borrow.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import {MembershipComponent} from './membership/membership.component'

const routes: Routes = [
  {path:'', pathMatch: 'full', redirectTo: 'home'},
  {path:'home',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'membership',component:MembershipComponent},
  {path:'books',component:BooksComponent},
  {path:'borrow',component:BorrowComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
