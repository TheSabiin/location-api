package br.edu.uniopet.locationapi.repository.location;

import br.edu.uniopet.locationapi.model.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    Collection<Location> findAllByAccount_Id(Long id);
}
