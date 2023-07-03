import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SecurityService } from 'src/app/services/security.service';

@Component({
  selector: 'app-cards-doctor',
  templateUrl: './cards-doctor.component.html',
  styleUrls: ['./cards-doctor.component.css']
})
export class CardsDoctorComponent implements OnInit {

  doktorOpstePrakse : boolean  ;


  constructor(private router:Router,private servis:SecurityService) {
    this.servis.checkDoktor(localStorage.getItem('username') as string).subscribe((data)=>{
      this.doktorOpstePrakse = eval(data);
      console.log("OPSTA PRAKSA 1 "+ data)
      console.log("OPSTA PRAKSA 2 "+ this.doktorOpstePrakse)
    });
   }

  ngOnInit(): void {
    
  }

  checkDoktor(){
    this.servis.checkDoktor(localStorage.getItem('username') as string).subscribe((data)=>{
      this.doktorOpstePrakse = eval(data);
      console.log("OPSTA PRAKSA 1 "+ data)

    });
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
