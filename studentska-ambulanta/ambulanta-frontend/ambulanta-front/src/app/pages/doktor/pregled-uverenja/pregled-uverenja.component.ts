import { Component, OnInit } from '@angular/core';
import { IzvestajRequest } from 'src/app/model/dto/IzvestajRequest';
import { LekarskoUverenjeResponse } from 'src/app/model/dto/LekarskoUverenjeResponse';
import { IzvestajiService } from 'src/app/services/izvestaji.service';

@Component({
  selector: 'app-pregled-uverenja',
  templateUrl: './pregled-uverenja.component.html',
  styleUrls: ['./pregled-uverenja.component.css']
})
export class PregledUverenjaComponent implements OnInit {

  title = 'Pregled uverenja';
  searchText: any;
  
  response: LekarskoUverenjeResponse[];
  opis : any;
  constructor(private izvestajService: IzvestajiService) { }

  ngOnInit(): void {
    this.getUverenja();
  }

  getUverenja(){
    this.izvestajService.getUverenja().subscribe((data)=> {
      this.response = data
    })
  }

}
