import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PocetnaStranicaComponent } from './pocetna-stranica/pocetna-stranica.component';
import { RangListaComponent } from './rang-lista/rang-lista.component';


const routes: Routes = [
  { path: '', component: PocetnaStranicaComponent },
  { path: 'rang-lista/:konkursId', component: RangListaComponent },
  { path: 'student/:token', component: PocetnaStranicaComponent },
  { path: 'upravnik/:token', component: PocetnaStranicaComponent },
  // Dodajte ostale rute po potrebi
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

