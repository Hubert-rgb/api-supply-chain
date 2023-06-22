package com.supplyChain.product.product;

import com.supplyChain.product.productType.ProductType;
import com.supplyChain.product.productType.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    ProductService productService;

    //TODO it's incomplete
    @PostMapping("/user/{userId}/company/{companyId}/product_type/{productTypeId}")
    public Product createProduct(@PathVariable long userId, @PathVariable long companyId, @PathVariable long productTypeId){
        Product product = new Product();

        ProductType productType = productTypeService.getProductTypeById(productTypeId);

        product.setProductType(productType);

        productService.saveProduct(product);
        return product;
    }

    @GetMapping("")
    public List<Product> getAllMaterials(){
        return productService.getAllProducts();
    }

    @GetMapping("/{materialTypeId}")
    public Product getProduct(@PathVariable long productId){
        return productService.getProductById(productId);
    }
    @GetMapping("/company/{companyId}")
    public List<Product> getProductByCompanyId(@PathVariable long companyId){
        return productService.getByCompanyId(companyId);
    }
    @GetMapping("/user/{userId}")
    public List<Product> getProductByUserId(@PathVariable long userId){
        return productService.getByUserId(userId);
    }

    @GetMapping("/material_type/{materialTypeId}")
    public List<Product> getProductByProductTypeId(@PathVariable long productTypeId){
        return productService.getByProductTypeId(productTypeId);
    }
}
