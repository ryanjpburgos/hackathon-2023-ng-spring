import { Injectable } from '@angular/core';
import { MfeConfigModel } from '../models/mfe-config.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  public config: MfeConfigModel;
  constructor(private http: HttpClient) {}

  public getForm(): Observable<any> {
    return this.http.get(
      `${this.config.systemParams.api['spring-api'].url}/api/entando-forms`
    );
  }
}
