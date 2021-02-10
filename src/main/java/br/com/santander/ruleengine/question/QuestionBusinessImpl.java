package br.com.santander.ruleengine.question;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QuestionBusinessImpl implements QuestionBusiness {

	@Autowired
	QuestionRepository questionRepository;

	@Override
	public QuestionDTO create(QuestionDTO questionRequest) {
		log.info("---create---");
		return QuestionConvert
				.createQuestionDTO(questionRepository.save(QuestionConvert.createQuestionEntity(questionRequest)));
	}

	@Override
	public QuestionDTO update(QuestionDTO questionRequest) {
		log.info("---update---");
		return QuestionConvert.createQuestionDTO(
				questionRepository.saveAndFlush(QuestionConvert.createQuestionEntity(questionRequest)));
	}

	@Override
	public Boolean existsById(Long id) {
		log.info("---existsById---");
		return questionRepository.existsById(id);
	}

	@Override
	public QuestionDTO findById(Long id) {
		log.info("---findById---");
		return QuestionConvert.createQuestionDTO(questionRepository.findById(id).get());
	}

	@Override
	public List<QuestionDTO> findByDescription(String description) {
		log.info("---findByDescription---");
		List<QuestionEntity> questionEntities = questionRepository.findByDescriptionLike("%" + description + "%");
		List<QuestionDTO> questionDTOs = new ArrayList<>();

		if (questionEntities != null && !questionEntities.isEmpty()) {
			questionEntities.forEach(question -> {
				questionDTOs.add(QuestionConvert.createQuestionDTO(question));
			});
		}
		return questionDTOs;
	}

	@Override
	public List<QuestionDTO> findAll() {
		log.info("---findAll---");
		List<QuestionEntity> questionEntities = questionRepository.findAll();
		List<QuestionDTO> questionDTOs = new ArrayList<>();

		if (questionEntities != null && !questionEntities.isEmpty()) {
			questionEntities.forEach(question -> {
				questionDTOs.add(QuestionConvert.createQuestionDTO(question));
			});
		}
		return questionDTOs;
	}

	@Override
	public void deleteById(Long id) {
		log.info("---deleteById---");
		questionRepository.deleteById(id);
	}
}