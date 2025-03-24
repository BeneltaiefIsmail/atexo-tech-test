import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ConfigurationRule} from '../model/configuration';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConfigurationRuleServiceService {

  private apiUrl = 'http://localhost:8080/api/v1/configuration-rules';

  constructor(private http: HttpClient) { }

  saveConfigurationRule(configurationRule: ConfigurationRule): Observable<any> {
    return this.http.post<any>(this.apiUrl, configurationRule);
  }
}
