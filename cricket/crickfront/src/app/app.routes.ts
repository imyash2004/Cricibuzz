import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { HistoryComponent } from './history/history.component';
import { LiveComponent } from './live/live.component';
import { TableComponent } from './table/table.component';

export const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
    title: 'home',
  },
  {
    path: 'history',
    component: HistoryComponent,
    title: 'history',
  },
  {
    path: 'live',
    component: LiveComponent,
    title: 'live',
  },
  {
    path: 'table',
    component: TableComponent,
    title: 'table',
  },
];
