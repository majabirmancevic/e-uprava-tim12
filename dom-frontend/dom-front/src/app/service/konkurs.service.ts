import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { KonkursDTO, StudentDTO } from '../model'; // Importujte vaše DTO modele

@Injectable({
  providedIn: 'root',
})
export class KonkursService {
  private baseUrl = 'http://localhost:9000/api/konkursi'; // Promenite adresu prema vašem backend-u

  constructor(private http: HttpClient) {}

  getAllKonkursi(): Observable<KonkursDTO[]> {
    return this.http.get<KonkursDTO[]>(this.baseUrl);
  }

  prijaviSeNaKonkurs(konkursId: number): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/${konkursId}/prijavi-se`, {});
  }

  getRangLista(konkursId: number): Observable<StudentDTO[]> {
    return this.http.get<StudentDTO[]>(`${this.baseUrl}/${konkursId}/rang-lista`);
  }

  dodeliSobu(konkursId: number, studentId: number, sobaId: number): Observable<void> {
    return this.http.post<void>(`${this.baseUrl}/${konkursId}/dodeli-sobu`, { studentId, sobaId });
  }
}
