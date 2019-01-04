package br.com.sample.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sample.model.Produto;
import br.com.sample.services.ProdutoService;

@Controller
@RequestMapping("/mvc/produtos")
public class ProdutosController {
    
	@Autowired
    ProdutoService produtoService;

    @RequestMapping(method=RequestMethod.GET)
    public String produtos(Model model) {
        model.addAttribute("produtos", produtoService.getAll());
        return "produtos/produtos";
    }

    @RequestMapping(params="new", method=RequestMethod.GET)
    public String produtoAddView(Model model) {
        model.addAttribute(new Produto());
        return "produtos/edit";
    }
    
    @RequestMapping(params="car", method=RequestMethod.GET)
    public String produtoListCarView(Model model) {
        //TODO
        return "";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addProdutoFromForm(@Valid Produto produto, BindingResult bindingResult, @RequestParam(value="action", required=true) String action) {
        
    	System.out.println(" ~~ "+action);
    	
    	if (action.equals("save")) {
            if (bindingResult.hasErrors()) {
                return "produtos/edit";
            }
            produto.setIsAtivo((!produto.getIsAtivo()));
            produtoService.add(produto);
        }

        if (action.equals("delete")) {
        	produtoService.delete(produto);

        }
        return "redirect:/mvc/produtos";
    }



    @RequestMapping(value = "/edit/{produtoId}", method=RequestMethod.GET)
     public String produtoEditView(@PathVariable("produtoId") long produtoId, Model model) {
        Produto produto = produtoService.get(produtoId);
        produto.setIsAtivo(!produto.getIsAtivo());
        model.addAttribute("produto", produto);
        return "produtos/edit";
    }


    @RequestMapping(value = "/edit/{produtoId}", method=RequestMethod.POST)
    public String produtoUpdate(@PathVariable("produtoId") long produtoId, Model model, @Valid Produto produto, BindingResult bindingResult,  @RequestParam(value="action", required=true) String action ) {
        addProdutoFromForm(produto, bindingResult, action);
        return "redirect:/mvc/produtos";
    }


    @RequestMapping(value = "/delete/{produtoId}", method=RequestMethod.GET)
    public String produtoDeleteView(@PathVariable("produtoId") long produtoId, Model model) {
        model.addAttribute("produto", produtoService.get(produtoId));
        return "produtos/delete";
    }

    @RequestMapping(value = "/delete/{produtoId}", method=RequestMethod.POST)
    public String produtoDelete(@PathVariable("produtoId") long produtoId, Model model, @Valid Produto produto, BindingResult bindingResult,  @RequestParam(value="action", required=true) String action ) {
        addProdutoFromForm(produto, bindingResult, action);
        return "redirect:/mvc/produtos";
    }

    @RequestMapping(value = "/content",  method=RequestMethod.GET)
    public String testContent() {
        return "content";
    }

}
