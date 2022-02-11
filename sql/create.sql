CREATE SCHEMA biuro;

CREATE SEQUENCE biuro.kategoria_id_kategoria_seq;

CREATE TABLE biuro.kategoria
  (
     id_kategoria INTEGER NOT NULL DEFAULT NEXTVAL(
     'biuro.kategoria_id_kategoria_seq'
     ),
     nazwa        VARCHAR(20) NOT NULL,
     CONSTRAINT id_kategoria PRIMARY KEY (id_kategoria)
  );

ALTER SEQUENCE biuro.kategoria_id_kategoria_seq owned BY
biuro.kategoria.id_kategoria;

CREATE SEQUENCE biuro.produkt_id_produkt_seq;

CREATE TABLE biuro.produkt
  (
     id_produkt   INTEGER NOT NULL DEFAULT NEXTVAL(
     'biuro.produkt_id_produkt_seq'),
     id_kategoria INTEGER NOT NULL,
     nazwa        VARCHAR(40) NOT NULL,
     cena         INTEGER NOT NULL,
     CONSTRAINT id_produkt PRIMARY KEY (id_produkt)
  );

ALTER SEQUENCE biuro.produkt_id_produkt_seq owned BY biuro.produkt.id_produkt;

CREATE SEQUENCE biuro.klient_id_klient_seq;

CREATE TABLE biuro.klient
  (
     id_klient INTEGER NOT NULL DEFAULT NEXTVAL('biuro.klient_id_klient_seq'),
     imie      VARCHAR(20) NOT NULL,
     nazwisko  VARCHAR(50) NOT NULL,
     CONSTRAINT id_klient PRIMARY KEY (id_klient)
  );

ALTER SEQUENCE biuro.klient_id_klient_seq owned BY biuro.klient.id_klient;

CREATE SEQUENCE biuro.stanowisko_id_stanowisko_seq;

CREATE TABLE biuro.stanowisko
  (
     id_stanowisko INTEGER NOT NULL DEFAULT NEXTVAL(
     'biuro.stanowisko_id_stanowisko_seq'),
     nazwa         VARCHAR(20) NOT NULL,
     min_pensja    INTEGER,
     max_pensja    INTEGER,
     CONSTRAINT id_stanowisko PRIMARY KEY (id_stanowisko)
  );

ALTER SEQUENCE biuro.stanowisko_id_stanowisko_seq owned BY
biuro.stanowisko.id_stanowisko;

CREATE SEQUENCE biuro.pracownik_id_pracownik_seq;

CREATE TABLE biuro.pracownik
  (
     id_pracownik   INTEGER NOT NULL DEFAULT NEXTVAL(
     'biuro.pracownik_id_pracownik_seq'
     ),
     id_stanowisko  INTEGER NOT NULL,
     id_dzial_firmy INTEGER NOT NULL,
     imie           VARCHAR(20) NOT NULL,
     nazwisko       VARCHAR(50) NOT NULL,
     premia         INTEGER DEFAULT 0,
     pensja         INTEGER NOT NULL,
     id_szef        INTEGER,
     CONSTRAINT id_pracownik PRIMARY KEY (id_pracownik)
  );

ALTER SEQUENCE biuro.pracownik_id_pracownik_seq owned BY
biuro.pracownik.id_pracownik;

CREATE SEQUENCE biuro.oddzial_id_oddzial_seq;

CREATE TABLE biuro.oddzial
  (
     id_oddzial          INTEGER NOT NULL DEFAULT NEXTVAL(
     'biuro.oddzial_id_oddzial_seq'),
     id_dyrektor_oddzial INTEGER,
     miasto              VARCHAR(40) NOT NULL,
     CONSTRAINT id_oddzial PRIMARY KEY (id_oddzial)
  );

ALTER SEQUENCE biuro.oddzial_id_oddzial_seq owned BY biuro.oddzial.id_oddzial;

CREATE SEQUENCE biuro.dzial_firmy_id_dzial_firmy_seq;

CREATE TABLE biuro.dzial_firmy
  (
     id_dzial_firmy         INTEGER NOT NULL DEFAULT NEXTVAL(
     'biuro.dzial_firmy_id_dzial_firmy_seq'),
     id_kierownik_dzial     INTEGER,
     id_oddzial             INTEGER,
     nazwa                  VARCHAR(40) NOT NULL,
     max_liczba_pracownikow INTEGER,
     min_liczba_pracownikow INTEGER,
     CONSTRAINT id_dzial_firmy PRIMARY KEY (id_dzial_firmy)
  );

