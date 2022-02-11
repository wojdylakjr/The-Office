--min i max srednich zarobkow na pozycji
select
    min(nazwa),
    avg(pracownik.pensja + pracownik.premia)
from
    biuro.pracownik
    join biuro.stanowisko on pracownik.id_stanowisko = stanowisko.id_stanowisko
group by
    pracownik.id_stanowisko
having
    avg(pracownik.pensja + pracownik.premia) = (
        select
            max(x.avg)
        from
            (
                select
                    avg(pensja + premia) as avg
                from
                    biuro.pracownik
                group by
                    id_stanowisko
            ) as x
    )
    or avg(pracownik.pensja + pracownik.premia) = (
        select
            min(x.avg)
        from
            (
                select
                    avg(pensja + premia) as avg
                from
                    biuro.pracownik
                group by
                    id_stanowisko
            ) as x
    );