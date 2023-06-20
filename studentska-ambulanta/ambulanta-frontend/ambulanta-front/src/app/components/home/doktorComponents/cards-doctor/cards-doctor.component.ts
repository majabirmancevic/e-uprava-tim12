import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cards-doctor',
  templateUrl: './cards-doctor.component.html',
  styleUrls: ['./cards-doctor.component.css']
})
export class CardsDoctorComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  gotoTermini(){
    this.router.navigate(['svi-termini']);
  }
  gotoIstorijaIzvestaja(){
    this.router.navigate(['istorija-izvestaja']);
  }

  gotoKreiranjeUverenja(){
    this.router.navigate(['pregled-studenata']);
    // TODO : PROVERA DOKTORA
  }

}
