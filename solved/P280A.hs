import Data.List

main :: IO ()
main = do
  [w, h, a] <- map read . words <$> getLine
  let a' = min a (180 - a) * pi / 180
  let pts = [(w/2, h/2), (w/2, -h/2), (-w/2,-h/2), (-w/2,h/2)] :: [(Double, Double)]
  let pts' = map (rotate a') pts
  let lines = zip pts (tail $ cycle pts)
  let lines' = zip pts' (tail $ cycle pts')
  let ints = concatMap (getints lines') lines
  print . area . uniq $ sortOn theta ints

uniq :: Eq a => [a] -> [a]
uniq [] = []
uniq [x] = [x]
uniq (x:y:xs)
  | x == y = uniq (x:xs)
  | otherwise = x : uniq (y:xs)

rotate :: Floating b => b -> (b, b) -> (b, b)
rotate a (x, y) = (x * cos a - y * sin a, x * sin a + y * cos a)

theta :: RealFloat a => (a, a) -> a
theta (x, y) = atan2 y x

getints :: (Foldable t, Ord a, Fractional a) =>
             t ((a, a), (a, a)) -> ((a, a), (a, a)) -> [(a, a)]
getints xs y = concatMap (`getints'` y) xs

getints' :: (Ord a, Fractional a) =>
              ((a, a), (a, a)) -> ((a, a), (a, a)) -> [(a, a)]
getints' l'@((x1', y1'), (x2', y2')) l@((x, y), (x', y'))
  | x == x' =
    let y'' = y1' + (x - x1') / (x2' - x1') * (y2' - y1')
    in [(x, y'') | min y y' <= y'' && y'' <= max y y']
  | y == y' = map swap $ getints' (swap' l') (swap' l)
  | otherwise = []
  where
    swap (a, b) = (b, a)
    swap' (p1, p2) = (swap p1, swap p2)

area :: Fractional b => [(b, b)] -> b
area ps =
  let
    xs = map fst ps
    ys = map snd ps
  in
    0.5 * abs (sum $ zipWith4 (\x y y' x' -> x * y - y' * x') xs (tail $ cycle ys) ys (tail $ cycle xs))
