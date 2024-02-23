package com.uts.edu.version1.entity;

public class Chains {
    private int id;
    private String [] a;

    private String [] b;


    public Chains() {
    }

    public Chains(String[] a, String[] b) {
        this.a = a;
        this.b = b;
    }

    public Chains(int id, String[] a, String[] b) {
        this.id = id;
        this.a = a;
        this.b = b;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getA() {
        return a;
    }

    public void setA(String[] a) {
        this.a = a;
    }

    public String[] getB() {
        return b;
    }

    public void setB(String[] b) {
        this.b = b;
    }
}
