import { IParticipant } from './../models/participant.interface';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ParticipantService {

  private participantList: any[];
  private url = 'http://localhost:8080/v1/participant';

  constructor(private httpClient: HttpClient) {
    this.participantList = [];
  }

  getParticipantList(): Observable<IParticipant[]>{
    return this.httpClient.get<IParticipant[]>(this.url);
  }

  saveParticipant(participant: IParticipant, token: string): Observable<IParticipant> {
    return this.httpClient.post<IParticipant>(this.url, participant, {
      headers: {'g-recaptcha-response':token}
    });
  }
}
