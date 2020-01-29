sumDigits :: (String, [Int]) -> [Int]
updateElement :: (Int, [Int], Int ) -> [Int]
getMin :: ([Int], Int, Int, Int) -> [Int]
getOutput:: ([Int], Int, [Int]) -> [Int]
iToS:: ([Int],String) -> String

getMin ([],b, c, d) = [b, c]
getMin (a,b,c,d) = if b > (a!!0) then getMin(drop 1 a, a!!0, d, d+1)
else getMin (drop 1 a, b, c, d+1)

getOutput (a, i, o) = if (negate 1) == (getMin(a, 100000, 0,0)!!0) then o
else if i==0 && getMin(a,100000, 0,0)!!1 == 0 then getOutput(updateElement((getMin(drop 1 a, 100000, 0,0)!!1)+1, a, -1), i+1, ([(getMin(drop 1 a, 100000, 0,0)!!1)+1]++o) )
else getOutput(updateElement(getMin(a,100000,0,0)!!1,a,-1), i+1, (o ++ [(getMin(a,100000,0,0)!!1)]))

updateElement (n , xs, i) = take n xs ++ [(xs!!n)+i] ++ drop (n + 1) xs

sumDigits ([], b) = b
sumDigits (a, b) = sumDigits ( (drop 1 a), (updateElement ( (read (take 1 a)::Int), b, 1 )) )

iToS ([], b ) = b
iToS (a, b ) = iToS(drop 1 a, b++(show (a!!0)))

main =  do
        line <- getLine 
        let w = sumDigits (line,[0,0,0,0,0,0,0,0,0,0])
        let r = getOutput(w, 0, [])
        let t = iToS(r,"")
        putStrLn t
