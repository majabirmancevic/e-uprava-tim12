import { HttpClient, HttpHeaders } from "@angular/common/http";
import { EventEmitter, Injectable, Output } from "@angular/core";

import { Router } from "@angular/router";
import { LoginRequestPayload } from "../components/login/login-request.payload";
import { Observable } from "rxjs";
import jwt_decode from 'jwt-decode';

@Injectable({ providedIn: 'root' })
export class AuthService {

  @Output() loggedIn: EventEmitter<boolean> = new EventEmitter();
  @Output() username: EventEmitter<string> = new EventEmitter();
  
  private access_token = '';

  headers = new HttpHeaders({
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  });

  constructor(private http: HttpClient,private router: Router){}
    
  getDecodedAccessToken(token: string): any {
    try {
      return jwt_decode(token);
    } catch(Error) {
      return null;
    }
  }
   
  
  login(user : LoginRequestPayload) : Observable<any>{
    return this.http.post('http://localhost:8080/api/auth/login', JSON.stringify(user), {headers:this.headers,responseType: 'text'});
  }

  getJwtToken() {
    return localStorage.getItem('jwt');
  }

  // getRole(token:string) :string{
  //   const decode = this.getDecodedAccessToken(token)
  //   const role = decode.role['authority'];
  //   return role;
  // }

  getRole() :string{
    return localStorage.getItem('role')!;

  }

  getUserName() {
    return localStorage.getItem('username');
  }

  isLoggedIn(): boolean {
    return this.getJwtToken() != null && this.getJwtToken() != undefined ;
  }

}