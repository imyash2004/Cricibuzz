import { Component, OnInit } from '@angular/core';
import { ApiCallService } from '../services/api-call.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-table',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './table.component.html',
  styleUrl: './table.component.css',
})
export class TableComponent implements OnInit {
  pointTable: any;
  tableHead: any;
  constructor(private _api: ApiCallService) {}

  ngOnInit(): void {
    this._api.getPointTable().subscribe({
      next: (data) => {
        this.pointTable = data;
        this.tableHead = [...this.pointTable[0]];
      },
      error: (error) => {
        console.log(error);
      },
    });
  }
}
