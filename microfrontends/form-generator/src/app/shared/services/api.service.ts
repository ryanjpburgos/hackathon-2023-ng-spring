import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MfeConfigModel } from '../models/mfe-config.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  public config: MfeConfigModel;
  constructor(private http: HttpClient) { }

  public saveForm(entandoForm): Observable<any> {
    return this.http.post(`${this.config.systemParams.api['spring-api'].url}/api/entando-forms`, entandoForm)
  }
}
