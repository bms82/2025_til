package per.msb.til.lessons.jan.wk4.springcache;
/**
 *
 * Spring Annotations on Caching.
 *     @Cacheable: Caches the result of a method based on its parameters.
 *     @CachePut: Updates the cache with the method’s result.
 *     @CacheEvict: Removes data from the cache.
 *     @Caching: Allows combining multiple caching annotations using a single method.
 *
 * Using External Service : Redis
 *
 * Things to Consider
 *     Cache Expiration: If using an external cache provider, configure cache expiration to avoid stale data. For example, in Redis, you can set TTL (Time-To-Live) for cache entries.
 *     Logging: Enable cache logging for monitoring cache hits and misses.
 *     Avoid Over-Caching: Cache only data that is frequently accessed and expensive to retrieve.
 *     Use Unique Cache Names: Use unique names for caches in multi-module projects to avoid cache collisions.
 */