import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentHomeComponent } from './pages/student/studentHome/student-home/student-home.component';
import { NavbarStudentComponent } from './components/home/studentComponents/navbarStudent/navbar-student/navbar-student.component';
import { BrowserModule } from '@angular/platform-browser';
import { CardsStudentComponent } from './components/home/studentComponents/cardsStudent/cards-student/cards-student.component';
import { TerminiZakazivanjeComponent } from './pages/student/listaSlobodnihTermina_Zakazivanje/termini-zakazivanje/termini-zakazivanje.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ObavljeniPreglediComponent } from './pages/student/pregledObavljenihTermina/obavljeni-pregledi/obavljeni-pregledi.component';
import { TerminiService } from './services/termini.service';
import { PregledIzvestajaComponent } from './pages/student/pregledIzvestaja/pregled-izvestaja/pregled-izvestaja.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentHomeComponent,
    NavbarStudentComponent,
    CardsStudentComponent,
    TerminiZakazivanjeComponent,
    ObavljeniPreglediComponent,
    PregledIzvestajaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    TerminiService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
