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
import { CommonModule } from '@angular/common';
import {StudentHomeComponent} from "./student-home/student-home.component";
import {PrijavaComponent} from "./prijava/prijava.component";
import {UpravnikHomeComponent} from "./upravnik-home/upravnik-home.component";
import {RangListaSobaComponent} from "./rang-lista-soba/rang-lista-soba.component";
import {DodeliSobuComponent} from "./dodeli-sobu/dodeli-sobu.component";
import {SobaInfoComponent} from "./soba-info/soba-info.component";

@NgModule({
  declarations: [
    AppComponent,
    PocetnaStranicaComponent,
    RangListaComponent,
    StudentHomeComponent,
    PrijavaComponent,
    UpravnikHomeComponent,
    RangListaSobaComponent,
    DodeliSobuComponent,
    SobaInfoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
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

