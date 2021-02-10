package br.com.santander.ruleengine.question;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.ruleengine.dto.Response;

@CrossOrigin
@RestController
@RequestMapping(value = "/question")
public class QuestionController {

	@Autowired
	private QuestionBusiness questionBusiness;

	/**
	 * Cria sem id Question. Atualiza com id Question.
	 * 
	 * @param id
	 * @param questionRequest
	 * @return
	 */
	@PutMapping("/create-update")
	public ResponseEntity<Response<?>> updateOrderCriptoStatus(
			@RequestBody(required = true) QuestionDTO questionRequest) {
		QuestionDTO questionDTO = null;
		
		if (questionRequest.getIdQuestion() == null) {
			questionDTO = questionBusiness.create(questionRequest);
		} else {

			if (!questionBusiness.existsById(questionRequest.getIdQuestion())) {
				throw new ResourceNotFoundException();
			}
			questionDTO = questionBusiness.update(questionRequest);
		}
		return ResponseEntity.ok(Response.builder().data(questionDTO).build());
	}

	/**
	 * Busca todas questoes ou busca questoes por Id ou Description
	 * 
	 * @param id
	 * @param description
	 * @return
	 */
	@GetMapping("/find")
	public ResponseEntity<Response<?>> findByDescription(@RequestParam(required = false) Long id,
			@RequestParam(required = false) String description) {

		List<QuestionDTO> questionDTOs = null;
		
		if (id != null) {
			questionDTOs = new ArrayList<>();
			QuestionDTO QuestionDTO = questionBusiness.findById(id);

			if (QuestionDTO == null) {
				throw new ResourceNotFoundException();
			}
			questionDTOs.add(QuestionDTO);
		} else if (description != null) {
			questionDTOs = questionBusiness.findByDescription(description);

			if (questionDTOs == null) {
				throw new ResourceNotFoundException();
			}
		} else {
			questionDTOs = questionBusiness.findAll();
		}
		
		return ResponseEntity.ok(Response.builder().data(questionDTOs).build());
	}

	/**
	 * Deleta questao por ID
	 * 
	 * @param id
	 */
	@DeleteMapping("/delete")
	public void remove(@RequestParam Long id) {
		if (!questionBusiness.existsById(id)) {
			throw new ResourceNotFoundException();
		}
		questionBusiness.deleteById(id);
	}
}
