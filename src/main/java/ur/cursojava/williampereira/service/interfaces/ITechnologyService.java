package ur.cursojava.williampereira.service.interfaces;

import ur.cursojava.williampereira.domain.Technology;

import java.util.List;

public interface ITechnologyService {

    List<Technology> GetAll();

    Technology GetById(long id);
}