package com.isadora.transfer.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@NotNull
	String accountOring;
	
	@NotNull
	String accountDestin;
	
	@NotNull
	Double velue;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	LocalDate dateScheduled;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	LocalDate dateTransfer;
	
	@NotNull
	String period;
	Double rate;

}
