import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TerminDoktorResponse } from 'src/app/model/dto/TerminiDoktorResponse';
import { TerminiService } from 'src/app/services/termini.service';

@Component({
  selector: 'app-pregled-svih-termina',
  templateUrl: './pregled-svih-termina.component.html',
  styleUrls: ['./pregled-svih-termina.component.css']
})
export class PregledSvihTerminaComponent implements OnInit {

  title = 'Pregled svih termina';
  searchText: any;
  termini! : TerminDoktorResponse[];
  
  constructor(private terminiService:TerminiService,private router:Router,private activateRouter:ActivatedRoute) { }


  ngOnInit(): void {
    this.getDoktorTermini();
  }

  getDoktorTermini(){
    this.terminiService.getDoktorTermini().subscribe((data) => {
      this.termini = data;
    })
  }

  goToDodavanjeIzvestaja(id:number) {
    this.router.navigate(['kreiranje-izvestaja',id]);
  }

  goBack(){
    this.router.navigate(['doktor',localStorage.getItem('jwt')]);
  }
}
