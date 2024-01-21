import { Component } from '@angular/core';
import { KonkursService } from "../service/konkurs.service";
import { Router, ActivatedRoute } from "@angular/router";
import { SecurityService } from "../service/security.service";  // Dodao sam import za SecurityService

@Component({
  selector: 'app-dodeli-sobu',
  templateUrl: './dodeli-sobu.component.html',
  styleUrls: ['./dodeli-sobu.component.css']
})
export class DodeliSobuComponent {
  username: string = '';
  sobaId: number = 0;

  constructor(
    private konkursService: KonkursService,
    private router: Router,
    private route: ActivatedRoute,
    private securityService: SecurityService  // Dodao sam SecurityService
  ) {}

  submitForm() {
    this.konkursService.dodeliSobu(this.username, this.sobaId).subscribe(
      () => {
        console.log('Soba uspešno dodeljena studentu!');

        // Dobavi token iz SecurityService
        const currentToken = this.securityService.getJwtToken();

        if (currentToken) {
          const targetUrl = `/upravnik/${currentToken}`;
          this.router.navigateByUrl(targetUrl);
        } else {
          console.error('Nedostaje parametar token u trenutnoj ruti.');
        }
      },
      (error) => {
        console.error('Greška prilikom dodele sobe:', error);
      }
    );
  }
}



