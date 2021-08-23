package com.company.usermanagement.service;

import com.company.usermanagement.model.Feature;
import com.company.usermanagement.request.FeatureRequest;

public interface UserFeatureService {
    public boolean getFeatureByEmail(FeatureRequest request) throws Exception;

    public boolean updateFeature(FeatureRequest request) throws Exception;
}
