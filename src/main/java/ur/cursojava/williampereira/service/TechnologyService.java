package ur.cursojava.williampereira.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ur.cursojava.williampereira.domain.Technology;
import ur.cursojava.williampereira.exception.BadRequestException;
import ur.cursojava.williampereira.repository.interfaces.ITechnologyRepository;
import ur.cursojava.williampereira.service.interfaces.ITechnologyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologyService implements ITechnologyService {

    private final ITechnologyRepository _repTechnology;

    public List<Technology> GetAll() {
        return _repTechnology.findAll();
    }

    public Technology GetById(long id) {
        return _repTechnology.findById(id)
                .orElseThrow(() -> new BadRequestException("Technology ID not found"));
    }
}