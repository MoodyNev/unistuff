pow :: Int -> Int -> Int
pow _ 0 = 1
pow a b = a * pow  a (b-1)

{-consider 0 and negative numbers-}
isDiv :: Int -> Int -> Bool
isDiv a b = divRest a b == 0

divRest :: Int -> Int -> Int
divRest a b = if a < b then a else divRest (a - b) b

sumUp :: [Int] -> Int
sumUp [] = 0
sumUp (x:xs) = x + sumUp xs

multList :: [Int] -> [Int] -> [Int]
multList _ [] = []
multList [] _ = []
multList (x:xs) (y:ys) = (x * y) : multList xs ys 

binRep :: Int -> (Int, [Int])
-- 0
binRep 0 = (0, [0])
-- rest
binRep n = (sign, binar betrag)
  where
    --vorzeichen
    sign 
      | n > 0     = 1
      | otherwise = -1  -- also n < 0

    -- ich mach die zahl positiv
    betrag 
      | n > 0     = n
      | otherwise = n * (-1)

    binar 0 = []
    binar x = binar (div x 2) ++ [rem x 2]


existsPath :: [(Int,Int)] -> Int -> Int -> Bool
existsPath _ x y | x == y = True

-- Rekursiver Schritt
existsPath es x y = 
    let 
        -- SCHRITT A: Finde alle direkten Nachbarn von x
        -- (Suche alle Paare, wo der Start gleich x ist, und nimm das Ziel)
        nachbarn = [ ziel | (start, ziel) <- es, start == x ]

        -- SCHRITT B (Der Trick): Entferne alle Kanten, die bei x starten.
        -- Wir bauen eine neue Liste 'restKanten', die nur Kanten enthält,
        -- wo der Start NICHT x ist (s /= x).
        restKanten = [ (s, z) | (s, z) <- es, s /= x ]

        -- SCHRITT C: Die Hilfsfunktion (Checkt alle Nachbarn nacheinander)
        checkeAlle [] = False -- Keine Nachbarn mehr übrig? Dann Sackgasse.
        checkeAlle (n:ns) = 
            -- Versuche den Weg über den aktuellen Nachbarn 'n' (mit weniger Kanten!)
            existsPath restKanten n y 
            -- ODER (||) versuche die anderen Nachbarn 'ns'
            || checkeAlle ns
            
    in 
        checkeAlle nachbarn

isConnected :: [(Int,Int)] -> Bool
isConnected es =
    let
        -- SCHRITT 1: Alle Knoten finden
        -- Wir holen uns alle Startpunkte (u) und alle Endpunkte (v) aus der Liste
        rawNodes = [ u | (u,_) <- es ] ++ [ v | (_,v) <- es ]

        -- Hilfsfunktion: Duplikate entfernen (damit wir jeden Bahnhof nur 1x testen)
        unique [] = []
        unique (x:xs) = x : unique [ y | y <- xs, y /= x ]
        
        nodes = unique rawNodes
    in
        -- SCHRITT 2 & 3: Die Prüfung
        -- "and" gibt nur True zurück, wenn ALLES in der Liste True ist.
        -- Wir testen: Für jedes x aus nodes und jedes y aus nodes...
        and [ existsPath es x y | x <- nodes, y <- nodes ]

