package com.trabalho.crud.core.dto;

import lombok.Data;

@Data
public class BookingDto {
  
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
