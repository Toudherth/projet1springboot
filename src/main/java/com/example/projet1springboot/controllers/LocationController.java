package com.example.projet1springboot.controllers;

import com.example.projet1springboot.models.Location;
import com.example.projet1springboot.repositories.LocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    @RequestMapping("/locations")
    public List<Location> list(){
        return locationRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/location/{id}")
    public  Location getLocation(@PathVariable Long id){
        if(locationRepository.findById(id).isEmpty()){
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Location with ID "+id+" not found");
        }
        return locationRepository.getById(id);
    }

    @PostMapping
    @RequestMapping("/location")
    @ResponseStatus(HttpStatus.CREATED)
    public Location AddLocation(@RequestBody final Location location){
        return locationRepository.saveAndFlush(location);
    }

    @RequestMapping(value = "/location/{id}", method=RequestMethod.DELETE)
    public void deleteLocation(@PathVariable Long id){
        locationRepository.deleteById(id);
    }
    @RequestMapping(value = "/location/{id}", method = RequestMethod.PUT)
    public Location updateLocation(@PathVariable  Long id, @RequestBody Location location){
        Location existingLocation = locationRepository.getReferenceById(id);
        BeanUtils.copyProperties(location, existingLocation, "location_id");
        return locationRepository.saveAndFlush(existingLocation);
    }



    /// page  22 

}
