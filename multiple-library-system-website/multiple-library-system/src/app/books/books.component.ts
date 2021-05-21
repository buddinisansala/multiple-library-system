import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss']
})
export class BooksComponent implements OnInit {

  title: string = 'Multiple Library'
  books: any[] = [];//books
  

  constructor() { }

  ngOnInit(): void {
  }

}
