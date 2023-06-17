import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentHomeComponent } from './pages/student/studentHome/student-home/student-home.component';
import { NavbarStudentComponent } from './components/home/studentComponents/navbarStudent/navbar-student/navbar-student.component';
import { BrowserModule } from '@angular/platform-browser';
import { CardsStudentComponent } from './components/home/studentComponents/cards-student/cards-student.component';
import { TerminiZakazivanjeComponent } from './pages/student/listaSlobodnihTermina_Zakazivanje/termini-zakazivanje/termini-zakazivanje.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { ObavljeniPreglediComponent } from './pages/student/pregledObavljenihTermina/obavljeni-pregledi/obavljeni-pregledi.component';
import { TerminiService } from './services/termini.service';
import { PregledIzvestajaComponent } from './pages/student/pregledIzvestaja/pregled-izvestaja/pregled-izvestaja.component';
import { CardsDoctorComponent } from './components/home/doktorComponents/cards-doctor/cards-doctor.component';
import { DoktorHomeComponent } from './pages/doktor/doktor-home/doktor-home.component';
import { PregledSvihTerminaComponent } from './pages/doktor/pregled-svih-termina/pregled-svih-termina.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { DodavanjeIzvestajaComponent } from './pages/doktor/dodavanje-izvestaja/dodavanje-izvestaja.component';
import { IstorijaIzvestajaComponent } from './pages/doktor/istorija-izvestaja/istorija-izvestaja.component';
import { TokenInterceptor } from './token-interceptor';
import { PregledStudentaZaUverenjeComponent } from './pages/doktor/pregled-studenta-za-uverenje/pregled-studenta-za-uverenje.component';
import { PregledUverenjaComponent } from './pages/doktor/pregled-uverenja/pregled-uverenja.component';



@NgModule({
  declarations: [
    AppComponent,
    StudentHomeComponent,
    NavbarStudentComponent,
    TerminiZakazivanjeComponent,
    ObavljeniPreglediComponent,
    PregledIzvestajaComponent,
    CardsDoctorComponent,
    CardsStudentComponent,
    DoktorHomeComponent,
    PregledSvihTerminaComponent,
    DodavanjeIzvestajaComponent,
    IstorijaIzvestajaComponent,
    PregledStudentaZaUverenjeComponent,
    PregledUverenjaComponent,
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    ReactiveFormsModule
  ],
  providers: [
    {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
    },
    TerminiService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

