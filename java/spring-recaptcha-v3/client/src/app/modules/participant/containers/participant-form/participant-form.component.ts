import { ParticipantService } from './../../services/participant.service';
import { Component, OnInit} from "@angular/core";
import { Router } from '@angular/router';
import { ReCaptchaV3Service } from 'ng-recaptcha';

@Component({
  selector: 'app-participant',
  templateUrl: './participant-form.component.html',
  styleUrls: ['./participant-form.component.scss']
})
export class ParticipantFormComponent implements OnInit {

  id: number = 0;
  name: String = "";
  registrationType: String= "";
  registrationNumber: String= "";

  constructor(private service: ParticipantService, private router: Router, private recaptchaV3Service: ReCaptchaV3Service) { }

  ngOnInit() {
  }

  saveParticipant() {
    const participant = {id: this.id, name: this.name, registrationType: this.registrationType, registrationNumber: this.registrationNumber};

    this.recaptchaV3Service.execute('importantAction')
    .subscribe((token: string) => {
      this.service.saveParticipant(participant, token).subscribe(result => {
        this.router.navigateByUrl("participant/list");
      }, (error) => {
        console.error(error);
      });
    });
  }

  cancel() {
    this.router.navigateByUrl("participant/list");
  }
}
