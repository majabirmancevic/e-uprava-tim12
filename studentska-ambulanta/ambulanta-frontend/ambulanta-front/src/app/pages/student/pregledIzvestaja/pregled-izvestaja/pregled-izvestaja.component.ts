import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pregled-izvestaja',
  templateUrl: './pregled-izvestaja.component.html',
  styleUrls: ['./pregled-izvestaja.component.css']
})
export class PregledIzvestajaComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  goBack(){
    this.router.navigate(['obavljeni-pregledi']);
  }
}
