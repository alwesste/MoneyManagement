import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {LoginRequest} from "./models/LoginRequest";
import {LoginResponse} from "./models/LoginResponse";

@Injectable({
  providedIn: 'root'
})

export class SubscriberDataService {

  private apiUrl = "http://localhost:8080/api/connexion";

  constructor(
    private http: HttpClient) {
  }

  login(username: string, password: string) {
    const loginRequest = new LoginRequest(username, password);
    return this.http.post<LoginResponse>(this.apiUrl, loginRequest);

  }

}
