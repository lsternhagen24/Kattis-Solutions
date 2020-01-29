import Data.List
correct :: (String, String, Integer) -> (Bool)
--base case for guessing all correct letters
correct ([], b, c) = True
-- base case for running out of lives
correct (a, b, 0) = False
correct (a, b, c) =
-- if current guess from second string is in first string
 if isInfixOf (take 1 b) a
-- then filter out that letter from first string and recurse
 then correct (filter (/= (b!!0)) a, (drop 1 b), c)
-- else lose a life and recurse
 else correct (a, (drop 1 b), c-1)


main = do
-- get first line
    line <- getLine 
    do
-- get second line and print output
        line2 <- getLine
        if correct (line,line2,10) then putStrLn "WIN"
        else putStrLn "LOSE"