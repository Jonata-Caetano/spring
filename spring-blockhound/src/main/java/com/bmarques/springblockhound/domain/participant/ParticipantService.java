package com.bmarques.springblockhound.domain.participant;

import static com.bmarques.springblockhound.domain.QueueProperties.CLIENT_QUEUE_RK;
import static com.bmarques.springblockhound.domain.QueueProperties.RABBITMQ_EXCHANGE;

import com.bmarques.springblockhound.domain.utils.BasePublisher;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.OutboundMessageResult;

@Service
public class ParticipantService {

  private final ParticipantRepository repository;
  private final BasePublisher publisher;

  public ParticipantService(ParticipantRepository repository, BasePublisher publisher) {
    this.repository = repository;
    this.publisher = publisher;
  }

  public List<Participant> getAllParticipants() {
    return repository.findAll();
  }

  public Optional<Participant> getClientById(final UUID id) {
    return repository.findById(id);
  }

  public Mono<Participant> saveClient(final Participant participant) {
    return saveClientInDataBase(participant)
        .then(publishMessage(participant))
        .thenReturn(participant);
  }

  private Mono<OutboundMessageResult> publishMessage(Participant participant) {
    return publisher
        .sendMessageToPublisher(participant, RABBITMQ_EXCHANGE, CLIENT_QUEUE_RK)
        .single();
  }

  private Mono<Participant> saveClientInDataBase(final Participant participant) {
    return Mono.fromCallable(() -> {
      try {
        return repository.save(participant);
      } catch (DbActionExecutionException e) {
        if (e.getCause() instanceof DuplicateKeyException) {
          throw new RuntimeException(
              String.format("Code %s is already in use.", participant.getCode()));
        }
        throw new RuntimeException("Failed to save new client", e);
      }
    });
  }
}
