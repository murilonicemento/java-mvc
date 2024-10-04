package com.unesa.exemploth001.controller;

import java.util.HashMap;

public class ControllerMappings {
    private final static HashMap<String, IController> controladores;
    static {
        controladores = new HashMap<>();
        controladores.put("/app/contato/list", new ContatosList());
        controladores.put("/app/contato/incluir", new ContatosIncluir());
        controladores.put("/app/contato/excluir", new ContatosExcluir());
    }
    public static IController fromPath(final String path) {
        return controladores.get(path);
    }
    
}
