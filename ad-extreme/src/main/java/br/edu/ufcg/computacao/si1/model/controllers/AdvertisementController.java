package br.edu.ufcg.computacao.si1.model.controllers;

import br.edu.ufcg.computacao.si1.model.advertising.Advertisement;
import br.edu.ufcg.computacao.si1.model.factories.AdvertisementFactory;
import br.edu.ufcg.computacao.si1.model.forms.AdvertisementForm;
import br.edu.ufcg.computacao.si1.model.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by gersonsales on 16/03/17.
 */
@Controller
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    @RequestMapping(value = "/advertisement/", method = RequestMethod.GET)
    public ResponseEntity<List<Advertisement>> listAllAdvertisements() {
        List<Advertisement> advertisements = advertisementService.getAll();
        System.out.println(advertisements);
        if (advertisements.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(advertisements, HttpStatus.OK);
    }


    @RequestMapping(value = "/advertisement/", method = RequestMethod.POST)
    public ResponseEntity<Void> addNewAdvertising(@RequestBody @Valid AdvertisementForm advertisementForm, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("Creating advertisement " + advertisementForm.getTitle());

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
        }

        Advertisement advertisement = AdvertisementFactory.createNewAdvertising(advertisementForm);//TODO
        advertisementService.add(advertisement);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/advertisement/{id}").buildAndExpand(advertisement.getId()).toUri());

        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/advertisement/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Advertisement> getAdvertisement(@PathVariable("id") Long id) {
        System.out.println("Fetching advertisement with id " + id);
        Advertisement advertisement = advertisementService.getById(id);

        if (advertisement == null) {
            System.out.println("Advertisement with id " + id + " not found.");
            return new ResponseEntity<Advertisement>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Advertisement>(advertisement, HttpStatus.OK);
    }

    @RequestMapping(value = "/advertisement/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Advertisement> deleteAdvertisement(@PathVariable("id") long id) {
        System.out.println("Deleting advertisement " + id);
        advertisementService.delete(id);
        return new ResponseEntity<Advertisement>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/advertisement/", method = RequestMethod.DELETE)
    public ResponseEntity<Advertisement> deleteAllAdvertisements() {
        System.out.println("Deleting all advertisements.");
        advertisementService.deleteAll();
        return new ResponseEntity<Advertisement>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/advertisement/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Advertisement> updateAdvertisement(@RequestBody Advertisement advertisement) {
        System.out.println("Updating advertisement " + advertisement.getId());

        advertisementService.update(advertisement);
        return new ResponseEntity<Advertisement>(HttpStatus.OK);

    }

}
