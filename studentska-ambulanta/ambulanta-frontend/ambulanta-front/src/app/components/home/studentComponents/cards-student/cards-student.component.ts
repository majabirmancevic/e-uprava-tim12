import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TerminResponse } from 'src/app/model/dto/TerminiResponse';
declare var $: any;
@Component({
  selector: 'app-cards-student',
  templateUrl: './cards-student.component.html',
  styleUrls: ['./cards-student.component.css']
})
export class CardsStudentComponent implements OnInit {
  

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  gotoObavljeniPregledi(){
    this.router.navigate(['obavljeni-pregledi']);
  }

  gotoTermini(){
    this.router.navigate(['termini']);
  }
}
