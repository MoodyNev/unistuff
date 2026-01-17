--AUFGABE A
--wir machen eine mobile nach wohoo
data Mobile b = Stern
              | Seepferdchen
              | Elefant (Mobile b)
              | Kaenguru b (Mobile b) (Mobile b)
              deriving Show

mobileLinks :: Mobile Int
mobileLinks = Kaenguru 1
                (Elefant
                    (
                    Kaenguru 2
                        Stern
                        (Kaenguru 3
                            Seepferdchen
                            Stern
                        )
                    )
                )
                Seepferdchen

-- du kannst gerne die mobile rechts machen

--AUFGABE B
--anzahl der mobiles
count :: Mobile a -> Int
count Seepferdchen                      = 1
count Stern                             = 1
--count _ = 1
count (Elefant sub)            = 1 + count sub
count (Kaenguru _ sub1 sub2)   = 1 + count sub1 + count sub2

--AUFGABE C
liste :: Mobile a -> [a]
liste Stern                     = []
liste Seepferdchen              = []
liste (Elefant sub)             = liste sub
liste (Kaenguru b sub1 sub2)    = [b] ++ liste sub1 ++ liste sub2

--AUFGABE D
greife :: Mobile a -> Int -> Mobile a
greife m                        1 = m
greife (Elefant sub)            i = greife sub (i-1)
greife (Kaenguru _ sub1 sub2)   i 
    | (i-1) <= count sub1 = greife sub1 (i-1)
    | otherwise           = greife sub2 (i-1-count sub1)