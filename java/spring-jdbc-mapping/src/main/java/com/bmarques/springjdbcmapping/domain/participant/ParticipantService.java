package com.bmarques.springjdbcmapping.domain.participant;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ParticipantService {

  private final ParticipantRepository repository;

  public ParticipantService(ParticipantRepository repository) {
    this.repository = repository;
  }

  public List<Participant> getAllParticipants() {
    return repository.findAll();
  }

  public Optional<Participant> getParticipantById(UUID id) {
    return repository.findById(id);
  }

  public Participant create(Participant participant) {

    final UUID contactId = UUID.fromString("438c1a7b-10d4-45e6-a7a6-007e90676a03");
    final LocalDateTime currentDateTime = LocalDateTime.now();

    if (participant.isNew()) {
      final UUID participantId = UUID.randomUUID();

      participant.setId(participantId);
      participant.setCreateDate(currentDateTime);
      participant.setCreatedByContactId(contactId);

      participant.getParticipantPeriodEffect()
          .forEach(periodEffect -> {
            periodEffect.setId(UUID.randomUUID());
            periodEffect.setParticipantId(participantId);
            periodEffect.setCreateDate(currentDateTime);
            periodEffect.setCreatedByContactId(contactId);
          });
    }

    participant.setChanged(currentDateTime);
    participant.setChangedByContactId(contactId);

    participant.getParticipantPeriodEffect()
        .forEach(periodEffect -> {
          periodEffect.setChanged(currentDateTime);
          periodEffect.setChangedByContactId(contactId);
        });

    return repository.save(participant);
  }
}
