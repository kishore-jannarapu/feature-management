package com.company.usermanagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "feature")
public class Feature {

    @Id
    @Column(name = "feature_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long featureId;

    @Column(name = "feature_name")
    @NotBlank(message = "FeatureName is mandatory")
    private String featureName;

    @Column(name = "feature_description")
    @NotBlank(message = "FeatureName is mandatory")
    private String featureDescription;

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }


    public String getFeatureDescription() {
        return featureDescription;
    }

    public void setFeatureDescription(String featureDescription) {
        this.featureDescription = featureDescription;
    }
}
