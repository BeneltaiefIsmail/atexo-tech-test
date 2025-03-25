import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Registration} from '../model/registration';
import {RegistrationDtoResponse} from '../model/RegistrationDtoResponse';


@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  private apiUrl = 'http://localhost:8080/api/v1/registrations';
  constructor(private http: HttpClient) {}

  saveRegistration (registration: Registration ) :Observable<RegistrationDtoResponse>{
    return this.http.post<Registration>('http://localhost:8080/api/v1/registrations', registration)
  }

}
