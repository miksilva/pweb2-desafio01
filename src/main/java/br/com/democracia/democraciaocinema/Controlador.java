package br.com.democracia.democraciaocinema;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controlador{

    @RequestMapping("/formulario")
    public ModelAndView formulario() {
        return new ModelAndView("formulario.html");
    }
    
    @RequestMapping("/resultado")
    public ModelAndView resultado(String nome, String senha){
        String novaSenha = senha.replaceAll(" ", "");
        
        ModelAndView mv = new ModelAndView("resultado.html");
        String novoNome = nome.replaceAll(" ", "");
        mv.addObject("nome", "Seu nome tem " + novoNome.length() + " letras");
        mv.addObject("senha", "sua senha começa com " + senha.charAt(0));
        if (novoNome.equals("") || novaSenha.equals("")) {
            ModelAndView mj = new ModelAndView("formulario.html");
            mj.addObject("erro1","Os dois campos são obrigatorios");
            return mj;
        }
       
        return mv;
        
    }


}