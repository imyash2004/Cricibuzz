import { Component, OnInit } from '@angular/core';
import { ApiCallService } from '../services/api-call.service';
import { CommonModule } from '@angular/common';
import { MatchCardComponent } from '../components/match-card/match-card.component';

@Component({
  selector: 'app-live',
  standalone: true,
  templateUrl: './live.component.html',
  styleUrl: './live.component.css',
  imports: [CommonModule, MatchCardComponent],
})
export class LiveComponent implements OnInit {
  liveMatches: any;
  constructor(private _api: ApiCallService) {}
  ngOnInit(): void {
    this.LiveMatches();
  }

  private LiveMatches() {
    this._api.getAllMatches().subscribe({
      next: (data) => {
        console.log(data);
        this.liveMatches = data;
      },
      error: (error) => {
        console.log(error);
      },
    });
  }
}
