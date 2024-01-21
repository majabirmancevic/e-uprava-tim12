import { Component } from '@angular/core';
import { KonkursService } from "../service/konkurs.service";

@Component({
  selector: 'app-dodeli-sobu',
  templateUrl: './dodeli-sobu.component.html',
  styleUrls: ['./dodeli-sobu.component.css']
})
export class DodeliSobuComponent {
  username: string = '';
  sobaId: number = 0;

  constructor(private konkursService: KonkursService) {}

  submitForm() {
    this.konkursService.dodeliSobu(this.username, this.sobaId).subscribe(
      () => {
        console.log('Soba uspešno dodeljena studentu!');
        // Dodajte dodatne akcije po potrebi
      },
      (error) => {
        console.error('Greška prilikom dodele sobe:', error);
      }
    );
  }
}

