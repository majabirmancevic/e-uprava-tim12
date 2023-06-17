import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { take } from 'rxjs/operators';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  
  role : string;
  constructor(private authService: AuthService, private activateRoute: ActivatedRoute, private router: Router) {
  }

  ngOnInit(): void {
    this.role = this.authService.getRole()
    console.log("ROLE : " + this.role);
  }

  isRole() : any{
    if(this.authService.getRole() == 'ROLE_DOKTOR'){
      return 'doktor'
    } else if(this.authService.getRole() == 'ROLE_STUDENT'){
      return 'student'
    } else {
      return 'gradjanin'
    }
  }


  goToStudentHome(){
    window.location.href = `http://localhost:4201/student/${localStorage.getItem('jwt')}`;  
  }

  goToDoktorHome(){
    window.location.href = `http://localhost:4201/doktor/${localStorage.getItem('jwt')}`;  
  }

  goToZakazivanje(){
    // if(this.authService.isLoggedIn() && this.role == 'ROLE_STUDENT'){
    //   window.location.href = `http://localhost:4201/termini/${localStorage.getItem('jwt')}`;
    // }
   // window.location.href = `http://localhost:4201/termini`;

  }

  goToIstorijaPregledaStudenta(){
    // if(this.authService.isLoggedIn() && this.role == 'ROLE_STUDENT'){
    //   window.location.href = `http://localhost:4201/obavljeni-pregledi/${localStorage.getItem('jwt')}`;
    // }
     // window.location.href = `http://localhost:4201/obavljeni-pregledi`;
    
  }

  goToKreiranjeIzvestaja(){
    // if(this.authService.isLoggedIn() && this.role == 'ROLE_DOKTOR'){
    //   window.location.href = `http://localhost:4201/svi-termini/${localStorage.getItem('jwt')}`;
    // }
   // window.location.href = `http://localhost:4201/svi-termini`;

  }

  goToIstorijaIzvestaja(){
    // if(this.authService.isLoggedIn() && this.role == 'ROLE_DOKTOR'){
    //   window.location.href = `http://localhost:4201/istorija-izvestaja/${localStorage.getItem('jwt')}`;
    // }
   // window.location.href = `http://localhost:4201/istorija-izvestaja`;

  }

  
}
