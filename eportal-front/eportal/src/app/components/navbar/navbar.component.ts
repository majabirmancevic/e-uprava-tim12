import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  ulogovan : boolean;
  constructor(private router:Router, private authService: AuthService){
  }

  ngOnInit() :void{
    this.ulogovan = this.authService.isLoggedIn();

  }

  login(){
    console.log('login');
  }

  

  onLogout(){
    console.log('logout');
    localStorage.clear();
    //window.location.reload()
    window.location.href = `http://localhost:4200/`;  
    
    //this.router.navigateByUrl("/login")
  }
}
