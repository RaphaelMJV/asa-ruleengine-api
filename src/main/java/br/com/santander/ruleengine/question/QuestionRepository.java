package br.com.santander.ruleengine.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository
		extends JpaRepository<QuestionEntity, Long>, JpaSpecificationExecutor<QuestionEntity> {

	List<QuestionEntity> findByDescriptionLike(String description);
}
