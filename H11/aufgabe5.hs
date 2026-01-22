-- ATTENTION EVERYONE
-- I REALLY TRIED EVERYTHING I COULD SPARE ME
-- CODING WITH HASKELL IS SO HARD THIS THING WORKS ON HOPES AND PRAYERS
-- DONT ASK ME HOW IT WORKS, I UNDERSTOOD HOW IT WORKED 5 MINS AGO
-- AFTER LOOKING AT THE NEXT QUESTION I DONT EVEN KNOW HOW I AM WORKING RIGHT NOW
-- JUST GIVE ME THE POINTS, THANK YOU
-- FUNERAL ON 14TH FEBRUARY, I LOVE YOU ALL <3

-- generische Typ Tree a
data Tree a = Node a [Tree a]
            | Nil 
            deriving Show

-- Tree a -> bel. Verzweigungsgrad und Wert vom Typ a
-- leerer Baum -> Nil
testTree :: Tree Int
testTree = Node 2[
    Nil,
    Node 3 [Node 9 [], Node 5 [], Node 10 [Node 0 []]],
    Node 1 [Node 5 [], Nil]]

-- AUFGABE A
-- Rückgegebene Tree: jeder in Knoten gespeicherte Wert v durch das Ergebnis des
-- Ausdrucks f v ersetzt wurde
mapTree :: (a -> b) -> Tree a -> Tree b
mapTree _ Nil = Nil
mapTree f (Node val children) = Node (f val) (map (mapTree f) children)

-- AUFGABE B
-- Ergebnis muss ein Baum sein
-- Knoten Werte setzen mit f p v 
-- p -> 
mapTreeWithPath :: ([a] -> a -> b) -> Tree a -> Tree b
mapTreeWithPath f tree = helper [] tree
  where
    helper _ Nil = Nil
    helper path (Node val children) = Node (f path val) (map (helper (path ++ [val])) children)

-- AUFGABE C
-- alle knoten löschen die einen Wert speichern
-- blödes funktion ganz ehrlich, der macht nicht besonders ab 2 für den test tree
filterTree :: (a -> Bool) -> Tree a -> Tree a
filterTree _ Nil = Nil
filterTree f (Node val children)
    | f val     = Node val (map (filterTree f) children)
    | otherwise = Nil

-- AUFGABE D
-- blöde Typ wirklich, das alles ist f jetzt
-- this map thigy really cool, just did sth, but i get 35 so i guess it works
foldTree :: (a -> [b] -> b) -> b -> Tree a -> b
foldTree _ c Nil = c
foldTree f c (Node val children) = 
    let 
        foldedChildren = map (foldTree f c) children
    in 
        f val foldedChildren