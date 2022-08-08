package com.datajpa.app.controllers;

import com.datajpa.app.Page.PageRender;
import com.datajpa.app.models.dao.IDistritoRepository;
import com.datajpa.app.models.entity.Cliente;
import com.datajpa.app.service.DistritoServiceImpl;
import com.datajpa.app.service.IClienteService;
import com.datajpa.app.service.TrabajoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String listar (@RequestParam(name = "page",defaultValue = "0") int page, Model model){
        Pageable pageRequest = PageRequest.of(page, 5);
        Page<Cliente> clientes=clienteService.findAll(pageRequest);
        PageRender<Cliente> pageRender=new PageRender<>("/listar",clientes);
        model.addAttribute("titulo","Listado de Clientes");
        model.addAttribute("clientes", clientes);
        model.addAttribute("page",pageRender);
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
    public String guardar (@Valid Cliente cliente , BindingResult result, Model model , RedirectAttributes flash, SessionStatus status){
       if(result.hasErrors()){
           model.addAttribute("titulo","Formulario de cliente");
           model.addAttribute("trabajos",trabajoService.findAll());
           model.addAttribute("distritos",distritoService.findAll());
           model.addAttribute("boton","crear cliente");
           return "form";
       }
       String mensajeflash=(cliente.getId() != null)?"Cliente editado con exito":"Cliente creado con exito";
        clienteService.save(cliente);
        status.setComplete();

        flash.addFlashAttribute("success",mensajeflash);
        return "redirect:listar";


    }
    @GetMapping("/form/{id}")
    public String editar (@PathVariable (value="id") Long id, Model model,RedirectAttributes flash){
        Cliente cliente =   null;
        if(id>0){
           cliente = clienteService.findOne(id);
           if (cliente==null){
               flash.addFlashAttribute("error","El ID del cliente no existe");
               return "redirect:/listar";
           }

        } else {
            flash.addFlashAttribute("error","El ID del cliente no existe");
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
    public String eliminar (@PathVariable(value="id") Long id, RedirectAttributes flash){
        if(id>0){
            clienteService.delete(id);
            flash.addFlashAttribute("success","Cliente eliminado de manera exitosa");
        }
        return "redirect:/listar";
    }

}
