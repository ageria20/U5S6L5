package ageria.U5S6L5.controllers;


import ageria.U5S6L5.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travel")
public class TravelController {

    @Autowired
    TravelService travelService;
}
