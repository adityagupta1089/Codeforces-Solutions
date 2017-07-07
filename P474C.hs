import           Control.Monad
import           Data.List

data Vector = Vector Int Int Int Int deriving (Show, Eq)

rotate :: Vector -> Vector
rotate (Vector a b x y) = Vector a b (a - beta) (b + alpha)
    where
        alpha = x - a; beta = y - b

isSquare :: [Vector] -> Bool
isSquare vecs@(v1:vs@[v2, v3, v4]) =
        dis_x /= -1 &&
        dist vb vd == dis_x &&
        dist vc vb == dis_z && dist vc vd == dis_z &&
        dis_x /=0 && dis_z /= 0
    where
        dist (Vector _ _ x y) (Vector _ _ x' y') = (x'-x)^2+(y'-y)^2
        [d1,d2,d3] = map (dist v1) vs
        (dis_z, dis_x, vc)
            | d1 == d2 = (d1, d3, v4)
            | d2 == d3 = (d2, d1, v2)
            | d1 == d3 = (d1, d2, v3)
            | otherwise = (-1, -1, v1)
        [vb, vd] = delete vc vs

main :: IO ()
main = do
    n <- fmap (head . map read . words) getLine
    forM_ [1..n] (\_ -> do
            moles <- replicateM 4 $ do
                [x, y, a, b] <- fmap (map read . words) getLine
                return $ Vector a b x y
            let squares = filter (isSquare . map snd) $ mapM (zip [0..] . take 4 . iterate rotate) moles
            print $ if null squares
                then -1
                else minimum $ map (sum . map fst) squares
        )
