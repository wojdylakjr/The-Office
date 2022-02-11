--zamowienia
CREATE OR replace VIEW zamowienia
AS
  SELECT szczegoly_zamowienia.id_zamowienie AS id_zamowienie,
         klient.imie                        AS klient_imie,
         klient.nazwisko                    AS klient_nazwisko,
         pracownik.imie                     AS pracownik_imie,
         pracownik.nazwisko                 AS pracownik_nazwisko,
         zamowienie.data,
         produkt.nazwa,
         ilosc,
         cena,
         cena * ilosc                       AS suma
  FROM   biuro.szczegoly_zamowienia
         join biuro.zamowienie
           ON zamowienie.id_zamowienie = szczegoly_zamowienia.id_zamowienie
         join biuro.klient
           ON klient.id_klient = zamowienie.id_klient
         join biuro.pracownik
           ON zamowienie.id_pracownik = pracownik.id_pracownik
         join biuro.produkt
           ON produkt.id_produkt = szczegoly_zamowienia.id_produkt;

--pracownicy
CREATE OR replace VIEW pracownicy
AS
  SELECT pracownik.id_pracownik AS id_pracownik,
         pracownik.imie         AS pracownik_imie,
         pracownik.nazwisko     AS pracownik_nazwisko,
         pracownik.premia       AS premia,
         pracownik.pensja       AS pensja,
         stanowisko.nazwa       AS stanowisko,
         szef.imie              AS szef_imie,
         szef.nazwisko          AS szef_nazwisko,
         dzial_firmy.nazwa      AS dzial_firmy
  FROM   biuro.pracownik pracownik
         left join biuro.pracownik szef
                ON pracownik.id_szef = szef.id_pracownik
         join biuro.stanowisko
           ON pracownik.id_stanowisko = stanowisko.id_stanowisko
         join biuro.dzial_firmy
           ON pracownik.id_dzial_firmy = dzial_firmy.id_dzial_firmy;

--ranking produktow, posortowane po ilosci sprzedanych produktow, oraz przychod wygenerowany przez ten produkt
CREATE VIEW ranking_produktow
AS
  SELECT produkt.nazwa,
         SUM(ilosc)        AS ilosc_sprzedanych_sztuk,
         SUM(ilosc * cena) AS przychod_produktu
  FROM   biuro.produkt
         join biuro.szczegoly_zamowienia
           ON produkt.id_produkt = szczegoly_zamowienia.id_produkt
  GROUP  BY produkt.id_produkt
  ORDER  BY ilosc_sprzedanych_sztuk DESC;

--szczegoly stanowiska
CREATE OR replace VIEW szczegoly_stanowiska
AS
  SELECT Min(nazwa),
         Round(Avg(pensja + premia)) AS srednia_wyplata,
         max_pensja                  AS max_wyplata,
         min_pensja                  AS min_wyplata,
         Count(*)                    AS pracownicy_stanowisko,
         (SELECT Count(*)
          FROM   biuro.pracownik p2
          WHERE  p2.id_stanowisko = p1.id_stanowisko
                 AND p2.premia > 0)  AS ilosc_premii
  FROM   biuro.pracownik p1
         join biuro.stanowisko
           ON p1.id_stanowisko = stanowisko.id_stanowisko
  GROUP  BY p1.id_stanowisko,
            max_pensja,
            min_pensja;

--poprawiony ranking pracownikow
CREATE VIEW ranking_sprzedawcow
AS
  SELECT pracownik.imie                                        AS pracownik_imie
         ,
         pracownik.nazwisko                                    AS
            pracownik_nazwisko,
         SUM(ilosc * produkt.cena)                             AS przychod,
         Count(DISTINCT( szczegoly_zamowienia.id_zamowienie )) AS ilosc_zamowien
         ,
         Count(DISTINCT( zamowienie.id_klient ))               AS
         ilosc_klientow
  FROM   biuro.pracownik
         join biuro.zamowienie
           ON pracownik.id_pracownik = zamowienie.id_pracownik
         join biuro.szczegoly_zamowienia
           ON zamowienie.id_zamowienie = szczegoly_zamowienia.id_zamowienie
         join biuro.produkt
           ON szczegoly_zamowienia.id_produkt = produkt.id_produkt
  GROUP  BY pracownik.id_pracownik
  ORDER  BY przychod DESC;

--zarobki pracownika i widelki na jego pozycji
CREATE OR replace VIEW pracownik_zarobki
AS
  SELECT id_pracownik,
         pracownik.pensja,
         min_pensja,
         max_pensja
  FROM   biuro.pracownik
         join biuro.stanowisko
           ON stanowisko.id_stanowisko = pracownik.id_stanowisko; 