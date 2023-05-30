import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { TerminResponse } from "../model/dto/TerminiResponse";

@Injectable({
    providedIn: 'root'
  })
  export class TerminiService{
    constructor(private http : HttpClient){    }

    getSlobodniTerminiBySpecijalista(specijalnost:string,datum:string): Observable<any[]>{
        return this.http.get<TerminResponse[]>(`http://localhost:8081/api/termini/free/${specijalnost}/${datum}`);
    }

    getObavljeniTerminiStudenta(): Observable<any[]>{
      return this.http.get<TerminResponse[]>(`http://localhost:8081/api/termini/history/student`);
    }

  }