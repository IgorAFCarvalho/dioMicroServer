package digitalinnovation.one.experts.productcatalog.controller;

import digitalinnovation.one.experts.productcatalog.model.Product;
import digitalinnovation.one.experts.productcatalog.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {
        return produtoRepository.save(product);
    }

    @RequestMapping
    public Iterable<Product> list() {
        return produtoRepository.findAll();
    }

    @RequestMapping(value = "/{id}")
    public Optional<Product> findById(@PathVariable("id") Integer id) {
        return produtoRepository.findById(id);
    }

    @RequestMapping(value = "/name/{name}")
    public Iterable<Product> findByName(@PathVariable("name") String name) {
        return produtoRepository.findByName(name);
    }

}
