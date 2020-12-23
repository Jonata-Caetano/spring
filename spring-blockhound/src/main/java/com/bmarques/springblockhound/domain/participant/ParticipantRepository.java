package com.bmarques.springblockhound.domain.participant;

import java.util.List;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, UUID> {

  List<Participant> findAll();
}
