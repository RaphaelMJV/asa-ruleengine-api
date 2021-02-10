package br.com.santander.ruleengine.question;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "RESPONSE")
@Table(name = "RESPONSE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseEntity implements Serializable{

	private static final long serialVersionUID = 8874310595181342699L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RESPONSE")
	private Integer id;
	
	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "USER_CREATION")
	private String userCreation;
	
	@Column(name = "DATE_CREATION")
	private LocalDateTime dateCreation;
}