ALTER SEQUENCE biuro.dzial_firmy_id_dzial_firmy_seq owned BY
biuro.dzial_firmy.id_dzial_firmy;

CREATE SEQUENCE biuro.zamowienie_id_zamowienie_seq;

CREATE TABLE biuro.zamowienie
  (
     id_zamowienie INTEGER NOT NULL DEFAULT NEXTVAL(
     'biuro.zamowienie_id_zamowienie_seq'),
     id_klient     INTEGER NOT NULL,
     id_pracownik  INTEGER NOT NULL,
     data          TIMESTAMPTZ NOT NULL,
     CONSTRAINT id_zamowienie PRIMARY KEY (id_zamowienie)
  );

ALTER SEQUENCE biuro.zamowienie_id_zamowienie_seq owned BY
biuro.zamowienie.id_zamowienie;

CREATE TABLE biuro.szczegoly_zamowienia
  (
     id_zamowienie INTEGER NOT NULL,
     id_produkt    INTEGER NOT NULL,
     ilosc         INTEGER NOT NULL,
     CONSTRAINT id_szczegoly_zamowienie PRIMARY KEY (id_zamowienie, id_produkt)
  );

ALTER TABLE biuro.produkt
  ADD CONSTRAINT kategoria_produkt_fk FOREIGN KEY (id_kategoria) REFERENCES
  biuro.kategoria (id_kategoria) ON DELETE no action ON UPDATE no action NOT
  deferrable;

ALTER TABLE biuro.szczegoly_zamowienia
  ADD CONSTRAINT produkt_zamowienie_produkt_fk FOREIGN KEY (id_produkt)
  REFERENCES biuro.produkt (id_produkt) ON DELETE no action ON UPDATE no action
  NOT deferrable;

ALTER TABLE biuro.zamowienie
  ADD CONSTRAINT klient_pracownik_klient_fk FOREIGN KEY (id_klient) REFERENCES
  biuro.klient (id_klient) ON DELETE no action ON UPDATE no action NOT
  deferrable;

ALTER TABLE biuro.pracownik
  ADD CONSTRAINT stanowisko_pracownik_fk FOREIGN KEY (id_stanowisko) REFERENCES
  biuro.stanowisko (id_stanowisko) ON DELETE no action ON UPDATE no action NOT
  deferrable;

ALTER TABLE biuro.zamowienie
  ADD CONSTRAINT pracownik_pracownik_klient_fk FOREIGN KEY (id_pracownik)
  REFERENCES biuro.pracownik (id_pracownik) ON DELETE no action ON UPDATE no
  action NOT deferrable;

ALTER TABLE biuro.pracownik
  ADD CONSTRAINT pracownik_pracownik_fk FOREIGN KEY (id_szef) REFERENCES
  biuro.pracownik (id_pracownik) ON DELETE no action ON UPDATE no action NOT
  deferrable;

ALTER TABLE biuro.oddzial
  ADD CONSTRAINT pracownik_oddzial_fk FOREIGN KEY (id_dyrektor_oddzial)
  REFERENCES biuro.pracownik (id_pracownik) ON DELETE no action ON UPDATE no
  action NOT deferrable;

ALTER TABLE biuro.dzial_firmy
  ADD CONSTRAINT pracownik_dzial_firmy_fk FOREIGN KEY (id_kierownik_dzial)
  REFERENCES biuro.pracownik (id_pracownik) ON DELETE no action ON UPDATE no
  action NOT deferrable;

ALTER TABLE biuro.dzial_firmy
  ADD CONSTRAINT oddzial_dzial_firmy_fk FOREIGN KEY (id_oddzial) REFERENCES
  biuro.oddzial (id_oddzial) ON DELETE no action ON UPDATE no action NOT
  deferrable;

ALTER TABLE biuro.pracownik
  ADD CONSTRAINT dzial_firmy_pracownicy_fk FOREIGN KEY (id_dzial_firmy)
  REFERENCES biuro.dzial_firmy (id_dzial_firmy) ON DELETE no action ON UPDATE no
  action NOT deferrable;

ALTER TABLE biuro.szczegoly_zamowienia
  ADD CONSTRAINT zamowienie_zamowienie_produkt_fk FOREIGN KEY (id_zamowienie)
  REFERENCES biuro.zamowienie (id_zamowienie) ON DELETE no action ON UPDATE no
  action NOT deferrable; 