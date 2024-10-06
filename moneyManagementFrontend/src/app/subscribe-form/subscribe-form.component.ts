import {Component} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-subscribe-form',
  standalone: true,
  imports: [
    ReactiveFormsModule,

  ],
  templateUrl: './subscribe-form.component.html',
  styleUrl: './subscribe-form.component.scss'
})

/**
 * recupere les donnees du formulaire
 */
export class SubscribeFormComponent {

  form: FormGroup = new FormGroup({
    username: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    passwordConfirm: new FormControl('')

  });

  constructor(
    private http: HttpClient,
    private router: Router,
  ) {}

  onSubmit(): void {
    if (this.form.valid) {
      console.log(this.form.value);
      this.http.post('http://localhost:8080/api/subscribe/form', this.form.value).subscribe({
        next: response => {
          console.log('Réponse du serveur:', response);
          // Vous pourriez envisager de réinitialiser le formulaire ici
        },
        error: error => {
          console.error('Erreur lors de l\'envoi des données:', error);
          // Ici, vous pourriez afficher un message d'erreur à l'utilisateur
        },
        complete: () => {
          console.log('Requête terminée');
          this.router.navigate(['account']); // Redirige vers la page de succès

          // Si vous avez besoin de faire quelque chose une fois que l'observable est complet
        }
      });
    } else {
      console.log('Formulaire invalide');
      // Vous pourriez aussi afficher un message d'erreur pour l'utilisateur ici
    }
  }
}
