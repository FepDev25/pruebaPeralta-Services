import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Binomio } from '../models/binomio.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BinomiosService {

  constructor(private http : HttpClient) { }

  private baseUrl = 'http://localhost:8080/backendPruebaPeralta-1.0-SNAPSHOT';

  createBinomio(binomio : Binomio) : Observable <Binomio> {
    console.log(binomio);
    return this.http.post<Binomio>(`${this.baseUrl}/api/binomios`, binomio);
  }

  getBinomios() : Observable<Binomio[]>{
    return this.http.get<Binomio[]>(`${this.baseUrl}/api/binomios`);
  }
}
