package ageria.U5S6L5.services;


import ageria.U5S6L5.repositories.TraveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelService {

    @Autowired
    TraveRepository traveRepository;
}
