import           Data.List
import           Control.Monad
import qualified Data.Set                      as Set
import           Data.Char
import           Data.Int

fromBinary :: String -> Int64
fromBinary = fromBinary' . reverse

fromBinary' :: String -> Int64
fromBinary' []       = 0
fromBinary' (x : xs) = fromIntegral (ord x - ord '0') + (2 * fromBinary' xs)

toBinary :: Int64 -> Int64 -> String
toBinary m = reverse . toBinary' m

toBinary' :: Int64 -> Int64 -> String
toBinary' 0 _ = []
toBinary' m x = chr (fromIntegral r + ord '0') : toBinary' (m - 1) q
    where (q, r) = divMod x 2

main :: IO ()
main = do
    t <- read <$> getLine
    replicateM_ t $ do
        n : m : _ <- map read . words <$> getLine :: IO [Int64]
        as        <- map fromBinary <$> replicateM (fromIntegral n) getLine
        let ans = solve m n (Set.fromList as)
        putStrLn . toBinary m $ ans

solve :: Int64 -> Int64 -> Set.Set Int64 -> Int64
solve m n as = go lo hi as (div (k + 1) 2)
  where
    lo = 0
    hi = 2 ^ m - 1
    k  = 2 ^ m - n

go :: Int64 -> Int64 -> Set.Set Int64 -> Int64 -> Int64
go lo hi as k | lo > hi            = error "Wrong recursion"
              | k <= leftCount     = go lo (mid - 1) left k
              | hasMid             = go (mid + 1) hi right (k - leftCount)
              | k == leftCount + 1 = mid
              | otherwise          = go (mid + 1) hi right (k - leftCount - 1)
  where
    mid                   = div (lo + hi) 2
    (left, hasMid, right) = Set.splitMember mid as
    leftSize              = fromIntegral $ Set.size left
    leftCount             = mid - lo - leftSize

