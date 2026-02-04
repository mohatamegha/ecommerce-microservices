package controller;

import entities.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import requestAndResponse.ProductPurchaseRequest;
import requestAndResponse.ProductPurchaseResponse;
import service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    public ProductService productService;

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody @Valid Product product){
        Product createdProduct = productService.addProduct(product);
        if(createdProduct!=null){
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseProducts(@RequestBody List<ProductPurchaseRequest> requestList){
        try {
            List<ProductPurchaseResponse> purchasedProducts = productService.purchaseProducts(requestList);
            return new ResponseEntity<>(purchasedProducts, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int productId){
        Product product = productService.getById(productId);
        if(product==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping()
    public List<Product> getProducts(){ //to get all products
        List<Product> productList = productService.getProducts();
        return productList;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<?> getProductById(@PathVariable Integer productId){
//        Product product = productService.getById(productId);
//        if(product!=null)
//            return new ResponseEntity<>(product, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
}
