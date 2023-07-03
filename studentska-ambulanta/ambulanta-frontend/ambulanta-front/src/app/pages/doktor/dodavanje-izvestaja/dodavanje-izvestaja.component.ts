import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { IzvestajRequest } from 'src/app/model/dto/IzvestajRequest';
import { IzvestajiService } from 'src/app/services/izvestaji.service';

@Component({
  selector: 'app-dodavanje-izvestaja',
  templateUrl: './dodavanje-izvestaja.component.html',
  styleUrls: ['./dodavanje-izvestaja.component.css']
})
export class DodavanjeIzvestajaComponent implements OnInit {

  idTermina!: number;
  dodavanjeIzvestaja! : FormGroup;
  request!:IzvestajRequest;

  constructor(private router:Router,private activeRouter:ActivatedRoute,
    private izvestajService:IzvestajiService) { 

    this.idTermina = this.activeRouter.snapshot.params['id'];

    this.dodavanjeIzvestaja = new FormGroup({
      opis : new FormControl('')
    })
    
    this.request = {
      opis : '',
      terminId : this.idTermina
    }

  }

  ngOnInit(): void {}

  kreirajIzvestaj(){
    this.request.opis = this.dodavanjeIzvestaja.get('opis')?.value;
    this.request.terminId = this.idTermina;
    this.izvestajService.postIzvestaj(this.request).subscribe((data) =>{
      
      this.router.navigate(['istorija-izvestaja']);
    })
  }

  goBack(){
    this.router.navigateByUrl('svi-termini');
  }
}
