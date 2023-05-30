
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbDatepickerConfig } from '@ng-bootstrap/ng-bootstrap';
import { TerminResponse } from 'src/app/model/dto/TerminiResponse';
import { TerminiService } from 'src/app/services/termini.service';

@Component({
  selector: 'app-termini-zakazivanje',
  templateUrl: './termini-zakazivanje.component.html',
  styleUrls: ['./termini-zakazivanje.component.css'],
})
export class TerminiZakazivanjeComponent implements OnInit {

  title = 'appBootstrap'; 
  minDate ;
  termini! : TerminResponse[] ;
  selectedItem : any;
  specijalnost :any;

  constructor(private config: NgbDatepickerConfig, private terminiService:TerminiService,private router: Router) { 
    const current = new Date();
    this.minDate = {
      year: current.getFullYear(),
      month: current.getMonth() + 1,
      day: current.getDate()
  };
    
    this.specijalnost = 'stomatolog'
    
  }

  ngOnInit(): void {
  }

  getSlobodniTermini (){
    this.terminiService.getSlobodniTerminiBySpecijalista(this.specijalnost,this.selectedItem).subscribe((data) => {
      this.termini = data;
    })
  }

  goBack(){
    this.router.navigate(['student']);
  }
}
