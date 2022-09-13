package com.leayinge.service;

import com.leayinge.domain.Traveller;

import java.util.List;

public interface TravellerService {

    List<Traveller> findAll() throws Exception;

    Traveller findById(Integer travellerId) throws Exception;
}
