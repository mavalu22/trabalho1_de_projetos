/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;

public class BonusDTO {
    private int idBonus;
    private int idFuncionario;
    private String nome;
    private String data;
    private double valor;

    public BonusDTO(int idBonus, int idFuncionario, String nome, String data, double valor) {
        this.idBonus = idBonus;
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.data = data;
        this.valor = valor;
    }

    public BonusDTO() {
    }

    public int getIdBonus() {
        return idBonus;
    }

    public void setIdBonus(int idBonus) {
        this.idBonus = idBonus;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
    
    
}
