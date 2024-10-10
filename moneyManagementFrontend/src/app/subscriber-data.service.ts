import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})

export class SubscriberDataService {

  private apiUrl = "http://localhost:8080/api/subscribe";

  constructor(
    private http: HttpClient) {}


  getSubscriberByUsername(username: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/${username}`);
  }
}
