import {Component} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Router} from "@angular/router";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-subscribe-form',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    HttpClientModule,
    NgIf
  ],
  templateUrl: './subscribe-form.component.html',
  styleUrl: './subscribe-form.component.scss'
})


export class SubscribeFormComponent {

  errorMessage: string | null = null;

  form: FormGroup = new FormGroup({
    username: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    passwordConfirm: new FormControl('')

  });

  constructor(
    private http: HttpClient,
    private router: Router,
  ) {
  }

  onSubmit(): void {
    if (this.form.valid) {
      this.http.post('http://localhost:8080/api/subscribe/form', this.form.value)
        .subscribe({
          next: response => {
            console.log('Réponse du serveur:', response);
            const username = this.form.get('username')?.value;
            console.log(username);
            this.router.navigate([`/account/${username}`]);
          },
          error: error => {
            console.error('Erreur lors de l\'envoi des données:', error);
            if (error.status === 409 && error.error === 'Subscriber already exists') {
              this.errorMessage = 'Le nom d\'utilisateur est déjà pris, veuillez en choisir un autre.';
            } else {
              this.errorMessage = 'Une erreur est survenue lors de l\'inscription. Veuillez réessayer.';
            }
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
