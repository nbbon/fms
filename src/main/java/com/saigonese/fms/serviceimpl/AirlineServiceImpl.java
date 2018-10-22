package com.saigonese.fms.serviceimpl;

import com.saigonese.fms.domain.Airline;
import com.saigonese.fms.repository.AirlineRepository;
import com.saigonese.fms.service.AirlineService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    @Override

    public List<Airline> findAll() {
        return (List<Airline>) airlineRepository.findAll();
    }

    @Override
    public Airline save(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public Airline findOne(Long id) {
        return airlineRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        airlineRepository.delete(id);
    }

}
