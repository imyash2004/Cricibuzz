import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class ApiCallService {
  constructor(private _httpClient: HttpClient) {}
  getAllMatches(): Observable<any> {
    return this._httpClient.get(`${environment.apiUrl}/match`);
  }
  getLiveMatches(): Observable<any> {
    return this._httpClient.get(`${environment.apiUrl}/match/live`);
  }
  getPointTable(): Observable<any> {
    return this._httpClient.get(`${environment.apiUrl}/match/point-table`);
  }
  getOdiRanking(): Observable<any> {
    return this._httpClient.get(`${environment.apiUrl}/match/odi`);
  }
}
