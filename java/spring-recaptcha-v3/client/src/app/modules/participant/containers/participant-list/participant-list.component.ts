import { IParticipant } from './../../models/participant.interface';
import { ParticipantService } from './../../services/participant.service';
import { Component, OnInit} from "@angular/core";

@Component({
  selector: 'app-participant-list',
  templateUrl: './participant-list.component.html',
  styleUrls: ['./participant-list.component.scss']
})
export class ParticipantListComponent implements OnInit {

  participantList: IParticipant[] = [ {id: 1, name: '', registrationNumber: '', registrationType: ''}];

  constructor(private service: ParticipantService) { }

  ngOnInit() {
    this.service.getParticipantList().subscribe((rows: IParticipant[]) => {
      this.participantList = rows;
    });
  }
}
