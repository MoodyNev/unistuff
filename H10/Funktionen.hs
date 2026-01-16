pow :: Int -> Int -> Int
pow a b = if (b<0) || (b==0) then 1 else a* pow a (b-1)

isDiv :: Int -> Int -> Bool
isDiv a b = if (b==0)||((a<b) && (a /= 0))||(doSub a b >0) then False else True


doSub :: Int -> Int -> Int 
doSub a b = if(a==0)||(b==0)|| (a<b) then a else doSub (a-b) b 

sumUp :: [Int] -> Int
sumUp [] = 0
sumUp (x:ys) = x + sumUp ys

multLists :: [Int] -> [Int] -> [Int]
multLists [] _ = []
multLists _ [] = []
multLists (x:xs) (y:ys) = (x*y): multLists xs ys

binRep :: Int -> (Int, [Int])
binRep n = 
             let e  | n==0 = 0
                    | n>0 = 1 
                    |otherwise = -1      
                 x  = if n<0 then n*(-1) else n 
                 toBinListe :: Int -> [Int]
                 toBinListe 0 = [0]
                 toBinListe 1 = [1]
                 toBinListe y =   rem y 2: toBinListe (div y 2) 
                 
                 reverseList :: [Int] -> [Int]
                 reverseList xs = rep xs []

                 rep :: [Int] -> [Int] -> [Int]
                 rep [] acc     = acc
                 rep (y:ys) acc = rep ys (y:acc)
   
                 ys = reverseList(toBinListe x)
             in (e,ys)

testGraph = [(1,2),(2,3),(3,1),(4,5),(3,4)]::[(Int,Int)]
list=[]:: [Int]

existsPath:: [(Int,Int)] -> Int -> Int -> Bool
existsPath [] _ _ = False
existsPath _ x y | x==y = True
existsPath ((a,b):res) x y| (a==x) && (b==y) = True
                          | a==x = existsPath (removeAlleKanten res a) b y 
                          | otherwise = existsPath (addMissedNode res (a,b)) x y

removeAlleKanten :: [(Int,Int)] -> Int -> [(Int,Int)]
removeAlleKanten [] _ = []
removeAlleKanten ((a,b):res) y | b==y = removeAlleKanten res y
                               | otherwise = (a,b):removeAlleKanten res y 

addMissedNode::[(Int,Int)]-> (Int,Int) -> [(Int,Int)]
addMissedNode [] x = [x]
addMissedNode ((a,b):res) x = (a,b):addMissedNode res x     

isConnected :: [(Int, Int)] -> Bool
isConnected [] = False
isConnected es = 