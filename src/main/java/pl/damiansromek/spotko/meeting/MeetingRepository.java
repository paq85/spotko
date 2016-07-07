package pl.damiansromek.spotko.meeting;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRepository extends CrudRepository<Meeting, UUID> {
	Page<Meeting> findAll(Pageable pageable);
}
