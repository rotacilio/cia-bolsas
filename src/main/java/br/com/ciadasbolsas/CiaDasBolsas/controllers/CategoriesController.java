package br.com.ciadasbolsas.CiaDasBolsas.controllers;

import br.com.ciadasbolsas.CiaDasBolsas.domain.Category;
import br.com.ciadasbolsas.CiaDasBolsas.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(value = "Categories controller", description = "Controlador de categorias")
@RestController
@RequestMapping(value = "/categories")
public class CategoriesController {

    @Autowired
    private CategoryService mService;

    @ApiOperation(value = "Listar todas as categorias")
    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return mService.getAllCategories();
    }

    @ApiOperation(value = "Criar uma nova categoria")
    @RequestMapping(method = RequestMethod.POST)
    public Category createNewCategory(
            @ApiParam(value = "Nome da categoria a ser criada", required = true)
            @NotBlank @RequestParam String name) {
        return mService.createNewCategory(name);
    }

    @ApiOperation(value = "Buscar categoria pelo ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category findById(
            @ApiParam(value = "ID da categoria", required = true)
            @NotNull @PathVariable Long id) {
        return mService.getCategoryById(id);
    }
}
