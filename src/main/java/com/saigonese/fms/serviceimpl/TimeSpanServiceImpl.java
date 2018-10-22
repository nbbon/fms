package com.saigonese.fms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saigonese.fms.domain.Timespan;
import com.saigonese.fms.repository.TimespanRepository;
import com.saigonese.fms.service.TimespanService;

@Service
public class TimeSpanServiceImpl implements TimespanService {
	@Autowired
	private TimespanRepository tinmespanRepository;

	@Override
	public List<Timespan> findAll() {
		List<Timespan> list = new ArrayList<>();
		tinmespanRepository.findAll().forEach((Timespan t) -> list.add(t));
		return list;
	}

	@Override
	public Timespan getById(int id) {
		return tinmespanRepository.findOne(id);
	}

}
