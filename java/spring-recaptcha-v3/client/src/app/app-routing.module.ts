import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'participant',
        loadChildren: () =>
          import('./modules/participant/participant.module').then(m => m.ParticipantModule),
      },
      {
        path: '**',
        redirectTo: '/participant/form',
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
