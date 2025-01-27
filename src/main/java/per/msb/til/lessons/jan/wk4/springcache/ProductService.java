package per.msb.til.lessons.jan.wk4.springcache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
class ProductService {

    @Cacheable(value = "products", key = "#id", condition = "#id > 10")
    public Product getProductById(Long id) {
        // Simulate a slow database query
        try {
            Thread.sleep(3000); // Simulates a delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Product(id, "Sample Product");
    }

    @CachePut(value = "products", key = "#product.id")
    public Product updateProduct(Product product) {
        // Update product logic
        return product;
    }

    @CacheEvict(value = "products", key = "#id")
    public void deleteProduct(Long id) {
        // Delete product logic
    }

    @CacheEvict(value = "products", allEntries = true)
    public void clearCache() {
        // Logic to clear cache
    }
}