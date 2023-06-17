
import { RouterModule, Routes } from '@angular/router';
import { StudentHomeComponent } from './pages/student/studentHome/student-home/student-home.component';
import { NgModule } from '@angular/core';
import { TerminiZakazivanjeComponent } from './pages/student/listaSlobodnihTermina_Zakazivanje/termini-zakazivanje/termini-zakazivanje.component';
import { ObavljeniPreglediComponent } from './pages/student/pregledObavljenihTermina/obavljeni-pregledi/obavljeni-pregledi.component';
import { PregledIzvestajaComponent } from './pages/student/pregledIzvestaja/pregled-izvestaja/pregled-izvestaja.component';
import { DoktorHomeComponent } from './pages/doktor/doktor-home/doktor-home.component';
import { PregledSvihTerminaComponent } from './pages/doktor/pregled-svih-termina/pregled-svih-termina.component';
import { DodavanjeIzvestajaComponent } from './pages/doktor/dodavanje-izvestaja/dodavanje-izvestaja.component';
import { IstorijaIzvestajaComponent } from './pages/doktor/istorija-izvestaja/istorija-izvestaja.component';
import { RoleGuard } from './role.guard';
import { PregledStudentaZaUverenjeComponent } from './pages/doktor/pregled-studenta-za-uverenje/pregled-studenta-za-uverenje.component';
import { PregledUverenjaComponent } from './pages/doktor/pregled-uverenja/pregled-uverenja.component';

const routes: Routes = [
  { path: '',component: StudentHomeComponent },
  { path: 'student/:token', component: StudentHomeComponent },
  { path: 'doktor/:token', component: DoktorHomeComponent },

  { path: 'termini', component: TerminiZakazivanjeComponent, canActivate: [RoleGuard] },
  //{ path: 'termini', component: TerminiZakazivanjeComponent },

  { path: 'obavljeni-pregledi', component: ObavljeniPreglediComponent,canActivate: [RoleGuard] },
  //{ path: 'obavljeni-pregledi', component: ObavljeniPreglediComponent },

  { path: 'pregled-izvestaj/:id', component: PregledIzvestajaComponent,canActivate: [RoleGuard] },
  //{ path: 'pregled-izvestaj', component: PregledIzvestajaComponent },

  { path: 'izvestaj', component: PregledIzvestajaComponent,canActivate: [RoleGuard] },
  

  //{ path: 'svi-termini/:token', component: PregledSvihTerminaComponent},
  { path: 'svi-termini', component: PregledSvihTerminaComponent, canActivate: [RoleGuard]},

  { path: 'istorija-izvestaja', component: IstorijaIzvestajaComponent, canActivate: [RoleGuard]},
  //{ path: 'istorija-izvestaja', component: IstorijaIzvestajaComponent},

  { path: 'kreiranje-izvestaja/:id', component: DodavanjeIzvestajaComponent, canActivate: [RoleGuard]},

  { path: 'pregled-studenata', component: PregledStudentaZaUverenjeComponent, canActivate: [RoleGuard]},
  { path: 'pregled-uverenja', component: PregledUverenjaComponent, canActivate: [RoleGuard]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
