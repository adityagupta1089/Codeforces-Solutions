import           Control.Monad
import           Data.List
import           Control.Arrow

($$) = flip ($)

readInts :: IO [Int]
readInts = map read . words <$> getLine

readInt :: IO Int
readInt = read <$> getLine

main :: IO ()
main = print "Hello World"
