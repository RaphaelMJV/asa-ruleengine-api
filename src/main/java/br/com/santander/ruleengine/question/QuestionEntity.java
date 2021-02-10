package br.com.santander.ruleengine.question;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "QUESTION")
@Table(name = "QUESTION")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class QuestionEntity implements Serializable {

	private static final long serialVersionUID = 8874310595181342699L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_QUESTION")
	private Long id;

	@Column
	private String description;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_QUESTION_TYPE")
	private QuestionTypeEntity questionTypeEntity;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "ID_QUESTION")
	private List<ResponseEntity> responseEntities;

	@Column(name = "USER_CREATION")
	private String userCreation;
	
	@Column(name = "DATE_CREATION")
	private LocalDateTime dateCreation;
}