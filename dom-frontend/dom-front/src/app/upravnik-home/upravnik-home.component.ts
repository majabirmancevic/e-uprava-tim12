import { Component, OnInit } from '@angular/core';
import { SecurityService } from '../service/security.service';
import { ActivatedRoute, Router } from '@angular/router';
import { KonkursService } from '../service/konkurs.service';
import { KonkursDTO } from '../model/KonkursDTO';

@Component({
  selector: 'app-upravnik-home',
  templateUrl: './upravnik-home.component.html',
  styleUrls: ['./upravnik-home.component.css'],
})
export class UpravnikHomeComponent implements OnInit {
  role!: string;
  konkursi: KonkursDTO[] = [];

  constructor(
    private securityService: SecurityService,
    private activateRoute: ActivatedRoute,
    private router: Router,
    private konkursService: KonkursService
  ) {}

  ngOnInit(): void {


    if(this.activateRoute.snapshot.params['token'] != null && this.activateRoute.snapshot.params['token'] != undefined){
      localStorage.setItem('jwt',this.activateRoute.snapshot.params['token'])
      localStorage.setItem('role',this.securityService.getRole(this.activateRoute.snapshot.params['token']));
      localStorage.setItem('username', this.securityService.getUsername(this.activateRoute.snapshot.params['token']));
    }


    this.role = this.securityService.getRole(this.securityService.getJwtToken()!);
    console.log("ROLE : " + this.role);


    this.dohvatiKonkurse();

  }


  dohvatiKonkurse(): void {
    this.konkursService.getAllKonkursi().subscribe(
      (konkursi) => {
        this.konkursi = konkursi;
      },
      (error) => {
        console.error('Došlo je do greške prilikom dohvatanja konkursa:', error);
      }
    );
  }

  navigateToRangListaSoba() {
    this.router.navigate(['/rang-lista-soba']);
  }

  goBack(){
    this.router.navigate(['upravnik',localStorage.getItem('jwt')]);
  }


}
