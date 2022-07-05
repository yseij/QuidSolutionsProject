# QuidSolutionsProject

## Install maven. 
1. De maven versie kun je vinden op de volgende website: https://maven.apache.org/download.cgi
2. Pak de zip bestand uit op je C schijf.
3. Klik op je windows knop en type omgevingsvariabelen in.
4. Klik op enter en klik dan op omgevingsvariabelen.
5. Klik dan op new System variabelen en type bij de variabele naam MAVAN_HOME in en bij de Variabele value de map van de MAVEN download.
6. Dubbel klik nu op path in de Systeemvariabelen lijst.
7. Klik dan op nieuw en vul dit in %MAVEN_HOME%\bin.

## Run applicatie.
1. Open je cmd als administrator en ga naar de root map van mijn applicatie en run dan het volgende commando: mvn spring-boot:run
2. Type dan in je web browser het volgende in http://localhost:8080/questions
