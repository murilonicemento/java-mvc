/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unesa.exemploth001.model;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author denis
 */
public class ContatoRepositorio {
    
    private static final HashMap<String,Contato> contatos = new HashMap<>();
    
    static {
        contatos.put("Ana",new Contato("Ana","1111-1111"));
        contatos.put("Carlos", new Contato("Carlos","2222-2222"));
    }
    
    public void incluir(Contato contato){
        contatos.put(contato.getNome(), contato);
    }
    
    public void excluir(String nome){
        contatos.remove(nome);
    }
    
    public Collection<Contato> obterTodos(){
        return contatos.values();
    }
    
}
