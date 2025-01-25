package per.msb.til.lessons.jan.wk4.projections;
/**
 * Method to only fetch selected necessary fields from the entity using JPA
 * Four different methods.
 * 1. closed projection (interface-based) : as defined in the projection
 * 2. open projection   (interface-based) : defined projection using SpEL
 * 3. class-based(DTO) projection : defined in Dto projection.
 * 4. dynamic projection: projection defined at runtime
 *
 * reference:
 * https://medium.com/@ahmed.abdelfaheem/spring-boot-projections-uncovered-how-to-fetch-just-what-you-need-c326615790d6
 *
 */