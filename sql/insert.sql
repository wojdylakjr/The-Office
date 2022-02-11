INSERT INTO biuro.Stanowisko (id_stanowisko, nazwa, min_pensja, max_pensja)
VALUES (1, 'Szef', 10000, 20000),
       (2, 'Dyrektor', 7000, 9000),
       (3, 'Manager sprzedazy', 7000, 9000),
       (4, 'Starszy informatyk', 6000, 7000),
       (5, 'Mlodszy Informatyk', 5000, 6000),
       (6, 'Ksiegowy', 4000, 6000),
       (7, 'Handlowiec', 5000, 5500),
       (8, 'Kierownik magazynu', 4500, 5500),
       (9, 'Magazynier', 4000, 5000),
       (10, 'Sprzataczka', 600, 2500),
       (11, 'Specjalista HR', 3600, 8500),
       (12, 'Grafik', 5000, 7500),
       (13, 'Kierownik produkcji', 4000, 6500),
       (14, 'Pracownik produkcji', 3000, 5000),
       (15, 'Glowny ksiegowy', 6000, 9000);

-- ALTER TABLE biuro.Pracownik DISABLE CONSTRAINT pracownik_pracownik_fk;
-- ALTER TABLE biuro.Pracownik DISABLE CONSTRAINT dzial_firmy_pracownicy_fk;
--oddzialy

INSERT INTO biuro.Oddzial(id_oddzial, id_dyrektor_oddzial, miasto)
VALUES (1, NULL, 'New York'),
       (2, NULL, 'Scranton'),
       (3, NULL, 'Krakow');

--dzialy

INSERT INTO biuro.Dzial_firmy(id_dzial_firmy, id_kierownik_dzial, nazwa, id_oddzial, min_liczba_pracownikow, max_liczba_pracownikow)
VALUES --NEW YORK
 (1, NULL, 'Kierownictwo', NULL, 1, 2),
 --1
 (2, NULL, 'Produkjca', NULL, 1, 10),
 --2
 (3, NULL, 'Finanse', NULL, 1, NULL),
 --3
 --SCRANTON
 (4, NULL, 'Kierownictwo', NULL, 1, 2),
 --4
 (5, NULL, 'Sprzedaz', NULL, 2, 5),
 --5
 (6, NULL, 'Magazyn', NULL, 2, 5),
 --6
 (7, NULL, 'Ksiegowosc', NULL, 2, NULL),
 --7
 (8, NULL, 'HR', NULL, NULL, NULL),
 --8
 (9, NULL, 'IT', NULL, NULL, NULL),
 --9
 --KRAKOW
 (10, NULL, 'Kierownictwo', NULL, NULL, NULL),
 --10
 (11, NULL, 'IT', NULL, NULL, NULL),
 --11
 (12, NULL, 'HR', NULL, NULL, NULL);

--pracownicy

INSERT INTO biuro.Pracownik (id_pracownik, imie, nazwisko, premia, pensja, id_szef, id_stanowisko, id_dzial_firmy)
VALUES --NEW YORK
 ----kierownicy
 (1, 'David', 'Wallace', 1000, 12000, NULL, 1, 1),
 (2, 'Leo', 'Prosser', 500, 7700, 1, 2, 1),
 ----produkcja
 (3, 'Darien', 'Bateman', 200, 4300, 2, 13, 2),
 (4, 'Eliza', 'Hughes', 50, 4000, 3, 14, 2),
 (5, 'Jaward', 'Brown', 50, 3500, 3, 14, 2),
 ----finanse
 (6, 'Samiha', 'Ashton', 1000, 7500, 2, 15, 3),
 --SCRANTON
 (7, 'Micheal', 'Scott', 600, 8500, 1, 2, 4),
 ----sprzedaz
 (8, 'Jim', 'Halpert', 400, 7500, 7, 3, 5),
 (9, 'Dwight', 'Schrute', 100, 5000, 8, 7, 5),
 (10, 'Stanley', 'Hudson', 100, 5200, 8, 7, 5),
 (11, 'Phylis', 'Lopin', 100, 5200, 8, 7, 5),
 -----magazyn
 (12, 'Daryl', 'Philibin', 200, 4500, 7, 8, 6),
 (13, 'Loanie', 'Collins', 0, 4000, 13, 9, 6),
 ----ksiegowosc
 (14, 'Oscar', ' Martinez', 300, 5500, 7, 15, 7),
 (15, 'Kevin', ' Malone', 500, 4500, 15, 6, 7),
 (16, 'Angela', ' Martin', 0, 4000, 15, 6, 7),
 -----hr
 (17, 'Toby', 'Flenderson', 100, 3700, 7, 11, 8),
 -----it
 (18, 'Pam', 'Beesly', 500, 6700, 7, 12, 9),
 --KRAKOW
 (19, 'Marcin', 'Zalewski', 1000, 7500, 1, 2, 10),
 ----it
 (20, 'Max', 'Wojcik', 500, 6000, 19, 4, 11),
 (21, 'Jakub', 'Baran', 300, 5000, 20, 5, 11),
 (22, 'Anna', 'Błaszczyk', 300, 5100, 20, 5, 11),
 -----hr
 (23, 'Krystian', 'Sobczak', 1000, 5500, 19, 11, 12);

