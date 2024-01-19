import { Component, OnInit } from '@angular/core';
import { KonkursService } from '../service/konkurs.service';
import { KonkursDTO } from '../model';
import { SecurityService } from '../service/security.service';
import { Router } from '@angular/router';  // Import Router



@Component({
  selector: 'app-pocetna-stranica',
  templateUrl: './pocetna-stranica.component.html',
  styleUrls: ['./pocetna-stranica.component.css']
})
export class PocetnaStranicaComponent implements OnInit {
  konkursi: KonkursDTO[] = [];

  constructor(private konkursService: KonkursService, private securityService: SecurityService, private router: Router  ) {}

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

  prijaviSeNaKonkurs(konkursId: number): void {
    this.konkursService.prijaviSeNaKonkurs(konkursId).subscribe(
      () => {
        console.log('Uspešno ste se prijavili na konkurs.');
        this.router.navigate(['/']);      },
      (error) => {
        console.error('Došlo je do greške prilikom prijavljivanja na konkurs:', error);
        this.router.navigate(['/']);      });}

  prikaziRangListu(konkursId: number): void {
    this.router.navigate(['/rang-lista', konkursId]);
  }

  isStudent(): boolean {
    return this.securityService.getRoleFromLS() === 'STUDENT';
  }
}
