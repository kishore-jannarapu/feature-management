package com.company.usermanagement.request;

import java.util.Objects;

public class FeatureRequest {
    private String featureName;
    private String email;
    private boolean enable;

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeatureRequest that = (FeatureRequest) o;
        return enable == that.enable && Objects.equals(featureName, that.featureName) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(featureName, email, enable);
    }
}
