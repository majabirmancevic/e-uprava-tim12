import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { KonkursService } from '../service/konkurs.service';
import { SecurityService } from '../service/security.service';
import { StudentDTO } from '../model/StudentDTO';

@Component({
  selector: 'app-rang-lista',
  templateUrl: './rang-lista.component.html',
  styleUrls: ['./rang-lista.component.css']
})
export class RangListaComponent implements OnInit {
  rangLista: any[] = [];
  constructor(private konkursService: KonkursService) { }

  ngOnInit(): void {
    this.konkursService.getRangLista().subscribe(data => {
      this.rangLista = data;
    });
  }
}
