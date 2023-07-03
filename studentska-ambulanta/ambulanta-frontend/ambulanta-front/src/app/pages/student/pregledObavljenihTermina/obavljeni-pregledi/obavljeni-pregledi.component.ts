import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TerminResponse } from 'src/app/model/dto/TerminiResponse';
import { TerminiService } from 'src/app/services/termini.service';

@Component({
  selector: 'app-obavljeni-pregledi',
  templateUrl: './obavljeni-pregledi.component.html',
  styleUrls: ['./obavljeni-pregledi.component.css']
})
export class ObavljeniPreglediComponent implements OnInit {
 
  termini! : TerminResponse[]

  constructor(private router:Router,private terminiService:TerminiService, private activatedRouter:ActivatedRoute) { }

  ngOnInit(): void {
    // if(localStorage.getItem('JWT-TOKEN') == null){
    //   localStorage.setItem('JWT-TOKEN', this.activatedRouter.snapshot.params['token']);
    // }
    this.getObavljeniPreglediStudenta();
  }

  getObavljeniPreglediStudenta(){
    this.terminiService.getObavljeniTerminiStudenta().subscribe((data) => {
      this.termini = data;
    })
  }

  goToIzvestaj(terminId:number){
    this.router.navigate(['pregled-izvestaj',terminId]);
  }

  goTo(){
    this.router.navigate(['izvestaj']);
  }

  goBack(){
    this.router.navigate(['student',localStorage.getItem('jwt')]);
  }
}
