package br.edu.uniopet.locationapi.service.location;

import br.edu.uniopet.locationapi.model.account.Account;
import br.edu.uniopet.locationapi.model.location.Location;
import br.edu.uniopet.locationapi.repository.location.LocationRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

@Service
public class LocationService {

    @Resource
    private LocationRepository locationRepository;

    public Collection<Location> findAllByIdAccount(){
        Long idAccount = ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();

        return locationRepository.findAllByAccount_Id(idAccount);
    }

    public Location create(Location location){
        Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        location.setAccount(account);
        return locationRepository.save(location);
    }
}
