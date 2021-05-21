import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import {TokenStorageService} from '@angular/core';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  currentUser:any
  showNav: boolean=true


  //constructor(private router:Router, private token:TokenStorageService) { }

  ngOnInit(): void {
    //this.currentUser=this.token
  }

  //NavBar(location:any)

}
