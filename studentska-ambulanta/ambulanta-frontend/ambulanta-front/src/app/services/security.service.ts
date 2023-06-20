import { Injectable } from "@angular/core";
import jwt_decode from 'jwt-decode';

@Injectable({ providedIn: 'root' })
export class SecurityService {

    getJwtToken() {
        return localStorage.getItem('jwt');
    }

    isLoggedIn(): boolean {
        return this.getJwtToken() != null && this.getJwtToken() != undefined ;
    }

    getDecodedAccessToken(token: string): any {
        try {
          return jwt_decode(token);
        } catch(Error) {
          return null;
        }
    }

    getRole(token:string) :string{
        // const decode = this.getDecodedAccessToken(token)

        let jwtData = token.split('.')[1]
        let decodedJwtJsonData = atob(jwtData)
        let decodedJwtData = JSON.parse(decodedJwtJsonData)

        const role = decodedJwtData.role['authority'];
        return role;
    }
    getRoleFromLS(){
        const role = localStorage.getItem('ROLE');
        return role;
    }
}
