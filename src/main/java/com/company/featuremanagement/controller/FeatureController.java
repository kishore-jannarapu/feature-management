package com.company.featuremanagement.controller;

import com.company.featuremanagement.request.FeatureRequest;
import com.company.featuremanagement.response.FeatureResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.featuremanagement.service.UserFeatureService;

@RestController
public class FeatureController {

    @Autowired
    private UserFeatureService featureService;

    @GetMapping(value = "/feature")
    public ResponseEntity<?> getFeatureByEmail(FeatureRequest request) throws Exception {
        boolean access = featureService.getFeatureByEmailAndFeatureName(request);
        FeatureResponse response = new FeatureResponse();
        response.setCanAccess(access);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/feature")
    public ResponseEntity<?> createtFeature(@RequestBody FeatureRequest request) throws Exception {
        boolean modified =  featureService.updateFeature(request) ;
        return modified ? new ResponseEntity<Object>(HttpStatus.OK)
                : new ResponseEntity<Object>(HttpStatus.NOT_MODIFIED);
    }
}
