main :: IO ()
main = do
    [n, m, s] <- map read . words <$> getLine
    let (q, r) = (n - 1) `divMod` s
    let (q', r') = (m - 1) `divMod` s
    print $ (q + 1) * (r + 1) * (q' + 1) * (r' + 1)
