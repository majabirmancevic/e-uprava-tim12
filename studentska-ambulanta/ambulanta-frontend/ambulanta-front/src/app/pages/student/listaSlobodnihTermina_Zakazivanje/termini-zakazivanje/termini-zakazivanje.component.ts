
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbDatepickerConfig } from '@ng-bootstrap/ng-bootstrap';
import { TerminResponse } from 'src/app/model/dto/TerminiResponse';
import { TerminiService } from 'src/app/services/termini.service';

@Component({
  selector: 'app-termini-zakazivanje',
  templateUrl: './termini-zakazivanje.component.html',
  styleUrls: ['./termini-zakazivanje.component.css'],
})
export class TerminiZakazivanjeComponent implements OnInit {

  pretraga : boolean = false;
  minDate ;
  termini! : TerminResponse[] ;
  selectedItem :string;
  specijalnost : String;
  terminId! :number;
  selektovan :any;

  selectedValue :any = {};

  termin : TerminResponse;

  public selectedDate:Date;
  public model:any = {};
  public currentDateObj:any = {};

  options = [
    { name: "Stomatolog", value: "stomatolog" },
    { name: "Opsta Praksa", value: "opstaPraksa" },
    { name: "Ginekolog", value: "ginekolog" }

  ]


  constructor(private config: NgbDatepickerConfig, private terminiService:TerminiService,private router: Router,private activatedRouter:ActivatedRoute) { 
    this.specijalnost = 'stomatolog'
    const current = new Date();
    this.minDate = {
      year: current.getFullYear(),
      month: current.getMonth() + 1,
      day: current.getDate()
  };
    
    //this.specijalnost = 'stomatolog'
    this.activatedRouter.params
  }

  ngOnInit(): void {
   
  }

  onSelect(evt:any){
    this.selectedDate = new Date(evt.year,evt.month-1,evt.day);
    console.log(this.selectedDate.getFullYear());
    const month :number = this.selectedDate.getMonth() + 1
    //day
    let day : number = this.selectedDate.getDate();
    let dayString ;
    if (day < 10){
      dayString = 0 + String(day)
    } else {
      dayString = String(day)
    }

    let monthString ;
    if (month < 10){
      monthString = 0 + String(month)
    } else {
      monthString = String(month)
    }

    const dateString = this.selectedDate.getFullYear() + "-" + monthString + "-" + dayString
    console.log(dateString);
    this.selectedItem = dateString;
  }

  selectOption(value: any) {
    this.specijalnost = value;
    //getted from event
    console.log("SELEKTOVANO JE " + value);
    //getted from binding
    console.log(this.specijalnost)
  }

  getSlobodniTermini (){
    console.log("SELEKTOVAN " + this.selectedItem)
    console.log("SPECIJALNOST " + this.specijalnost)
    
    this.terminiService.getSlobodniTerminiBySpecijalista(this.specijalnost as any,this.selectedItem).subscribe((data) => {
      this.termini = data;
      this.pretraga = true;
    })
  }

  isSelektovan(evt:any){
    console.log("termin id: "+ evt)
    this.terminId = evt
    this.selektovan = true;
    
  }

  zakazi(){
    this.terminiService.zakaziTermin(this.terminId).subscribe((data) => {
      console.log("ZAKAZAN JE TERMIN SA ID-JEM : "+ this.terminId)
      window.location.reload()
    })
  }

  goBack(){
    this.router.navigate(['student',localStorage.getItem('jwt')]);
  }
}
