import { Component, OnInit } from '@angular/core';
import { ApiCallService } from '../services/api-call.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent implements OnInit {
  odiRank: any;
  rankhead: any;
  constructor(private _api: ApiCallService) {}
  ngOnInit(): void {
    this._api.getOdiRanking().subscribe({
      next: (data) => {
        this.odiRank = data;
        this.rankhead = [...this.odiRank[0]];
        console.log(data);
      },
      error: (error) => {
        console.log(error);
      },
    });
  }
}
