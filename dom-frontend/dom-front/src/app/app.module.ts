import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app.routes';
import { AppComponent } from './app.component';
import { PocetnaStranicaComponent } from './pocetna-stranica/pocetna-stranica.component';  // Prilagodite putanju ako je potrebno
import { RangListaComponent } from './rang-lista/rang-lista.component';  // Prilagodite putanju ako je potrebno
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    PocetnaStranicaComponent,
    RangListaComponent
    // Dodajte ostale komponente po potrebi
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    // Dodajte ostale module po potrebi
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
