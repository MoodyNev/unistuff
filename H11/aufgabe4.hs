data List a = Nil 
    | Cons a (List a) 
    deriving Show

--3:5:7:[]
--3:5:7 -> cons
--[] Nil
list :: List Int
list = Cons (-3) (Cons 14 (Cons (-6) (Cons 7 (Cons 1 Nil))))

blist :: List Int
blist = Cons 1 (Cons 1 (Cons 0 (Cons 0 Nil)))

mlist :: List Int
mlist = Cons 3 (Cons 5 (Cons 7 Nil))

--AUFGABE A
filterlist :: (a->Bool) -> List a -> List a
filterlist _ Nil = Nil
filterList g (Cons x xs)
--                 x:xs
    | g x = Cons x (filterList g xs)
    | otherwise = filterList g xs

--AUFGABE B
divisibleAux :: Int -> Int -> Bool
divisibleAux teiler x = x `mod` teiler == 0
--                      mod x teiler == 0

divisibleBy :: Int -> List Int -> List Int
divisibleBy teiler xs = filterList(\x -> divisibleAux teiler) xs

--AUFGABE C
foldListr :: (a -> b -> b) -> b -> List a -> b
foldListr _ z Nil = z
foldListr op z (Cons x xs) = x `op` (foldListr op z xs)

foldListl :: (a -> b -> b) -> b -> List a -> b
foldListl _ z Nil = z
foldListl op z (Cons x xs) = foldListl op (z `op` x) xs


-- foldr (-) 0 [3,5,7] 
-- (3+(5+(7+0)))
-- foldr -> rechst nach links 3-(5-(7+0))
-- Ausgabe: 5
-- foldl -> links nach rechts ((0-3)-5)-7
-- Ausgabe: -15

-- AUFGABE E
mapList :: (a -> b) -> List a -> List b
mapList f xs = foldListr (\x acc -> (f x) `Cons` acc) [] Nil xs