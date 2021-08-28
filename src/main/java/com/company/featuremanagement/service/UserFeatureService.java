package com.company.featuremanagement.service;

import com.company.featuremanagement.request.FeatureRequest;

public interface UserFeatureService {
    public boolean getFeatureByEmailAndFeatureName(FeatureRequest request) throws Exception;

    public boolean updateFeature(FeatureRequest request) throws Exception;
}
