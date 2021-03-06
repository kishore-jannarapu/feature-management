package com.company.featuremanagement.repository;

import java.util.Optional;

import com.company.featuremanagement.model.UserFeature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFeatureRepository extends CrudRepository<UserFeature, Long> {

	@Query("select uf from UserFeature uf inner join User u  on uf.userId = u.userId inner join Feature f on uf.featureId = f.featureId where u.email = :email and f.featureName = :featureName")
	public Optional<UserFeature> findFeatureByEmailAndFeatureName(String email, String featureName);
	
}
