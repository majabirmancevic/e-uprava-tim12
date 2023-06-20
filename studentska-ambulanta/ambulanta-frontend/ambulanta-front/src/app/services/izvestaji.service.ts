import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { IzvestajRequest } from "../model/dto/IzvestajRequest";
import { Observable } from "rxjs";
import { IzvestajResponse } from "../model/dto/IzvestajResponse";
import { StudentResponse } from "../model/dto/StudentResponse";
import { LekarskoUverenjeRequest } from "../model/dto/LekarskoUverenjeRequest";
import { LekarskoUverenjeResponse } from "../model/dto/LekarskoUverenjeResponse";


@Injectable({
    providedIn: 'root'
})

export class IzvestajiService{

constructor(private http: HttpClient){}

getIzvestajPregleda(terminId:number):Observable<any>{
//  const token = localStorage.getItem('JWT-TOKEN');
//      const bearerToken = `Bearer ${token}`;
      const options = {
      headers: new HttpHeaders({ 
//       'Authorization': bearerToken,
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
      })
    };
    return this.http.get<IzvestajResponse>(`http://localhost:9000/api/termini/${terminId}/izvestaj`,options);
}

postIzvestaj(izvestaRequest:IzvestajRequest){
  //  const token = localStorage.getItem('JWT-TOKEN');
  //    const bearerToken = `Bearer ${token}`;
      const options = {
      headers: new HttpHeaders({ 
    //    'Authorization': bearerToken,
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
      })
    };
    return this.http.post(`http://localhost:9000/api/izvestaji`,JSON.stringify(izvestaRequest),options);

}


getIzvestajiByDoktor(): Observable<any[]>{
    //const token = localStorage.getItem('JWT-TOKEN');
    //  const bearerToken = `Bearer ${token}`;
      const options = {
      headers: new HttpHeaders({ 
      //  'Authorization': bearerToken,
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
      })};
    return this.http.get<IzvestajResponse[]>(`http://localhost:9000/api/izvestaji/by-doktor`,options);
}

getStudenti(): Observable<any[]>{

    const options = {
    headers: new HttpHeaders({ 
      'Accept': 'application/json',
      'Content-Type': 'application/json' 
    })};
  return this.http.get<StudentResponse[]>(`http://localhost:9000/api/lekarsko-uverenje/studenti`,options);
}

getUverenja(): Observable<any[]>{
  const options = {
  headers: new HttpHeaders({ 
    'Accept': 'application/json',
    'Content-Type': 'application/json' 
  })};
return this.http.get<LekarskoUverenjeResponse[]>(`http://localhost:9000/api/lekarsko-uverenje`,options);
}


createUverenje(request:LekarskoUverenjeRequest){
  const options = {
    headers: new HttpHeaders({ 
      'Accept': 'application/json',
      'Content-Type': 'application/json' 
    })
  };
  return this.http.post(`http://localhost:9000/api/lekarsko-uverenje`,JSON.stringify(request),options);

}

}