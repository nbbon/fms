package com.saigonese.fms.service;

import java.util.List;

import com.saigonese.fms.domain.Timespan;

public interface TimespanService {
	List<Timespan> findAll();

	Timespan getById(int id);
}
