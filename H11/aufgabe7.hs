-- IT IS 2 AM, OK BACK TO WORK

data MIU = I 
         | U 
         -- bro, das kam vorher nicht aber sonst kriege ich den Fehler nicht weg
         deriving (Show, Eq)

data Tree a = Node a [Tree a]
            | Nil deriving Show

-- AUFGABE A I)

-- Regel 1
-- wenn mit I endet dann U
progressR1 :: [MIU] -> [[MIU]]
progressR1 xs 
    -- gpt sagt null checken 
    -- Fehler ist hier, ohne Eq will er das nicht verglichen
    | not (null xs) && last xs == I = [xs ++ [U]] 
    | otherwise                     = []

-- Regel 2
-- verdopple
progressR2 :: [MIU] -> [[MIU]]
progressR2 xs = [xs ++ xs]

-- Regel 3
-- alle III durch U ersetzen (warum auch immer)
progressR3 :: [MIU] -> [[MIU]]
progressR3 (I:I:I:xs) = (U:xs) : map (I:) (progressR3 (I:I:xs))
progressR3 (x:xs)     = map (x:) (progressR3 xs)
progressR3 []         = []

-- Regel 4
-- UU löschen
progressR4 :: [MIU] -> [[MIU]]
progressR4 (U:U:xs) = xs : map (U:) (progressR4 (U:xs))
progressR4 (x:xs)   = map (x:) (progressR4 xs)
progressR4 []       = []

-- AUFGABE A II)
progress :: [MIU] -> [[MIU]]
progress xs = progressR1 xs ++ progressR2 xs ++ progressR3 xs ++ progressR4 xs

-- AUFGABE B I)
buildTree :: (a -> [a]) -> a -> Tree a
buildTree f val = Node val (map (buildTree f) (f val))
-- Das ist pure Magie: f val gibt die Liste der nächsten Zustände.
-- map (buildTree f) macht daraus wieder Bäume. Das hört nie auf (lazy evaluation).

-- AUFGABE B II)
nats :: Tree Int
nats = buildTree (\i -> [2*i + 1, 2*i + 2]) 0

-- AUFGABE B III)
miuTree :: Tree [MIU]
miuTree = buildTree progress [I]

-- AUFGABE C I)
getLayer :: Int -> Tree a -> [a]
getLayer _ Nil = []
getLayer 0 (Node val _) = [val]
getLayer k (Node _ children) = concatMap (getLayer (k-1)) children

-- AUFGABE C II)
loesungCii :: [[MIU]]
loesungCii = filter (\xs -> length xs <= 4) (getLayer 4 miuTree)