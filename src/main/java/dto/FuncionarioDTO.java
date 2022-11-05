/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

public class FuncionarioDTO {
    private int id;
    private String nome;
    private int idade;
    private String cargo;
    private int falta;
    private double salario;
    private double salarioBase;   
    private int tempoServico;
    private int qtdMembroFamilia;
    private double distanciaTrabalho;
    private double valorTotalBonus;

    public FuncionarioDTO(int id, String nome, int idade, String cargo, int falta, double salario, double salarioBase, int tempoServico, int qtdMembroFamilia, double distanciaTrabalho, double valorTotalBonus) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
        this.falta = falta;
        this.salario = salario;
        this.salarioBase = salarioBase;
        this.tempoServico = tempoServico;
        this.qtdMembroFamilia = qtdMembroFamilia;
        this.distanciaTrabalho = distanciaTrabalho;
        this.valorTotalBonus = valorTotalBonus;
    }

    public FuncionarioDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getFalta() {
        return falta;
    }

    public void setFalta(int falta) {
        this.falta = falta;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(int tempoServico) {
        this.tempoServico = tempoServico;
    }

    public int getQtdMembroFamilia() {
        return qtdMembroFamilia;
    }

    public void setQtdMembroFamilia(int qtdMembroFamilia) {
        this.qtdMembroFamilia = qtdMembroFamilia;
    }

    public double getDistanciaTrabalho() {
        return distanciaTrabalho;
    }

    public void setDistanciaTrabalho(double distanciaTrabalho) {
        this.distanciaTrabalho = distanciaTrabalho;
    }

    public double getValorTotalBonus() {
        return valorTotalBonus;
    }

    public void setValorTotalBonus(double valorTotalBonus) {
        this.valorTotalBonus = valorTotalBonus;
    }


    
    


    
    
}
