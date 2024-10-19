package com.trabalho.crud.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"BOOKING\"")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	// Info Reserva  
	  private Long id;
	  private String checkOut;
	  private String checkIn;
	  private String paymentMethod;

	// inserção das informações do cliente
	  private String clientName;
	
	  private String clientEmail;
	
	  // inserção das informações do quarto
	  private String bedroomNumber;
	
	  private String bedroomType;
	
	  // inserção das informações do funcionário
	  private String employeeName;
	
	  private String employeePosition;

}
