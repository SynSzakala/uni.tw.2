# TW Lab 2

Autorzy: Jakub Walusiak, Juliusz Kościołek

Data: 27/03/2022

Laboratorium: TW, Lab-02

## Wykonanie

Stworzono klasę [Semafor](src/main/java/Semafor.java) bezpośrednio według algorytmu opisanego w zadaniu.  
Klasę użyto w problemie wyścigu w programie [SafeRace2](src/main/java/SafeRace2.java). Ta implementacja semafora
rozwiązuje problem wyścigu (w kilkunastu próbach program zwraca wynik `0`), ale okazuje się bardzo wolna (~4 sekundy).  
Stworzono więc klasę [BetterSemafor](src/main/java/BetterSemafor.java) opartą na prostszym algorytmie. Okazuje się, że
zastąpienie nią klasy `Semafor` zredukowało czas wykonania do ~400ms.
