
import { RouterModule, Routes } from '@angular/router';
import { StudentHomeComponent } from './pages/student/studentHome/student-home/student-home.component';
import { NgModule } from '@angular/core';
import { TerminiZakazivanjeComponent } from './pages/student/listaSlobodnihTermina_Zakazivanje/termini-zakazivanje/termini-zakazivanje.component';
import { ObavljeniPreglediComponent } from './pages/student/pregledObavljenihTermina/obavljeni-pregledi/obavljeni-pregledi.component';
import { PregledIzvestajaComponent } from './pages/student/pregledIzvestaja/pregled-izvestaja/pregled-izvestaja.component';

const routes: Routes = [
 // { path: '',component: StudentHomeComponent },
  { path: 'student', component: StudentHomeComponent },
  { path: 'student/termini', component: TerminiZakazivanjeComponent },
  { path: 'obavljeni-pregledi', component: ObavljeniPreglediComponent },
  { path: 'pregled-izvestaj/:id', component: PregledIzvestajaComponent },
  { path: 'izvestaj', component: PregledIzvestajaComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
