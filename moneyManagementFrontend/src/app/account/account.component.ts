import {Component, OnInit} from '@angular/core';
import {SubscriberDataService} from "../subscriber-data.service";

@Component({
  selector: 'app-account',
  standalone: true,
  imports: [

  ],
  templateUrl: './account.component.html',
  styleUrl: './account.component.scss'
})
export class AccountComponent implements OnInit {

  username: string | null = null;

  constructor() {}

  ngOnInit(): void {
    this.username = sessionStorage.getItem('username');
  }
}
