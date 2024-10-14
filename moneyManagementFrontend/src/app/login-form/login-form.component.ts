import {Component} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Router} from "@angular/router";
import {LoginResponse} from "../models/LoginResponse";

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    HttpClientModule
  ],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.scss'
})
export class LoginFormComponent {
  form: FormGroup = new FormGroup({
    username: new FormControl(""),
    password: new FormControl("")
  })

  constructor(
    private http: HttpClient,
    private router: Router,
  ) {
  }

  onSubmit(): void {
    if (this.form.valid) {
      console.log("form value ", this.form.value);
      this.http.post<LoginResponse>('http://localhost:8080/api/connexion', this.form.value)
        .subscribe({
          next: response => {
            console.log('Réponse du serveur:', response);
            const username: string = this.form.get('username')?.value;
            const userId = response.userId;

            sessionStorage.setItem("username", username);
            sessionStorage.setItem("userId", userId.toString());

            this.router.navigate([`/account/${username}`]);
          },
          error: error => {
            console.error('Erreur lors de l\'envoi des données:', error);
          },
          complete: () => {
            console.log('Requête terminée');
          }
        });
    } else {
      console.log('Formulaire invalide');
    }
  }
}
