package com.datajpa.app.controllers;

import com.datajpa.app.models.dao.IDistritoRepository;
import com.datajpa.app.models.entity.Cliente;
import com.datajpa.app.service.DistritoServiceImpl;
import com.datajpa.app.service.IClienteService;
import com.datajpa.app.service.TrabajoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;
    @Autowired
    private TrabajoServiceImpl trabajoService;
    @Autowired
    private DistritoServiceImpl distritoService;



    @GetMapping("/listar")
    public String listar (Model model){
        model.addAttribute("titulo","Listado de Clientes");
        model.addAttribute("clientes", clienteService.findAll());
        return "listar";
    }
    @GetMapping("/form")
    public String crear (Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("titulo","Formulario de cliente");
        model.addAttribute("cliente",cliente);
        model.addAttribute("trabajos",trabajoService.findAll());
        model.addAttribute("distritos",distritoService.findAll());
        model.addAttribute("boton","crear cliente");
                return "form";
    }
    @PostMapping("/form")
    public String guardar (@Valid Cliente cliente , BindingResult result, Model model , SessionStatus status){
       if(result.hasErrors()){
           model.addAttribute("titulo","Formulario de cliente");
           model.addAttribute("trabajos",trabajoService.findAll());
           model.addAttribute("distritos",distritoService.findAll());
           model.addAttribute("boton","crear cliente");
           return "form";
       }
        clienteService.save(cliente);
        status.setComplete();
        return "redirect:listar";


    }
    @GetMapping("/form/{id}")
    public String editar (@PathVariable (value="id") Long id, Model model){
        Cliente cliente =   null;
        if(id>0){
           cliente = clienteService.findOne(id);
        } else {
            return "redirect:/listar";
        }
        model.addAttribute("titulo","Editar cliente");
        model.addAttribute("cliente",cliente);
        model.addAttribute("trabajos",trabajoService.findAll());
        model.addAttribute("distritos",distritoService.findAll());
        model.addAttribute("boton","editar cliente");
        return "form";
    }


    @RequestMapping("/eliminar/{id}")
    public String eliminar (@PathVariable(value="id") Long id){
        if(id>0){
            clienteService.delete(id);
        }
        return "redirect:/listar";
    }

}
