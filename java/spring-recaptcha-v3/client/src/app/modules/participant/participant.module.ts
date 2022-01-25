import { ParticipantRoutingModule } from './participant-routing.module';
import { ParticipantFormComponent } from './containers/participant-form/participant-form.component';
import { ParticipantListComponent } from './containers/participant-list/participant-list.component';
import { ParticipantContainerComponent } from './containers/participant-container/participant-container.component';
import { SharedModule } from './../../shared/shared.module';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from "@angular/common";

@NgModule({
  declarations: [
    ParticipantContainerComponent,
    ParticipantListComponent,
    ParticipantFormComponent],
  imports: [CommonModule, ParticipantRoutingModule, FormsModule, SharedModule]
})
export class ParticipantModule { }
