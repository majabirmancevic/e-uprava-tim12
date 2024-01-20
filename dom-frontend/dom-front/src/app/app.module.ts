import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { PocetnaStranicaComponent } from './pocetna-stranica/pocetna-stranica.component';
import { RangListaComponent } from './rang-lista/rang-lista.component';
import { BrowserModule } from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import {TokenInterceptor} from "./token-interceptor";
import {JWT_OPTIONS, JwtHelperService} from "@auth0/angular-jwt";
import {CommonModule} from "@angular/common"; // Prilagodite putanju ako je potrebno

@NgModule({
  declarations: [
    AppComponent,
    PocetnaStranicaComponent,
    RangListaComponent
    // Dodajte ostale komponente po potrebi
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, // Dodajte AppRoutingModule
    HttpClientModule,
    FormsModule,
    CommonModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    JwtHelperService,
    {  useValue: JWT_OPTIONS, provide: JWT_OPTIONS }
  ],
  bootstrap: [AppComponent]

})
export class AppModule { }

