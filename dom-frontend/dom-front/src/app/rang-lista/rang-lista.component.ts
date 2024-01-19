import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { KonkursService } from '../service/konkurs.service';
import { SecurityService } from '../service/security.service';
import { StudentDTO } from '../model';

@Component({
  selector: 'app-rang-lista',
  templateUrl: './rang-lista.component.html',
  styleUrls: ['./rang-lista.component.css']
})
export class RangListaComponent implements OnInit {
  konkursId: number;
  prijavljeniStudenti: StudentDTO[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private konkursService: KonkursService,
    private securityService: SecurityService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.konkursId = +params['konkursId'];
      this.dohvatiRangListu();
    });
  }

  dohvatiRangListu(): void {
    this.konkursService.getRangLista(this.konkursId).subscribe(
      (studenti) => {
        this.prijavljeniStudenti = studenti;
      },
      (error) => {
        console.error('Došlo je do greške prilikom dohvatanja rang liste:', error);
      }
    );
  }

  vratiNaPocetnu(): void {
    this.router.navigate(['/']);
  }

  isUpravnik(): boolean {
    return this.securityService.getRoleFromLS() === 'UPRAVNIK';
  }

  dodeliSobu(studentId: number): void {
    const sobaId = prompt('Unesite ID sobe:');
    if (sobaId) {
      this.konkursService.dodeliSobu(this.konkursId, studentId, +sobaId)
        .subscribe(
          () => {
            alert('Soba uspešno dodeljena!');
          },
          (error) => {
            console.error('Greška prilikom dodele sobe:', error);
            alert('Došlo je do greške prilikom dodele sobe.');
          }
        );
    }
  }
}
