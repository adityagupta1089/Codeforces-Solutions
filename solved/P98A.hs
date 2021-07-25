import Data.List

main :: IO ()
main = do
    vals <- getLine
    print $ getCnt vals

getCnt xs = length . nubBy (cubeEq) . perms $ xs
    where
        perms :: Eq a => [a] -> [[a]]
        perms [x] = [[x]]
        perms xs = concatMap (\x -> map (x:) (perms (removeFirst x xs))) xs
        removeFirst :: Eq a => a -> [a] -> [a]
        removeFirst x (y:ys)
            | x == y = ys
            | otherwise = y : removeFirst x ys

cubeEq xs ys = any (==ys) (eqs xs)
    where
        -- z axis
        eqs :: [Char] -> [[Char]]
        eqs [f,b,l,r,u,d] =
            concatMap eqs' [
                [f,b,u,d,r,l],
                [f,b,r,l,d,u],
                [f,b,d,u,r,l],
                [f,b,l,r,u,d]
            ]
        -- x axis
        eqs' :: [Char] -> [[Char]]
        eqs' [f,b,l,r,u,d] =
            concatMap eqs'' [
                [f,b,l,r,u,d],
                [d,u,l,r,f,b],
                [b,f,l,r,d,u],
                [u,d,l,r,b,f]
            ]
        -- y axis
        eqs'' :: [Char] -> [[Char]]
        eqs'' [f,b,l,r,u,d] = [
                [f,b,l,r,u,d],
                [r,l,f,b,u,d],
                [b,f,r,l,u,d],
                [l,r,b,f,u,d]
            ]
