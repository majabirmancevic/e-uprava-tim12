import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";


@Injectable({
    providedIn: 'root'
})

export class IzvestajiService{

constructor(private http: HttpClient){}

getIzvestajPregleda(terminId:number){
    return this.http.get(`http://localhost:8081/api/termini/${terminId}/izvestaj`);
}


}