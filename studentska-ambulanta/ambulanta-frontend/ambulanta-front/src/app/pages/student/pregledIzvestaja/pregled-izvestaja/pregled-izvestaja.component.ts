import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IzvestajResponse } from 'src/app/model/dto/IzvestajResponse';
import { IzvestajiService } from 'src/app/services/izvestaji.service';

@Component({
  selector: 'app-pregled-izvestaja',
  templateUrl: './pregled-izvestaja.component.html',
  styleUrls: ['./pregled-izvestaja.component.css']
})
export class PregledIzvestajaComponent implements OnInit {

  terminId! : number;
  izvestajResponse! : IzvestajResponse;
  constructor(private router:Router,private activatedRouter:ActivatedRoute,private izvestajService:IzvestajiService) {
    
  }

  ngOnInit(): void {
   this.terminId = this.activatedRouter.snapshot.params['id'];
   this.izvestajService.getIzvestajPregleda(this.activatedRouter.snapshot.params['id']).subscribe((data)=>{
    this.izvestajResponse = data;
   });
    
  }

  goBack(){
    this.router.navigate(['obavljeni-pregledi']);
  }
}
