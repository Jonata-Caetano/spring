import { ParticipantContainerComponent } from './containers/participant-container/participant-container.component';
import { ParticipantListComponent } from './containers/participant-list/participant-list.component';
import { ParticipantFormComponent } from './containers/participant-form/participant-form.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: ParticipantContainerComponent,
    children: [
      {
        path: 'list',
        component: ParticipantListComponent,
      },
      {
        path: 'form',
        children: [
          {
            path: '',
            component: ParticipantFormComponent,
            data: { disableClientSelect: true },
          },
          {
            path: ':id/edit',
            component: ParticipantFormComponent,
            data: { disableClientSelect: true },
          },
        ],
      }
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ParticipantRoutingModule { }
