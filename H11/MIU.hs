-- von Aufgabe 5
data Tree a = Node a [Tree a]
            | Nil deriving Show

-- utility

truncateAtLevel :: Int -> Tree a -> Tree a
truncateAtLevel _  Nil        = Nil
truncateAtLevel n (Node a ts)
  | n < 0 = Nil
  | otherwise =  Node a (map (truncateAtLevel (n-1)) ts)

-- start

data MIU = I | U deriving Show
