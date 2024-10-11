import {Component, OnInit} from '@angular/core';
import {SubscriberDataService} from "../subscriber-data.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-account',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  templateUrl: './account.component.html',
  styleUrl: './account.component.scss'
})
export class AccountComponent implements OnInit {
  //private subscriberIds: number[] = []; // Déclarez un tableau pour stocker les IDs des abonnés
  username: string | null = null;
  userId: string | null = null;

  form: FormGroup = new FormGroup({
    spendingType: new FormControl(''),
    amount: new FormControl(''),
    comment: new FormControl(''),
    date: new FormControl(new Date())
  })

  constructor(
    private http: HttpClient,
    private subscriberDataService: SubscriberDataService) {
  }

  ngOnInit(): void {
    this.username = sessionStorage.getItem('username');
    this.userId = sessionStorage.getItem('userId')
     //this.getSubscriberById
  };

  onSubmit(): void {
  const accountData = this.form.value;

    if(this.form.valid) {
      this.http.post("http://localhost:8080/api/accountSend",accountData).subscribe({
        next: response => {
          console.log("reponse de la requete a accountSend", response)
          console.log("success !", this.form.value)
        },
        error: error => {
          console.log("une erreur est survenu", error)
        },
        complete: () => console.log("Requete termine")
        }
      )
    }
  }

  // getSubscriberById(id: number): void {
  //   this.subscriberDataService.getSubscriberById(id).subscribe({
  //     next: subscriber => {
  //       console.log("Subscriber data:", subscriber);
  //       // Handle the received subscriber data as needed
  //     },
  //     error: err => {
  //       console.error("Error fetching subscriber:", err);
  //     }
  //   });
  // }
}
