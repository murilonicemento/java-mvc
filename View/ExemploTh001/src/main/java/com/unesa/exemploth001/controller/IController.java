/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unesa.exemploth001.controller;

import java.io.Writer;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

/**
 *
 * @author denis
 */
public interface IController {
    void process(final WebContext ctx, final ITemplateEngine templateEngine, final Writer writer);
}
