second :: [Int] -> Int
second (x:y:xs) = y
second xs       = 0

naturalsFromTo :: Int -> Int -> [Int]
naturalsFromTo n m = if n <= m then n:naturalsFromTo (n+1) m else []

append :: [Int] -> [Int] -> [Int]
append []     ys = ys
append (x:xs) ys = x:append xs ys

doubleList :: [Int] -> [Int]
doubleList xs = append xs xs
