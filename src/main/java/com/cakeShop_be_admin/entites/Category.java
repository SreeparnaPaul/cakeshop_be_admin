package com.cakeShop_be_admin.entites;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String categoryName;
	private String categoryDescription;
	private Integer status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
