package com.saigonese.fms.serviceimpl;

import com.saigonese.fms.domain.Airport;
import com.saigonese.fms.repository.AirportRepository;
import com.saigonese.fms.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {
    @Autowired
    AirportRepository airportRepository;


    @Override
    public List<Airport> findAll() {
        return (List<Airport>) airportRepository.findAll();
    }

    @Override
    public Airport save(Airport airplane) {
        return airportRepository.save(airplane);
    }

    @Override
    public Airport findOne(Long id) {
        return airportRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        airportRepository.delete(id);
    }
}
