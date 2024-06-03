package com.infy.dto;

import java.time.LocalDate;

public class CardDTO {
	
	private Integer cardId;
	private String cardNumber;
	private LocalDate expiryDate;
	
	public CardDTO() {
		
	}
	
	public CardDTO(Integer cardId, String cardNumber,LocalDate expiryDate) {
		this.cardId=cardId;
		this.cardNumber=cardNumber;
		this.expiryDate=expiryDate;
	}
	
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "CardDTO [cardId=" + cardId + ", cardNumber=" + cardNumber + ", expiryDate=" + expiryDate + "]";
	}
	
}
