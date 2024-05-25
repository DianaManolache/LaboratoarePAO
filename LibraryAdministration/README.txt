ADMINISTRAREA UNEI BIBLIOTECI

Aplicația are implementate diverse metode pentru gestionarea cărților și evidența persoanelor unei biblioteci. 
Interfața este direct din linia de comandă, prezentată sub forma unui meniu interactiv. 

Se deschide la pagina de pornire, unde te poți conecta sau înregistra. Avem 2 tipuri de utilizatori: administratori și useri (numiți uneori "cititori").
Datele sunt reținute într-o bază de date, o sesiune de conectare ține cât timp nu părăsim aplicația sau până dăm log out.
Nu se poate crea un cont de administrator, acesta există deja și este citit dintr-un fișier specific admin_data, unde cuvintele sunt despărțite prin semnul %.



Funcționalitățile aplicației:
Într-o aplicație autentificare și autorizarea sunt metoda prin care putem filtra accesul la resurse al utilizatorilor. În funcție de starea curentă a sesiunii, avem diferite tipuri de acces.

-> administratorii au dreptul și acces să modifice, să adauge să șteargă și să vizualizeze cărțile, userii și autorii;
-> userii au dreptul doar să să vizualizeze cărțile și autorii;



Ce pot face administratorii sunt acțiuni cu privire la:

cărți:
-vizualizare: toate cărțile, cărțile împrumutate de la data x la y, cărțile disponibile, fișele exemplarelor unei cărți, locația unei cărți
-adăugare: locație, carte, exemplar
-ștergere: locație, carte, exemplar
-modificare: locație, carte, exemplar, date din fișă

autori:
-vizualizare: toți autorii, toate cărțile de la un autor, unde găsesc cărțile autorului
-adăugare: autor
-ștergere: autor
-modificare: autor

useri:
-vizualizare: toți cititorii, ce a citit un user, dacă e vreo carte neadusă la timp înapoi
-adăugare: cititor
-ștergere: cititor
-modificare: cititor



Ce pot face userii sunt acțiuni cu privire la:

cărți:
-vizualizare: toate cărțile, cărțile împrumutate de la data x la y, cărțile disponibile, fișele exemplarelor unei cărți, locația unei cărți

autori:
-vizualizare: toți autorii, toate cărțile de la un autor, unde găsesc cărțile autorului

useri:
-vizualizare: toți cititorii, ce a citit un user, dacă e vreo carte neadusă la timp înapoi
