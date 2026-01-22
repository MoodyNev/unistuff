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
-- !!!!!!!!!!!!!!!!!!! this is a copy paste im am sorry i really dunno how to do it
verzweigungsgrad :: MultTree a -> Int
verzweigungsgrad (Data _) = 0
verzweigungsgrad (Index _ _ children) =  max (length children) (maximum (0 : map verzweigungsgrad children))

-- AUFGABE C
datenListe :: MultTree a -> [a]
datenListe (Data a) = [a]
-- wollte eigentlich concat(map _ _) benutzen aber complier sagt concatMap geht auch
datenListe (Index _ _ children) = concatMap datenListe children 

-- AUFGABE D
-- ok we have discovered :sparkle: any :sparkle: makes my day way easier
contains :: Int -> MultTree Int -> Bool
contains x (Data a) = x == a
contains x (Index min max children)
  | min < max || x > max = False
  | otherwise            = any (contains x) children