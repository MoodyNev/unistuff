-- es gibt zwei Arten von Knoten
-- Index-Knoten: speichern zwei Werte und können bel. Nachfolger haben
-- Daten-Knoten: speichern nur einen Wert, keine Nachfolger

-- AUFGABE A
-- MultTree a der zur Darstellung Baum
data MultTree a = Data a
                | Index1 a (MultTree a)
                | Index2 a [MultTree a]
                | Index3 a (MultTree a) (MultTree a) (MultTree a)
                deriving Show

t1 :: MultTree Int
t1 = Index2 4
        (Index3 3
            (
                Data 3
                Data 11
                Data 12
            )
        )
        (Index2 19
            (
                Data 42
                Data 23
            )
        )