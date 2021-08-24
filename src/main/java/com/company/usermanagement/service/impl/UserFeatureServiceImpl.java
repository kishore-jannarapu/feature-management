package com.company.usermanagement.service.impl;

import java.util.Optional;

import com.company.usermanagement.exception.ResourceNotFoundException;
import com.company.usermanagement.model.UserFeature;
import com.company.usermanagement.request.FeatureRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.usermanagement.repository.UserFeatureRepository;
import com.company.usermanagement.service.UserFeatureService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserFeatureServiceImpl implements UserFeatureService {

    @Autowired
    private UserFeatureRepository featureRepository;

    @Transactional
    public boolean getFeatureByEmailAndFeatureName(FeatureRequest req) throws Exception {
        Optional<UserFeature> feature = featureRepository.findFeatureByEmailAndFeatureName(req.getEmail(), req.getFeatureName());
        if (feature.isPresent())
            return feature.get().getEnable();
        else
            throw new ResourceNotFoundException("Feature does not exist.");
    }

    @Transactional
    public boolean updateFeature(FeatureRequest req) throws Exception {
        Optional<UserFeature> feature = featureRepository.findFeatureByEmailAndFeatureName(req.getEmail(), req.getFeatureName());
        if (feature.isPresent()) {
            UserFeature userFeature = feature.get();
            if (userFeature.getEnable() == req.isEnable()) {
                return false;
            } else {
                userFeature.setEnable(req.isEnable());
                featureRepository.save(userFeature);
                return true;
            }
        } else
            throw new ResourceNotFoundException("Feature does not exist.");
    }
}
