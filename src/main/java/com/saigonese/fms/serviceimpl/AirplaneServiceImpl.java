package com.saigonese.fms.serviceimpl;

import com.saigonese.fms.domain.Airplane;
import com.saigonese.fms.repository.AirplaneRepository;
import com.saigonese.fms.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AirplaneServiceImpl implements AirplaneService {
    @Autowired
    AirplaneRepository airplaneRepository;


    @Override
    public List<Airplane> findAll() {
        return (List<Airplane>) airplaneRepository.findAll();
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Airplane findOne(Long id) {
        return airplaneRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        airplaneRepository.delete(id);
    }

	@Override
	public Long saveAirplane(Airplane airplane) {
		Airplane savedAirplane = airplaneRepository.save(airplane);
		return savedAirplane.getId();
	}
}
