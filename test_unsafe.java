// test.unsafe.java
@RestController
public class UnsafeSSRF {
    @GetMapping("/fetch")
    public String fetchData(@RequestParam String url) {
        // Опасные паттерны
        new URL(url).openStream();  // Прямое использование
        new RestTemplate().getForObject(url, String.class);  // Spring RestTemplate
        return WebClient.create(url).get().retrieve().bodyToMono(String.class).block();
    }
}
