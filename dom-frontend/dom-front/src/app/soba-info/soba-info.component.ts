import { Component } from '@angular/core';
import {Student} from "../model/Student";
import {KonkursService} from "../service/konkurs.service";

@Component({
  selector: 'app-soba-info',
  templateUrl: './soba-info.component.html',
  styleUrl: './soba-info.component.css'
})
export class SobaInfoComponent { username: string = '';
  student: Student | null = null;

  constructor(private konkursService: KonkursService) {}

  prikaziSobaInfo() {
    if (this.username) {
      this.konkursService.getSobaInfoByUsername(this.username).subscribe(
        (student) => {
          this.student = student;
        },
        (error) => {
          console.error('Greška prilikom dohvatanja informacija o sobi:', error);
        }
      );
    } else {
      console.warn('Unesite korisničko ime.');
    }
  }
}
