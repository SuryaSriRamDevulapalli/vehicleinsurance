package com.revengers.team.implementation;

import java.util.Random;

public class Randomgen {
	
	public static int PolicyNo() {
        return new Random().nextInt(100000);
    }
	
	public static int Customerid() {
        return new Random().nextInt(100000);
    }
	
	public static void main(String[] args) {
        System.out.println("Generated Policy No: " + PolicyNo());
        System.out.println("Generated Customer ID: " + Customerid());
    }
}
