import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpInterceptor,
  HttpEvent
} from '@angular/common/http';

import { Observable } from 'rxjs/internal/Observable';
import { SecurityService } from './services/security.service';


@Injectable()
export class TokenInterceptor implements HttpInterceptor {
    constructor(public auth: SecurityService) { }
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    if (this.auth.isLoggedIn()) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${this.auth.getJwtToken()}` 
        }
      });
    }
    return next.handle(request);
  }


}