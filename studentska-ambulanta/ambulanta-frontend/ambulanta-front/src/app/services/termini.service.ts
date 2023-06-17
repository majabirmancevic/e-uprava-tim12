import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { TerminResponse } from "../model/dto/TerminiResponse";
import { TerminDoktorResponse } from "../model/dto/TerminiDoktorResponse";

@Injectable({
    providedIn: 'root'
  })
  export class TerminiService{
    constructor(private http : HttpClient){    }

    getSlobodniTerminiBySpecijalista(specijalnost:string,datum:string) :Observable<any[]>{
    //  const token = localStorage.getItem('JWT-TOKEN');
    //  const bearerToken = `Bearer ${token}`;
      const options = {
      headers: new HttpHeaders({ 
    //    'Authorization': bearerToken,
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
      })
    };
      return this.http.get<TerminResponse[]>(`http://localhost:9000/api/termini/free/${specijalnost}/${datum}`,options);
    }

    getObavljeniTerminiStudenta() :Observable<any[]>{
    //  const token = localStorage.getItem('JWT-TOKEN');
    //  const bearerToken = `Bearer ${token}`;
      const options = {
      headers: new HttpHeaders({ 
    //    'Authorization': bearerToken,
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
      })
    };
      return this.http.get<TerminResponse[]>(`http://localhost:9000/api/termini/history/student`,options);
    }

    getDoktorTermini() :Observable<any[]>{
  //    const token = localStorage.getItem('JWT-TOKEN');
  //    const bearerToken = `Bearer ${token}`;
      const options = {
      headers: new HttpHeaders({ 
  //      'Authorization': bearerToken,
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
      })
    };
      return this.http.get<TerminDoktorResponse[]>(`http://localhost:9000/api/termini/doktor`,options);
    
    }

    zakaziTermin(terminId:number){
  //    const token = localStorage.getItem('JWT-TOKEN');
  //    const bearerToken = `Bearer ${token}`;
      const options = {
      headers: new HttpHeaders({ 
  //      'Authorization': bearerToken,
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
      })
    };
      return this.http.put(`http://localhost:9000/api/termini/${terminId}`,{},options);
    }
  }