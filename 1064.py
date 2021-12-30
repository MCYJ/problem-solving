# madaniel47
# 1064

xa, ya, xb, yb, xc, yc = map(int, input().split())

abVecX = xa - xb
abVecY =  ya - yb
abVecSize = abVecX**2+abVecY**2

bcVecX = xb - xc
bcVecY = yb - yc
bcVecSize = bcVecX**2+bcVecY**2

caVecX = xc - xa
caVecY = yc - ya
caVecSize = caVecX**2+caVecY**2

if (abVecX*bcVecX+abVecY*bcVecY)**2/(abVecSize*bcVecSize) == 1 or (abVecX*bcVecX+abVecY*bcVecY)**2/(abVecSize*bcVecSize) == -1:
    print('-1.0')
else:
    lst = [abVecSize**(1/2), bcVecSize**(1/2), caVecSize**(1/2)]
    lst.sort()
    print("% .10f" % (2*(lst[-1]-lst[0])))