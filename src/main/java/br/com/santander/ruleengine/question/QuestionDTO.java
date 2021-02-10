package br.com.santander.ruleengine.question;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@JsonInclude(Include.NON_EMPTY)
public class QuestionDTO {

	private Long idQuestion;
	private Long idQuestionType;
	private String question;
	private List<ResponseQuestionDTO> responses;
}
