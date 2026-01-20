-- es gibt zwei Arten von Knoten
-- Index-Knoten: speichern zwei Werte und können bel. Nachfolger haben
-- Daten-Knoten: speichern nur einen Wert, keine Nachfolger

-- AUFGABE A
-- MultTree a der zur Darstellung Baum
data MultTree a = Data a
                | Index a a [MultTree a]
                deriving Show

-- wenn man ein Typ [] hat muss man bei der tree das auch benutzen
t1 :: MultTree Int
t1 = Index 3 42
        [
            Index 3 15
                [
                    Data 3,
                    Data 11,
                    Data 12
                ],
        
            Index 19 42
                [
                    Data 42,
                    Data 23
                ]
        ]

-- AUFGABE B
-- bekommt einen Mehrwegbaum
-- berechnet wie viele Nachfolger ein Knoten in den Baum Maximal gibt
verzweigungsgrad :: MultTree a -> Int
verzweigungsgrad (Data _) = 1
--verzweigungsgrad (Index _ _ children) =
--    let
--        ergebnis = 0
--    in
--        ergebnis = max()

count :: [MultTree a] -> Int -> Int
count [] _ = 1
count a b = count a (b+1)
