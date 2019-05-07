package br.edu.uniopet.locationapi.controller.location;

import br.edu.uniopet.locationapi.model.location.Location;
import br.edu.uniopet.locationapi.service.location.LocationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    @Resource
    private LocationService locationService;

    @GetMapping("/list")
    public Collection<Location> findAllByIdAccount(){
        return locationService.findAllByIdAccount();
    }

    @PostMapping("/create")
    public Location create(@RequestBody Location location){
        return locationService.create(location);
    }
}
