import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {  StudentDTO } from '../model/StudentDTO'; // Importujte vaše DTO modele
import {  KonkursDTO } from '../model/KonkursDTO';
import {Student} from "../model/Student"; // Importujte vaše DTO modele

@Injectable({
  providedIn: 'root',
})
export class KonkursService {
  private baseUrl = 'http://localhost:9000/api/konkursi';

  constructor(private http: HttpClient) {}

  getAllKonkursi(): Observable<KonkursDTO[]> {
    return this.http.get<KonkursDTO[]>(this.baseUrl);
  }

  prijaviStudentaNaKonkurs(studentDTO: StudentDTO): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/prijavi-se-na-konkurs`, studentDTO);
  }

  getRangLista(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/rang-lista`);
  }

  getRangListaSoba(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/rang-lista-soba`);
  }

  dodeliSobu(username: string, sobaId: number): Observable<void> {
    const body = new URLSearchParams();
    body.set('username', username);
    body.set('sobaId', sobaId.toString());

    return this.http.post<void>(`${this.baseUrl}/dodeli-sobu`, body.toString(), {
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
      }
    });
  }

  getSobaInfoByUsername(username: string): Observable<Student> {
    return this.http.get<Student>(`${this.baseUrl}/${username}/soba-info`);
  }
}
