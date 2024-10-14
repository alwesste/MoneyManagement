import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {DatePipe, NgForOf, NgIf} from "@angular/common";
import {Router} from "@angular/router";

@Component({
  selector: 'app-account',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgForOf,
    DatePipe,
    NgIf,
  ],
  templateUrl: './account.component.html',
  styleUrl: './account.component.scss'
})
export class AccountComponent implements OnInit {
  username: string | null = null;
  userId: string | null = null;
  spendings: any[] = [];
  showSpending: boolean = true;
  totalBalance: number = 0;

  form: FormGroup = new FormGroup({
    spendingType: new FormControl(''),
    amount: new FormControl(''),
    comment: new FormControl(''),
    date: new FormControl(new Date()),
  })

  constructor(
    private http: HttpClient,
    private router: Router,
  ) {
  }

  ngOnInit(): void {
    this.username = sessionStorage.getItem('username');
    this.userId = sessionStorage.getItem('userId')
    if (this.userId) {
      this.form.patchValue({
        subscriber: Number(this.userId)  // Make sure to convert userId to a number
      });
      this.getSpending()
      this.getSpendingTotalBalance(Number(this.userId))
    } else {
      console.error("UserId is missing in session storage!");
    }
  };

  getSpending() {
    this.http.get(`http://localhost:8080/api/spending/${this.userId}`).subscribe({
      next: (response: any) => {
        this.spendings = response.reverse()
        console.log("Requête envoye qvec succes", this.spendings)
      },
      error: error => {
        console.log(error);
      },
      complete:() => console.log("Requête terminer")
    })
  }

  deleteSpending(spendingId: number) {
    this.http.delete(`http://localhost:8080/api/spending/${spendingId}`)
      .subscribe({
      next: () => {
        // Retirer la dépense du tableau local
        this.spendings = this.spendings.filter(spending => spending.id !== spendingId);
        this.getSpendingTotalBalance(Number(this.userId))
        console.log("Dépense supprimée avec succès");
      },
      error: error => {
        console.error("Erreur lors de la suppression de la dépense", error);
      }
    });
  }

  getSpendingTotalBalance(subscriberId: number) {
    this.http.get<number>(`http://localhost:8080/api/spending/totalBalance/${subscriberId}`)
      .subscribe({
        next: (response: number) => {
          this.totalBalance = response;
        },
        error: error => {
          console.log("erreur lors de la recuperation du solde", error);
        }
      })
  }

  getRemove() {
    this.showSpending = !this.showSpending;
  }

  onSubmit(): void {
    const accountData = this.form.value;

    if (this.form.valid) {
      console.log("Account Data being sent:", accountData); // Add this log to check data before sending

      this.http.post("http://localhost:8080/api/accountSend", {
        ...accountData,
        subscriber: {
          id: this.userId // assuming this.userId is the ID of the subscriber
        }
      }).subscribe({
          next: response => {
            console.log("success !", accountData)
            this.getSpending()
            this.getSpendingTotalBalance(Number(this.userId))
          },
          error: error => {
            console.log("une erreur est survenu", error)
          },
          complete: () => console.log("Requete termine")
        }
      )
    }
  }

  newGroup() {
    this.router.navigate(["/group"]);
  }
}
