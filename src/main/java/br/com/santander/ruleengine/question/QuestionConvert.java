package br.com.santander.ruleengine.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QuestionConvert {

	/**
	 * Convert QuestionDTO para QuestionEntity
	 * 
	 * @param questionRequest
	 * @return
	 */
	public static QuestionEntity createQuestionEntity(final QuestionDTO questionRequest) {

		List<ResponseEntity> responseEntities = new ArrayList<ResponseEntity>();

		questionRequest.getResponses().forEach(response -> {
			responseEntities.add(ResponseEntity //
					.builder() //
					.id(response.getIdResponse()) //
					.description(response.getDescription()) //
					.userCreation("x000000")
					.dateCreation(LocalDateTime.now())
					.build());
		});

		return QuestionEntity //
				.builder() //
				.id(questionRequest.getIdQuestion()) //
				.questionTypeEntity( //
						QuestionTypeEntity //
								.builder() //
								.id(questionRequest.getIdQuestionType()) //
								.build()) //
				.description(questionRequest.getQuestion()) //
				// TODO : Recuperar usuario
				.userCreation("x000000")
				.dateCreation(LocalDateTime.now())
				.responseEntities((responseEntities.isEmpty()) ? null : responseEntities).build();
	}

	/**
	 * Converte QuestionEntity para QuestionDTO
	 * 
	 * @param questionEntity
	 * @return
	 */
	public static QuestionDTO createQuestionDTO(final QuestionEntity questionEntity) {

		List<ResponseQuestionDTO> responsesDTO = new ArrayList<ResponseQuestionDTO>();

		questionEntity.getResponseEntities().forEach(response -> {
			responsesDTO.add(ResponseQuestionDTO //
					.builder() //
					.idResponse(response.getId()) //
					.description(response.getDescription()) //
					.build());
		});

		return QuestionDTO //
				.builder() //
				.idQuestion(questionEntity.getId()) //
				.idQuestionType(questionEntity.getQuestionTypeEntity().getId()) //
				.question(questionEntity.getDescription()) //
				.responses((responsesDTO.isEmpty()) ? null : responsesDTO) //
				.build();
	}
}