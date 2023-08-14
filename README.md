# contractors_rest_repo
Java 8, Spring Boot 2.7.12, h2database


To Do : 
- dodać lombok do warstwy modelu
- dodac poprawki z feedback
  "Trochę zabrakło klas z warstwy prezentacji oddzielając implementację ORM od udostępnionego API (tak zwana warstwa DTO). 
W tym projekcie to nieistotne, ale jest dobrą praktyką
Ale w sumie zadanie jest na szybko i nie było w specyfikacji wymogu na oddzielną warstwę prezentacji

Podoba mi się wydzielenie warstwy serwisowej od kontrolera. Mam tylko uwagę do pobierania listy kontrahentów - brakuje stronicowania. Jest po prostu lista. Mimo braku tego w specyfikacji, dobrą praktyką jest pisanie endpointów, które zakończą swoje działanie w określonym czasie. W tym przypadku, jeżeli kontrahentów będzie mnóstwo, to i koszt do pobrania/serializacji jest liniowy i nie jest w żaden sposób ograniczony.
Stronicowanie zapobiegłoby temu.

Drobną uwagę też mam na brak patternu interface​ i implementacja tego. Np dobrym materiałem do tego jest interface ContractorService​
i jego implementacja w class ContractorServiceImpl implements ContractorService​
I wstrzyknięcie do ContractorController​ interfaejsu.
Pomaga to i w testach i później przy różnego rodzaju interceptorów springowych (chociażby przy adnotacji @Transactional​, której tu też zabrakło)

Analizując klasę ContractorService​ trochę zaskoczył mnie fakt, że przy aktualizacji danych istniejącego rekordu wywołujemy metodę do dodawania kontrahenta, a nie po prostu save​ z repozytorium. W momencie dodania jakiejś biznesowej logiki przy dodawaniu nowego kontrahenta to może się rozjechać.

Trochę zabrakło obsługi błędów. Np przy aktualizacji/usunięciu danych nieistniejącego rekordu powinno pójść 404 z informacją o tym, co poszło nie tak.

Liczyłem po cichu, że będą testy jednostkowe i trochę bardziej udokumentowane openapi
"
