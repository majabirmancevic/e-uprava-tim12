import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SecurityService } from 'src/app/services/security.service';

@Component({
  selector: 'app-doktor-home',
  templateUrl: './doktor-home.component.html',
  styleUrls: ['./doktor-home.component.css']
})
export class DoktorHomeComponent implements OnInit {
  role : string;
  constructor(private authService: SecurityService, private activateRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    if(this.activateRoute.snapshot.params['token'] != null && this.activateRoute.snapshot.params['token'] != undefined){
      localStorage.setItem('jwt',this.activateRoute.snapshot.params['token'])
      localStorage.setItem('role',this.authService.getRole(this.activateRoute.snapshot.params['token']));
      localStorage.setItem('username', this.authService.getUsername(this.activateRoute.snapshot.params['token']));
    }
    this.role = this.authService.getRole(this.activateRoute.snapshot.params['token'])
    console.log("ROLE : " + this.role);
  }

}
