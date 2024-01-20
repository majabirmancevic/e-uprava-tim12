import { Component } from '@angular/core';
import { KonkursService } from '../service/konkurs.service';
import { StudentDTO } from '../model/StudentDTO';
import { SecurityService } from '../service/security.service';

@Component({
  selector: 'app-prijava',
  templateUrl: './prijava.component.html',
  styleUrls: ['./prijava.component.css'],
})
export class PrijavaComponent {
  studentDTO: StudentDTO = {}; // Inicijalizujte objekat sa podacima studenta

  constructor(private konkursService: KonkursService) {}

  onSubmit() {
    // Pozovite metodu za prijavu studenta na konkurs sa podacima iz forme
    this.konkursService.prijaviStudentaNaKonkurs(this.studentDTO)
      .subscribe(
        () => {
          console.log('Uspešno ste se prijavili na konkurs!');
          // Dodajte bilo koju dodatnu logiku ili obaveštenja ovde
        },
        (error) => {
          console.error('Nije uspelo prijavljivanje na konkurs:', error);
          // Obradite grešku, prikažite poruku o grešci, itd.
        }
      );
  }
}
