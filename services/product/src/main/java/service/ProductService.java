package service;

import entities.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;
import requestAndResponse.Mapper;
import requestAndResponse.ProductPurchaseRequest;
import requestAndResponse.ProductPurchaseResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {

//    @Autowired
    ProductRepository productRepository;

//    @Autowired
    Mapper mapper;

    public Product addProduct(@Valid Product product) {
        Product savedProduct =  productRepository.save(product);
        return savedProduct;
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> requestList){

        List<Integer> productIds = requestList
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();
        List<Product> products = productRepository.findAllById(productIds);

        if (products.size() != productIds.size()) {
            throw new RuntimeException("One or more products does not exist!");
        }


        List<ProductPurchaseResponse> purchasedProducts = new ArrayList<>();
//        List<Product> newUpdatedProducts = new ArrayList<>();

        for(int i=0; i<requestList.size(); i++){
            ProductPurchaseRequest requestedProduct = requestList.get(i);
            int id = requestedProduct.productId();
            Product product = productRepository.findById(id).orElse(null);
            assert product != null;
            int quantityDemanded = requestedProduct.quantity();
            int quantityAvailable = product.getAvailableQuantity();
            if(quantityDemanded>quantityAvailable) {
                throw new RuntimeException("Unsufficient quantity!");
            }
            product.setAvailableQuantity(quantityAvailable-quantityDemanded);
            if(product.getAvailableQuantity()>0){
//                newUpdatedProducts.add(product);
                productRepository.save(product);
            }
            purchasedProducts.add(mapper.toProductPurchaseResponse(product, quantityDemanded));
        }

        return purchasedProducts;
    }

    public Product getById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
