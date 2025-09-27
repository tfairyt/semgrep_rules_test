// test.safe.java
public class SafeSSRF {
    private static final Set<String> ALLOWED_DOMAINS = Set.of("api.tbank.ru", "internal.service");
    
    public String safeFetch(String userUrl) {
        // Валидация домена
        if (!ALLOWED_DOMAINS.contains(new URL(userUrl).getHost())) {
            throw new SecurityException("Domain not allowed");
        }
        return new RestTemplate().getForObject(userUrl, String.class);
    }
}
