import { Component, OnInit } from '@angular/core';
import { KonkursService } from '../service/konkurs.service';
import { KonkursDTO } from '../model/KonkursDTO';
import { SecurityService } from '../service/security.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pocetna-stranica',
  templateUrl: './pocetna-stranica.component.html',
  styleUrls: ['./pocetna-stranica.component.css']
})
export class PocetnaStranicaComponent implements OnInit {
  konkursi: KonkursDTO[] = [];

  constructor(
    private konkursService: KonkursService,
    private securityService: SecurityService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (this.securityService.isLoggedIn()) {
      // Ako je korisnik ulogovan, dohvati konkurse
      this.dohvatiKonkurse();
    } else {
      // Ako korisnik nije ulogovan, preusmeri ga na login stranicu
      this.router.navigate(['/login']);
    }
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

  prijaviSeNaKonkurs(konkursId: number | undefined): void {
    if (konkursId !== undefined) {
      this.konkursService.prijaviSeNaKonkurs(konkursId).subscribe(
        () => {
          console.log('Uspešno ste se prijavili na konkurs.');
          // Nakon uspešne prijave, ponovo dohvati konkurse
          this.dohvatiKonkurse();
        },
        (error) => {
          console.error('Došlo je do greške prilikom prijavljivanja na konkurs:', error);
        }
      );
    }
  }

  prikaziRangListu(konkursId: number | undefined): void {
    if (konkursId !== undefined) {
      this.router.navigate(['/rang-lista', konkursId]);
    }
  }

  isStudent(): boolean {
    return this.securityService.getRoleFromLS() === 'STUDENT';
  }
}
