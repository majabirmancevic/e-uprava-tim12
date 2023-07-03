import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IzvestajResponse } from 'src/app/model/dto/IzvestajResponse';
import { IzvestajiService } from 'src/app/services/izvestaji.service';

@Component({
  selector: 'app-istorija-izvestaja',
  templateUrl: './istorija-izvestaja.component.html',
  styleUrls: ['./istorija-izvestaja.component.css']
})
export class IstorijaIzvestajaComponent implements OnInit {

  constructor(private izvestajService: IzvestajiService,private activateRouter:ActivatedRoute,private router:Router) { }
  searchText: any;
  izvestaji! : IzvestajResponse[];

  ngOnInit(): void {
    // if(localStorage.getItem('JWT-TOKEN') == null){
    //   localStorage.setItem('JWT-TOKEN', this.activateRouter.snapshot.params['token']);
    // }
    this.getIzvestajiByDoktor();
  }

  getIzvestajiByDoktor(){
    this.izvestajService.getIzvestajiByDoktor().subscribe((data) => {
      this.izvestaji = data;
    })
  }

  goBack(){
    this.router.navigate(['doktor',localStorage.getItem('jwt')]);
  }
}
