import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import jwt_decode from 'jwt-decode';
import jwt from "jsonwebtoken";
import { JwtHelperService } from '@auth0/angular-jwt';


import { Observable } from "rxjs";

@Injectable({ providedIn: 'root' })
export class SecurityService {

  constructor(private http : HttpClient,  private jwtHelper: JwtHelperService){}

  getJwtToken() {
    return localStorage.getItem('jwt');
  }

  isLoggedIn(): boolean {
    return this.getJwtToken() !== null && this.getJwtToken() !== undefined;
  }

  getDecodedAccessToken(token: string): any {
    try {
      return this.jwtHelper.decodeToken(token);
    } catch (error) {
      return null;
    }
  }

  getRole(token: string): string | null {
    let jwtData = token.split('.')[1];
    let decodedJwtJsonData = atob(jwtData);
    let decodedJwtData = JSON.parse(decodedJwtJsonData);

    const role = decodedJwtData?.role?.authority || null;
    return role;
  }

  getUsername(token: string): string {
    let jwtData = token.split('.')[1];
    let decodedJwtJsonData = atob(jwtData);
    let decodedJwtData = JSON.parse(decodedJwtJsonData);

    const username = decodedJwtData?.username || null;
    return username;
  }
  getRoleFromLS(): string | null {
    const role = localStorage.getItem('ROLE');
    return role !== null ? role : null;
  }



}
