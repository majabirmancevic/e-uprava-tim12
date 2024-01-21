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
  studentDTO: StudentDTO = {};

  constructor(private konkursService: KonkursService) {}

  onSubmit() {
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
