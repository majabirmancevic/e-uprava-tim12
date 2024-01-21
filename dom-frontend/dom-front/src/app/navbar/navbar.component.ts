import { Component, OnInit } from '@angular/core';
import { SecurityService } from '../service/security.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isStudent: boolean = false;
  isUpravnik: boolean = false;

  constructor(private securityService: SecurityService) { }

  ngOnInit(): void {
    this.checkUserRoles();
  }

  checkUserRoles() {
    const role = this.securityService.getRoleFromLS();
    this.isStudent = role === 'STUDENT';
    this.isUpravnik = role === 'UPRAVNIK';
  }

  logout(){
    localStorage.removeItem('jwt');
    localStorage.removeItem('role')
    window.location.href = `http://localhost:4200/logout`;
  }
}
