package br.com.santander.ruleengine.question;

import java.util.List;

public interface QuestionBusiness {

	/**
	 * Cria Questão
	 * 
	 * @param questionRequest
	 * @return QuestionDTO
	 */
	QuestionDTO create(QuestionDTO questionRequest);

	/**
	 * Atualiza questão
	 * 
	 * @param questionRequest
	 * @return QuestionDTO
	 */
	QuestionDTO update(QuestionDTO questionRequest);

	/**
	 * Verifica se id da questão existe
	 * 
	 * @param id
	 * @return Boolean
	 */
	Boolean existsById(Long id);

	/**
	 * Busca questão por ID
	 * 
	 * @param id
	 * @return QuestionDTO
	 */
	QuestionDTO findById(Long id);

	/**
	 * Busca questão por Description
	 * 
	 * @param description
	 * @return List
	 */
	List<QuestionDTO> findByDescription(String description);

	/**
	 * Busca todas questões
	 * 
	 * @return List
	 */
	List<QuestionDTO> findAll();

	void deleteById(Long id);
}
