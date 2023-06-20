import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { LoginRequestPayload } from '../login-request.payload';
import { Observable, Subject } from 'rxjs';
import { AuthService } from '../../../services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  submitted = false;
  

  loginForm: FormGroup;
  loginRequestPayload!: LoginRequestPayload;
  private ngUnsubscribe: Subject<void> = new Subject<void>();
  isError!: boolean;
  returnUrl!: string;

  constructor(private authService: AuthService, 
    private router: Router,
    private route: ActivatedRoute){
      this.loginRequestPayload = {
        username: '',
        password: ''
      };
    }

  ngOnInit() : void{
    this.loginForm = new FormGroup({
      username: new FormControl('', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(64)])),
      password: new FormControl('',  Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)]))
    });
    
   
  }



  login(){
  
    this.loginRequestPayload.username = this.loginForm.get('username')!.value;
    this.loginRequestPayload.password = this.loginForm.get('password')!.value;
  
    this.authService.login(this.loginRequestPayload).subscribe(data => {
      
         
        let jwtData = data.split('.')[1]
        console.log("JWTDATA " + jwtData)

        let decodedJwtJsonData = atob(data.split('.')[1])
        console.log("DECODED " + decodedJwtJsonData)

        let decodedJwtData = JSON.parse(decodedJwtJsonData)
        console.log("DATA " + decodedJwtData)

        localStorage.setItem("jwt", data) 
        localStorage.setItem("username",decodedJwtData.username)  
        localStorage.setItem("role",decodedJwtData.role['authority'])        
      
      this.router.navigate([''])
    })
  }
}
