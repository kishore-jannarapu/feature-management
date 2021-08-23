package com.company.usermanagement.service;

import com.company.usermanagement.model.UserFeature;
import com.company.usermanagement.repository.UserFeatureRepository;
import com.company.usermanagement.request.FeatureRequest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FeatureServiceTest {

    @Autowired
    public UserFeatureService featureService;

    @MockBean
    UserFeatureRepository featureRepository;

    FeatureRequest request = null;
    UserFeature response = null;

//    @Before
//    public void setup() {
//        request = new FeatureRequest();
//        request.setFeatureName("feature123");
//        request.setEmail("email1@email.com");
//        request.setEnable(true);
//
//        response = new UserFeature();
//        response.setFeatureName("feature123");
//        response.setEmail("email1@email.com");
//        response.setEnable(true);
//    }

    @Test
    public void getFeatureByEmailTest() throws Exception {
        Mockito.when(featureRepository.findFeatureByEmailAndFeatureName(request.getEmail(),
                request.getFeatureName())).thenReturn(Optional.of(response));
        boolean flag = featureService.getFeatureByEmail(request);

        assertEquals(true, flag);
    }


    @Test
    public void updateFeature() throws Exception {
//        Mockito.when(featureRepository.findById(request.getFeatureId())).thenReturn(Optional.of(response));
//        //Mockito.when(featureRepository.save(request)).thenReturn(response);
//        boolean flag = featureService.updateFeature(request);
//        assertEquals(true, flag);
    }
}