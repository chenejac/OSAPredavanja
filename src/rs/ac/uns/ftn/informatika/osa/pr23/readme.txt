FTN / Katedra za informatiku
Osnove softverskih arhitektura / 2016.
=================================

1. Lokacija primera
-------------------
rs.ac.uns.ftn.informatika.osa.pr23

2. Opis primera
---------------
Razliciti primeri rada sa primarnim kljucevima:

1) Kada se koriste surogatni kljucevi, jedinstvene vrednosti se generisu pomocu
   a) identity kolone                 PrimerIdentity.java
   b) sekvence                        PrimerSequence.java
   c) posebne tabele sa brojacima     PrimerTable.java
   
2) Kada se koriste prirodni kljucevi
Ako se primarni kljuc sastoji iz jedne kolone, odgovarajuci atribut entitija se
oznacava sa @Id. Ako se primarni kljuc sastoji iz vise kolona, svaki atribut se
oznacava sa @Id, i mora se napraviti posebna "primary key" klasa koja sadrzi sve
atribute koji cine primarni kljuc. Ako jedan deo primarnog kljuca predstavlja 
spoljni kljuc, atribut koji je veza prema roditelju se oznacava sa @Id i 
@JoinColumns; PK klasa sadrzi u sebi atribut-vezu prema PK klasi roditelja.

3. Sadrzaj primera
------------------
surrogate.* - primeri rada sa surogatnim kljucevima
natural.*   - primer rada sa prirodnim kljucevima

4. Pokretanje primera
---------------------
[dist/pr23] java -jar pr23-natural.jar