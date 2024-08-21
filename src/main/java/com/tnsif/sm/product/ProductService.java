package com.tnsif.sm.product;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
    import java.util.List;
	import java.util.Optional;

	@Service
	public class ProductService {

	    @Autowired
	    private ProductRepository productRepository;

	    public List<Product> getAllProducts() {
	        return productRepository.findAll();
	    }

	    public Optional<Product> getProductById(int id) {
	        return productRepository.findById(id);
	    }

	    public Product addProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public void deleteProduct(int id) {
	        productRepository.deleteById(id);
	    }

	    public Product updateProduct(int id, Product productDetails) {
	        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
	        product.setName(productDetails.getName());
	        product.setDescription(productDetails.getDescription());
	        product.setPrice(productDetails.getPrice());
	        product.setStockQuantity(productDetails.getStockQuantity());
	        product.setCategory(productDetails.getCategory());
	        product.setStoreid(productDetails.getStoreid());
	        return productRepository.save(product);
	    }
	}


