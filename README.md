# H1 Weather
Aceasta aplicatie are rolul de informare a starii meteorologice.

# H3 Descriere
Aplcatia isi propune afisasrea datelor meteorologice citite din fisierul de input pentru diferite orase. Fisierul de input contine informatii cu orasul, tara, latitudinea 
si longitudinea acestuia, dar si id-ul orasului. Datele meteorologice sunt obtinute prin folosirea API-ului OpenWeatherMap. Acest lucru se realizeaza printr-un request
HTTP fiind alaturat numele orasului si cheia userului. Rezultatul este sub forma unui obiect JSON din care sunt extrase informatiile.

# H3 Utilizare
Aplicatia porneste cu afisarea unei interfete pentru utilizator. Acesta are optiunea de a selecta tara si orasul acesteia. Pentru a fi posibila selectia, mai intai se 
selecteaza tara, apoi orasul si se apasa pe buton de "Search". 
