import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IzvestajRequest } from 'src/app/model/dto/IzvestajRequest';
import { LekarskoUverenjeRequest } from 'src/app/model/dto/LekarskoUverenjeRequest';
import { StudentResponse } from 'src/app/model/dto/StudentResponse';
import { IzvestajiService } from 'src/app/services/izvestaji.service';
import { SecurityService } from 'src/app/services/security.service';

@Component({
  selector: 'app-pregled-studenta-za-uverenje',
  templateUrl: './pregled-studenta-za-uverenje.component.html',
  styleUrls: ['./pregled-studenta-za-uverenje.component.css']
})
export class PregledStudentaZaUverenjeComponent implements OnInit {

  title = 'Pregled studenata koji su obavili preglede';
  searchText: any;
  studenti! : StudentResponse[];
  request: LekarskoUverenjeRequest;
  opis : any;

  constructor(private izvestajService:IzvestajiService, private router:Router) { 
    this.request = {
      ime : '',
      prezime : '',
      jmbg : ''
    }
  }

  ngOnInit(): void {
    this.getStudenti();
  }
  
  getStudenti(){
    this.izvestajService.getStudenti().subscribe((data)=>{
      this.studenti = data;
    })
  }

  kreiranje(ime:string,prezime:string,jmbg:string){
    this.request.ime = ime;
    this.request.prezime = prezime;
    this.request.jmbg = jmbg;
    this.izvestajService.createUverenje(this.request).subscribe((data) => {
      this.goToUverenja();
    })
  }

  goToUverenja(){
    this.router.navigateByUrl("/pregled-uverenja")
  }
}
