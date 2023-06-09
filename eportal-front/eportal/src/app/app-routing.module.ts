import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login/login.component';
import { RoleGuard } from './role.guard';
import { LogoutComponent } from './components/logout/logout.component';


useHash: false;
const routes: Routes = [
  { path: '', component: HomeComponent , canActivate: [RoleGuard]},
  { path: 'login', component: LoginComponent},
  { path: 'logout', component: LogoutComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
