package com.tenpo.spicardo.entity;

import jakarta.persistence.*;

@Entity
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double num1;
    private double num2;
    private double result;

    public Calculation() {}

    public Calculation(double num1, double num2, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

  
}