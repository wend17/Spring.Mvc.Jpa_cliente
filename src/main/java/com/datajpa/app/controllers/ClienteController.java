package com.datajpa.app.controllers;

import com.datajpa.app.models.dao.IclienteDao;
import com.datajpa.app.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Optional;

@Controller
@SessionAttributes("cliente")
public class ClienteController {


    @Autowired
    @Qualifier("clienteDaoJPA") // para definir la implementación a usar
    private IclienteDao clienteDao;




    @GetMapping("/listar")
    public String listar (Model model){
        model.addAttribute("titulo","Listado de Clientes");
        model.addAttribute("clientes", clienteDao.finAll());
        return "listar";
    }
    @GetMapping("/form")
    public String crear (Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("cliente",cliente);
        model.addAttribute("titulo","Formulario de cliente");
                return "form";
    }
    @GetMapping("/form/{id}")
    public String editar (@PathVariable (value="id") Long id, Model model){
        Cliente cliente =null;
        if(id>0){
           cliente = clienteDao.findOne(id);
        } else {
            return "redirect:/listar";
        }
        model.addAttribute("cliente",cliente);
        model.addAttribute("titulo","Editar cliente");
        return "form";
    }

    @PostMapping("/form")
    public String guardar (Cliente cliente , Model model , SessionStatus status){
        clienteDao.save(cliente);
        status.setComplete();
            return "redirect:listar";


    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar (@PathVariable(value="id") Long id){
        if(id>0){
            clienteDao.delete(id);
        }
        return "redirect:/listar";
    }

}
