/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unesa.exemploth001.controller;

import com.unesa.exemploth001.model.Contato;
import com.unesa.exemploth001.model.ContatoRepositorio;
import java.io.Writer;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

/**
 *
 * @author denis
 */
public class ContatosList implements IController{

    ContatoRepositorio repositorio = new ContatoRepositorio();
    
    @Override
    public void process(WebContext ctx, ITemplateEngine templateEngine, Writer writer) {
        ctx.setVariable("listaContatos", repositorio.obterTodos());
        templateEngine.process("contatos",ctx,writer);
    }
    
}
