package com.tnsif.sm.product;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import java.util.List;
	import java.util.Optional;

	@RestController
	@RequestMapping("/products")
	public class ProductController {

	    @Autowired
	    private ProductService productService;

	    @GetMapping
	    public List<Product> getAllProducts() {
	        return productService.getAllProducts();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable int id) {
	        Optional<Product> product = productService.getProductById(id);
	        return product.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public Product addProduct(@RequestBody Product product) {
	        return productService.addProduct(product);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product productDetails) {
	        return ResponseEntity.ok(productService.updateProduct(id, productDetails));
	    }
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void>deleteProduct(@PathVariable int id) {
	        productService.deleteProduct(id);
	        return ResponseEntity.noContent().build();
	        
	    }
	}


