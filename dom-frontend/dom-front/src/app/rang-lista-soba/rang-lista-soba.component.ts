import { Component } from '@angular/core';
import {KonkursService} from "../service/konkurs.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-rang-lista-soba',
  templateUrl: './rang-lista-soba.component.html',
  styleUrl: './rang-lista-soba.component.css'
})
export class RangListaSobaComponent {
  rangListaSoba: any[] = [];
  constructor(private konkursService: KonkursService, private router: Router) { }

  ngOnInit(): void {
    this.konkursService.getRangListaSoba().subscribe(data => {
      this.rangListaSoba = data;
    });
  }

  navigirajNaDodavanjeSobe() {
    this.router.navigate(['/dodeli-sobu']); // Prilagodite putanju
  }
}

