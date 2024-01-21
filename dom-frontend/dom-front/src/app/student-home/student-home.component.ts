import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SecurityService } from '../service/security.service';

@Component({
  selector: 'app-student-home',
  templateUrl: './student-home.component.html',
  styleUrls: ['./student-home.component.css']
})
export class StudentHomeComponent implements OnInit {
  role!: string;

  constructor(private securityService: SecurityService, private activateRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    if(this.activateRoute.snapshot.params['token'] != null && this.activateRoute.snapshot.params['token'] != undefined){
      localStorage.setItem('jwt',this.activateRoute.snapshot.params['token'])
      localStorage.setItem('role',this.securityService.getRole(this.activateRoute.snapshot.params['token']));
      localStorage.setItem('username', this.securityService.getUsername(this.activateRoute.snapshot.params['token']));
    }
    this.role = this.securityService.getRole(this.securityService.getJwtToken()!);
    console.log("ROLE : " + this.role);
  }
}
