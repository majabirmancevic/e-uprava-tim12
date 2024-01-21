import { Component, OnInit } from '@angular/core';
import { KonkursService } from '../service/konkurs.service';
import { KonkursDTO } from '../model/KonkursDTO';
import { SecurityService } from '../service/security.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-pocetna-stranica',
  templateUrl: './pocetna-stranica.component.html',
  styleUrls: ['./pocetna-stranica.component.css']
})
export class PocetnaStranicaComponent implements OnInit {
  konkursi: KonkursDTO[] = [];
  student: any;

  constructor(
    private konkursService: KonkursService,
    private securityService: SecurityService,
    private activateRoute: ActivatedRoute, private router: Router
  ) {}

  ngOnInit(): void {
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

  goBack(){
    this.router.navigate(['student',localStorage.getItem('jwt')]);
  }

  navigateToPrijaviSe() {
    this.router.navigate(['/prijavi-se']);
  }

  navigateToRangLista() {
    this.router.navigate(['/rang-lista']);
  }

  navigateToSobaInfo(username: string) {
    this.router.navigate([`/soba-info/${username}`]);
  }
}
