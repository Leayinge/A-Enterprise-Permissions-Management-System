package com.leayinge.service.Impl;

import com.leayinge.dao.TravellerDao;
import com.leayinge.domain.Traveller;
import com.leayinge.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TravellerServiceImpl implements TravellerService {

    @Autowired
    TravellerDao travellerDao;

    @Override
    public List<Traveller> findAll() throws Exception {
        return travellerDao.findAll();
    }

    @Override
    public Traveller findById(Integer travellerId) throws Exception {
        return travellerDao.findById(travellerId);
    }
}
