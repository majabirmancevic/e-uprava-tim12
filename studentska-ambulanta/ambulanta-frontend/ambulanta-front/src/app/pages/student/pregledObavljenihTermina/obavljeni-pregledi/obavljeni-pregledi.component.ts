import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TerminResponse } from 'src/app/model/dto/TerminiResponse';
import { TerminiService } from 'src/app/services/termini.service';

@Component({
  selector: 'app-obavljeni-pregledi',
  templateUrl: './obavljeni-pregledi.component.html',
  styleUrls: ['./obavljeni-pregledi.component.css']
})
export class ObavljeniPreglediComponent implements OnInit {
 
  termini! : TerminResponse[]

  constructor(private router:Router,private terminiService:TerminiService) { }

  ngOnInit(): void {
  }

  getObavljeniPreglediStudenta(){
    this.terminiService.getObavljeniTerminiStudenta().subscribe((data) => {
      this.termini = data;
    })
  }

  goToIzvestaj(terminId:number){
    this.router.navigate(['izvestaj',terminId]);
  }

  goTo(){
    this.router.navigate(['izvestaj']);
  }

  goBack(){
    this.router.navigate(['student']);
  }
}
