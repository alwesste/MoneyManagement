import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-group',
  standalone: true,
  imports: [],
  templateUrl: './group.component.html',
  styleUrl: './group.component.scss'
})
export class GroupComponent {
    spendings: any[] = [];

constructor (
  private http: HttpClient
 ) {}


  onSubmit(): void {
    }
}