--UPDATE
--oddzial

UPDATE biuro.oddzial AS oddzial
SET id_dyrektor_oddzial = updated.id_dyrektor_oddzial,
    miasto = updated.miasto
FROM (
      VALUES (1, 2,'New York'), 
      (2, 7, 'Scranton'), 
      (3, 19,'Krakow')) 
      AS updated(id_oddzial, id_dyrektor_oddzial, miasto)
WHERE updated.id_oddzial = oddzial.id_oddzial;

--dzial

UPDATE biuro.dzial_firmy AS dzial
SET id_dzial_firmy = updated.id_dzial_firmy,
    id_kierownik_dzial = updated.id_kierownik_dzial,
    nazwa = updated.nazwa,
    id_oddzial = updated.id_oddzial,
    min_liczba_pracownikow = updated.min_liczba_pracownikow,
    max_liczba_pracownikow = updated.max_liczba_pracownikow
FROM (
      VALUES --NEW YORK
 (1,2,'Kierownictwo',1,1,2), --1
 (2,3,'Produkjca',1,1,10), --2
 (3,6,'Finanse',1,1,NULL), --3
 --SCRANTON
 (4,7,'Kierownictwo',2,1,2), --4
 (5, 8,'Sprzedaz',2,2,5), --5
 (6, 12,'Magazyn', 2,2,5), --6
 (7, 14, 'Ksiegowosc', 2, 2, NULL), --7
 (8, 15,'HR',2,NULL,NULL), --8
 (9, 18,'IT', 2, NULL,NULL), --9
 --KRAKOW
 (10,19,'Kierownictwo',3,NULL, NULL), --10
 (11, 20, 'IT', 3, NULL,NULL), --11
 (12,21, 'HR', 2, NULL, NULL))
 AS updated(id_dzial_firmy, id_kierownik_dzial, nazwa, id_oddzial, min_liczba_pracownikow, max_liczba_pracownikow)
WHERE updated.id_dzial_firmy = dzial.id_dzial_firmy;

--insert
--kategorie

INSERT INTO biuro.kategoria (id_kategoria, nazwa)
VALUES (1, 'Papier'),
       (2, 'Kartony'),
       (3, 'Koperty');

--produkty

INSERT INTO biuro.produkt (id_produkt, id_kategoria, nazwa, cena)
VALUES (1, 1, 'A5 100g 500 ark.', 15),
       (2, 1, 'A4 80g 500 ark.', 20),
       (3, 1, 'A3 80g 500 ark.', 25),
       (4, 2, 'Karton 200x150x100 20szt.', 16),
       (5, 2, 'Karton 150x150x150 20szt.', 12),
       (6, 2, 'Karton 200x150x75 20szt.', 15);

--klienci

INSERT INTO biuro.klient (id_klient, imie, nazwisko)
VALUES (1, 'Jacques', 'Webster'),
       (2, 'Jordan', 'Carter'),
       (3, 'Steve', 'Carell'),
       (4, 'Mateusz', 'Zawistowski');

--zamowienie

INSERT INTO biuro.zamowienie(id_zamowienie, id_klient, id_pracownik, DATA)
VALUES (1, 1, 8, CURRENT_TIMESTAMP);

--szczegoly zamowienia

INSERT INTO biuro.szczegoly_zamowienia(id_zamowienie, id_produkt, ilosc)
VALUES (1, 1, 20),
       (1, 2, 25),
       (1, 5, 8);

--wlaczenie auto-increment z powrotem
SELECT setval('biuro.pracownik_id_pracownik_seq', (SELECT MAX(id_pracownik) from biuro.pracownik));
SELECT setval('biuro.kategoria_id_kategoria_seq', (SELECT MAX(id_kategoria) from biuro.kategoria));
SELECT setval('biuro.produkt_id_produkt_seq', (SELECT MAX(id_produkt) from biuro.produkt));
SELECT setval('biuro.klient_id_klient_seq', (SELECT MAX(id_klient) from biuro.klient));
SELECT setval('biuro.stanowisko_id_stanowisko_seq', (SELECT MAX(id_stanowisko) from biuro.stanowisko));
SELECT setval('biuro.oddzial_id_oddzial_seq', (SELECT MAX(id_oddzial) from biuro.oddzial));
SELECT setval('biuro.dzial_firmy_id_dzial_firmy_seq', (SELECT MAX(id_dzial_firmy) from biuro.dzial_firmy));
SELECT setval('biuro.zamowienie_id_zamowienie_seq', (SELECT MAX(id_zamowienie) from biuro.zamowienie));

