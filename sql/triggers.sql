--walidacja danych do stanowiska
CREATE OR replace FUNCTION biuro.sprawdz_dane_stanowisko
  () returns TRIGGER
AS
  $$
BEGIN
  IF NEW.min_pensja < 0
    OR
    NEW.max_pensja < 0 THEN
    RAISE
  EXCEPTION
    'Wartosci musza byc wieksze od zera';
    RETURN NULL;
  END IF;
  IF NEW.min_pensja > NEW.max_pensja THEN
    RAISE
  EXCEPTION
    'Pensjalna minimalna musi byc mniejsza od maksymalnej';
    RETURN NULL;
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;
DROP TRIGGER
IF EXISTS walidacja_stanowisko ON biuro.stanowisko;
  CREATE TRIGGER walidacja_stanowisko BEFORE
  INSERT
  OR
  UPDATE
  ON biuro.stanowisko FOR EACH ROW EXECUTE PROCEDURE biuro.sprawdz_dane_stanowisko();
  
  --walidacja danych dzialu
  CREATE OR replace FUNCTION biuro.sprawdz_dane_dzial_firmy
    () returns TRIGGER
  AS
    $$
  BEGIN
    IF NEW.min_liczba_pracownikow < 0
      OR
      NEW.max_liczba_pracownikow < 0 THEN
      RAISE
    EXCEPTION
      'Wartosci musza byc wieksze od zera';
      RETURN NULL;
    END IF;
    IF NEW.min_liczba_pracownikow > NEW.max_liczba_pracownikow THEN
      RAISE
    EXCEPTION
      'Minimalna liczba pracownikow musi byc mniejsza od maksymalnej';
      RETURN NULL;
    END IF;
    RETURN NEW;
  END;
  $$ LANGUAGE plpgsql;
  DROP TRIGGER
  IF EXISTS walidacja_dzial_firmy ON biuro.dzial_firmy;
    CREATE TRIGGER walidacja_dzial_firmy BEFORE
    INSERT
    OR
    UPDATE
    ON biuro.dzial_firmy FOR EACH ROW EXECUTE PROCEDURE biuro.sprawdz_dane_dzial_firmy();
    
    --walidacja produktu
    CREATE OR replace FUNCTION biuro.sprawdz_dane_produktu
      () returns TRIGGER
    AS
      $$
    BEGIN
      IF NEW.cena < 0 THEN
        RAISE
      EXCEPTION
        'Cena musi byc wieksze od zera';
        RETURN NULL;
      END IF;
      RETURN NEW;
    END;
    $$ LANGUAGE plpgsql;
    DROP TRIGGER
    IF EXISTS walidacja_produkt ON biuro.produkt;
      CREATE TRIGGER walidacja_produkt BEFORE
      INSERT
      OR
      UPDATE
      ON biuro.produkt FOR EACH ROW EXECUTE PROCEDURE biuro.sprawdz_dane_produktu();
      
      --sprawdzenie ilosci produktow
      CREATE OR replace FUNCTION biuro.sprawdz_szczegoly_zamowienia
        () returns TRIGGER
      AS
        $$
      BEGIN
        IF NEW.ilosc < 0 THEN
          RAISE
        EXCEPTION
          'Ilosc musi byc wieksze od zera';
          RETURN NULL;
        END IF;
        RETURN NEW;
      END;
      $$ LANGUAGE plpgsql;
      DROP TRIGGER
      IF EXISTS walidacja_szczegoly_zamowienia ON biuro.szczegoly_zamowienia;
        CREATE TRIGGER walidacja_szczegoly_zamowienia BEFORE
        INSERT
        OR
        UPDATE
        ON biuro.szczegoly_zamowienia FOR EACH ROW EXECUTE PROCEDURE biuro.sprawdz_szczegoly_zamowienia();