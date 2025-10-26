package org.acme.controller;

import java.util.List;

import org.acme.entities.Product;
import org.acme.models.CreateProductDto;
import org.acme.service.ProductService;
import org.jboss.resteasy.reactive.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/product")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<Object> create(CreateProductDto newProduct){
        Product newProductDto = productService.create(newProduct);
        return RestResponse.ok(newProductDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestResponse<Object> findAll(){
        List<Product> allProducts = productService.findAll();
        return RestResponse.ok(allProducts);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<Object> findById(int id){
        Product product = productService.findById(id);
        return RestResponse.ok(product);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<Object> delete(int id){
        productService.deleteProduct(id);
        return RestResponse.ok("Produto deletado com sucesso");
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<Object> update(CreateProductDto productDto){
        productService.update(productDto);
        Product updatedProduct = productService.findById(productDto.getId());
        return RestResponse.ok(updatedProduct);
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<Object> addProductToCart(@QueryParam("userId") int userId,
                                                    @QueryParam("productId") int productId){
        productService.addProductToCart(userId, productId);
        return RestResponse.ok("Produto adicionado com sucesso");
    }

    @DELETE
    @Path("/remove")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RestResponse<Object> remoreProductFromCart(@QueryParam("userId") int userId,
                                                        @QueryParam("productId") int productId){
        productService.removeProductFromCart(userId, productId);
        return RestResponse.ok("Produto removido com sucesso");
    }

}
