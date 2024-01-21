import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import jwt_decode from 'jwt-decode';
import { Observable } from "rxjs";

@Injectable({ providedIn: 'root' })
export class SecurityService {

  constructor(private http : HttpClient){}

  getJwtToken() {
    return localStorage.getItem('jwt');
  }

  isLoggedIn(): boolean {
    return this.getJwtToken() != null && this.getJwtToken() != undefined ;
  }

  // getDecodedAccessToken(token: string): any {
  //   try {
  //     return jwt_decode(token);
  //   } catch(Error) {
  //     return null;
  //   }
  // }

  getRole(token:string) :string{
    // const decode = this.getDecodedAccessToken(token)

    let jwtData = token.split('.')[1]
    let decodedJwtJsonData = atob(jwtData)
    let decodedJwtData = JSON.parse(decodedJwtJsonData)

    const role = decodedJwtData.role['authority'];
    return role;
  }

  getUsername(token:string) :string{
    // const decode = this.getDecodedAccessToken(token)

    let jwtData = token.split('.')[1]
    let decodedJwtJsonData = atob(jwtData)
    let decodedJwtData = JSON.parse(decodedJwtJsonData)

    const username = decodedJwtData.username;
    return username;
  }

  getRoleFromLS(){
    const role = localStorage.getItem('ROLE');
    return role;
  }



}
