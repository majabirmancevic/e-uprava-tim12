import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PocetnaStranicaComponent } from './pocetna-stranica/pocetna-stranica.component';
import { RangListaComponent } from './rang-lista/rang-lista.component';
import {StudentHomeComponent} from "./student-home/student-home.component";
import {PrijavaComponent} from "./prijava/prijava.component";
import {UpravnikHomeComponent} from "./upravnik-home/upravnik-home.component";
import {DodeliSobuComponent} from "./dodeli-sobu/dodeli-sobu.component";
import {RangListaSobaComponent} from "./rang-lista-soba/rang-lista-soba.component";
import {SobaInfoComponent} from "./soba-info/soba-info.component";


const routes: Routes = [
  { path: '', component: PocetnaStranicaComponent },
  { path: 'rang-lista', component: RangListaComponent },
  { path: 'rang-lista-soba', component: RangListaSobaComponent },
  { path: 'student/:token', component: StudentHomeComponent },
  { path: 'upravnik/:token', component: UpravnikHomeComponent },
  { path: 'prijavi-se', component: PrijavaComponent },
  { path: 'dodeli-sobu', component: DodeliSobuComponent},
  {path: 'soba-info/:username', component: SobaInfoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

