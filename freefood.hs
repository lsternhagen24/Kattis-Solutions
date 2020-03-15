import Data.List
import Control.Monad

--Solution to Kattis Problem Free Food
--https://open.kattis.com/problems/freefood

-- this is haskell code, a=list of found int, b = original, c = current string number , d = current value, e = sum
countUnique :: ( [Int],  [String], Int, Int, Int) -> (Int)

countUnique (a, b, c, d,e) = 
--only return when we have gone through all strings from input
  if c >= length(b) then e
--if our current value is greater than the upper value go to the next string
  else if d > (read (drop ((elemIndices ' ' (b!!c))!!0) (b!!c))::Int)
  then countUnique (a,b,c+1, (read (take ((elemIndices ' ' (b!!(c+1)))!!0) (b!!(c+1)))::Int), e)
--otherwise if the current value has not been added to our list yet then add it and increment our total
  else if not (elem d a) then countUnique (d:a, b, c, d+1, e+1)
--otherwise just move on to the next value
  else countUnique (a, b,c,d+1,e)


main = do
-- get first line
    line <- getLine 
-- get all following lines and call function
    inputs <- replicateM (read line) getLine
    let out = countUnique([], inputs, 0, (read (take ((elemIndices ' ' (inputs!!0))!!0) (inputs!!0))::Int), 0)
    print out
