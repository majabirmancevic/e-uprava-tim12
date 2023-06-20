import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar-student',
  templateUrl: './navbar-student.component.html',
  styleUrls: ['./navbar-student.component.css']
})
export class NavbarStudentComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  logout(){
    localStorage.removeItem('jwt');
    localStorage.removeItem('role')
    window.location.href = `http://localhost:4200/logout`;  
  }
}
