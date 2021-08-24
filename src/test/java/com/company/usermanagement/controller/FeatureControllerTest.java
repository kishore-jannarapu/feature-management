package com.company.usermanagement.controller;

import com.company.usermanagement.request.FeatureRequest;
import com.company.usermanagement.service.UserFeatureService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(FeatureController.class)
public class FeatureControllerTest {

    @MockBean
    public UserFeatureService featureService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getFeatureByEmailAndFeatureTest() throws Exception {
        FeatureRequest request = new FeatureRequest();
        request.setFeatureName("feature1");
        request.setEmail("user1@email.com");

        Mockito.when(featureService.getFeatureByEmailAndFeatureName(request))
                .thenReturn(true);
        String result = mockMvc.perform(get("/feature?featureName=feature1&email=user1@email.com"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        FeatureResponse response = fromJson(result,FeatureResponse.class);
        assertEquals(true,response.isCanAccess());
    }


    @Test
    public void updateFeature() throws Exception {
        FeatureRequest request = new FeatureRequest();
        request.setFeatureName("feature1");
        request.setEmail("user1@email.com");

        Mockito.when(featureService.updateFeature(request))
                .thenReturn(true);
       mockMvc.perform(post("/feature").contentType(MediaType.APPLICATION_JSON).content(toJson(request)))
                .andExpect(status().isOk());

        Mockito.when(featureService.updateFeature(request))
                .thenReturn(false);
        mockMvc.perform(post("/feature").contentType(MediaType.APPLICATION_JSON).content(toJson(request)))
                .andExpect(status().isNotModified());
    }

    public static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(final String json, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static class FeatureResponse{
        private boolean canAccess;
        public boolean isCanAccess() {
            return canAccess;
        }
        public void setCanAccess(boolean canAccess) {
            this.canAccess = canAccess;
        }
    }
}